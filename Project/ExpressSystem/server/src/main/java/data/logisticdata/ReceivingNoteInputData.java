package data.logisticdata;

import data.database.DatabaseManager;
import data.statisticdata.LogInsertData;
import data.statisticdata.OrderInquiryData;
import dataservice.exception.ElementNotFoundException;
import dataservice.logisticdataservice.ReceivingNoteInputDataService;
import po.ReceivingNotePO;
import util.ResultMsg;
import util.enums.DocState;
import util.enums.GoodsState;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/11/10.
 */
public class ReceivingNoteInputData extends NoteInputData implements ReceivingNoteInputDataService {

    private LogInsertData logInsertData;
    private OrderInquiryData orderDataService;

    @Override
    public ResultMsg insert(ReceivingNotePO po) throws RemoteException, SQLException, ElementNotFoundException {
        String sql = "insert into `note_receive_note` ( `barcode`, `time`, `receiveCustomer`) " +
                "values ( ?, ?, ?)";
        Connection connection = DatabaseManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,po.getBarcode());
        statement.setString(2,po.getTime());
        statement.setString(3,po.getReceiveCustomer());
        statement.executeUpdate();
        statement.close();

        //记录系统日志
        logInsertData = new LogInsertData();
        logInsertData.insertSystemLog("营业厅业务员?新增收件单,单据编号:" + po.getBarcode());

        //等待总经理审批过程,反复查询
        DocState result = this.waitForCheck("note_receive_note",
                "barcode", po.getBarcode());
        ResultMsg resultMsg = new ResultMsg(false);
        //审批通过
        if (result == DocState.PASSED) {
            System.out.println("ReceivingNote is passed!");
            //追加修改物流信息
            orderDataService = new OrderInquiryData();
            orderDataService.updateOrder("", GoodsState.COMPLETE,"");
            resultMsg.setPass(true);
            //审批没有通过
        } else {
            System.out.println("ReceivingNote is failed!");
            String advice = this.getFailedAdvice("note_receive_note",
                    "barcode", po.getBarcode());
            resultMsg.setMessage(advice);
        }
        //操作结束
        DatabaseManager.releaseConnection(connection, statement, null);
        return resultMsg;
    }

    public ArrayList<ReceivingNotePO> getReceivingNote() throws SQLException {
        ArrayList<ReceivingNotePO> result = new ArrayList<>();
        Connection connection = DatabaseManager.getConnection();
        String sql = "select * from `note_receive_note` where isPassed = 0";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        ReceivingNotePO receivingNotePO;
        while(resultSet.next()){
            String barcode = resultSet.getString(1);
            String receiver = resultSet.getString(2);
            String time = resultSet.getString(3);
            receivingNotePO = new ReceivingNotePO(barcode,receiver,time);
            result.add(receivingNotePO);
        }
        DatabaseManager.releaseConnection(connection, statement, resultSet);
        return result;
    }

}
