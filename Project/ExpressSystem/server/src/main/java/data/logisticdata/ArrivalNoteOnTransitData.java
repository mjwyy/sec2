package data.logisticdata;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import data.database.DatabaseManager;
import data.logisticdata.barcode.BarcodeUtil;
import data.statisticdata.LogInsHelper;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import dataservice.logisticdataservice.ArrivalNoteOnTransitDataService;
import po.ArrivalNoteOnTransitPO;
import util.BarcodeAndState;
import util.ResultMsg;
import util.enums.DocState;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by kylin on 15/11/10.
 */
public class ArrivalNoteOnTransitData extends NoteInputData implements ArrivalNoteOnTransitDataService {

    private BarcodeUtil barcodeUtil;

    public ArrivalNoteOnTransitData() throws RemoteException {
        barcodeUtil = new BarcodeUtil();
    }

    @Override
    public ResultMsg insert(ArrivalNoteOnTransitPO po) throws RemoteException, ElementNotFoundException, InterruptWithExistedElementException {
        Connection connection = DatabaseManager.getConnection();
        String sql = "insert into `note_arrival_on_transit` " +
                "( `date`, `barcodes`, `departurePlace`, `centerNumber`, `transferNumber`) " +
                "values ( ?, ?, ?, ?, ?)";
        ResultMsg resultMsg = new ResultMsg(false);
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, po.getDate());
            ArrayList<BarcodeAndState> barcodeAndState = po.getBarcodeAndStates();
            statement.setString(2, barcodeUtil.getDBbarsFromBarAndStateList(barcodeAndState));
            statement.setString(3, po.getDeparturePlace());
            statement.setString(4, po.getCenterNumber());
            statement.setString(5, po.getTransferNumber());
            statement.executeUpdate();
            //向数据库插入单据后续的操作
            resultMsg = this.afterInsert(po);
        } catch (MySQLIntegrityConstraintViolationException e){
            throw new InterruptWithExistedElementException("");
        } catch (SQLException e) {
            e.printStackTrace();
            resultMsg.setMessage("无法添加中转中心到达单");
            LogInsHelper.insertLog(po.getOrganization()+" 业务员 "+po.getUserName()+" 添加中转中心到达单失败");
        }
        DatabaseManager.releaseConnection(connection, statement, null);
        return resultMsg;
    }

    private ResultMsg afterInsert(ArrivalNoteOnTransitPO po) throws ElementNotFoundException {
        //等待总经理审批过程,反复查询
        DocState result = this.waitForCheck("note_arrival_on_transit",
                "transferNumber", po.getTransferNumber());
        LogInsHelper.insertLog(po.getOrganization()+" 业务员 "+po.getUserName()+
                " 新增中转中心到达单,单据编号:" + po.getTransferNumber());
        ResultMsg resultMsg = new ResultMsg(false);
        //审批通过,追加修改物流信息
        if (result == DocState.PASSED) {
            this.updateOrder(po.getBarcodeAndStates(),"已到达"+po.getOrganization());
            resultMsg.setPass(true);
            resultMsg.setMessage("中转中心到达单提交成功!");
        //审批否决,获取总经理意见
        } else {
            String advice = this.getFailedAdvice("note_arrival_on_transit",
                    "transferNumber", po.getTransferNumber());
            resultMsg.setMessage(advice);
        }
        return resultMsg;
    }


}
