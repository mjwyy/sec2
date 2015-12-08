package data.logisticdata;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import data.database.DatabaseManager;
import data.statisticdata.LogInsHelper;
import data.statisticdata.LogInsertData;
import data.statisticdata.OrderInquiryData;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import dataservice.logisticdataservice.ReceivingNoteInputDataService;
import po.ReceivingNotePO;
import util.ResultMsg;
import util.enums.DocState;
import util.enums.GoodsState;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/11/10.
 */
public class ReceivingNoteInputData extends NoteInputData implements ReceivingNoteInputDataService {

    private static final long serialVersionUID = 7218888874956257035L;

    public ReceivingNoteInputData() throws RemoteException {

    }

    @Override
    public ResultMsg insert(ReceivingNotePO po) throws RemoteException, ElementNotFoundException, InterruptWithExistedElementException {
        String sql = "insert into `note_receive_note` ( `barcode`, `time`, `receiveCustomer`) " +
                "values ( ?, ?, ?)";
        Connection connection = DatabaseManager.getConnection();
        PreparedStatement statement = null;
        ResultMsg resultMsg = new ResultMsg(false);

        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,po.getBarcode());
            statement.setString(2,po.getTime());
            statement.setString(3,po.getReceiveCustomer());
            statement.executeUpdate();
            return this.afterInsert(po);
        } catch (MySQLIntegrityConstraintViolationException e){
            throw new InterruptWithExistedElementException("");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        DatabaseManager.releaseConnection(connection, statement, null);
        return resultMsg;

    }

    private ResultMsg afterInsert(ReceivingNotePO po) throws ElementNotFoundException {
        ResultMsg resultMsg = new ResultMsg(false);
        LogInsHelper.insertLog(po.getOrganization()+" 业务员 "+po.getUserName()+
                "新增收件单,单据编号:" + po.getBarcode());
        DocState result = this.waitForCheck("note_receive_note",
                "barcode", po.getBarcode());

        if (result == DocState.PASSED) {
            ArrayList<String> bars = new ArrayList<>();
            bars.add(po.getBarcode());
            this.updateOrder("已被 "+po.getReceiveCustomer()+" 签收",bars);
            resultMsg.setPass(true);
            resultMsg.setMessage("收件单提交成功!");

        } else {
            String advice = this.getFailedAdvice("note_receive_note",
                    "barcode", po.getBarcode());
            resultMsg.setMessage(advice);
        }
        return resultMsg;
    }


}
