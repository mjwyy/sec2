package data.logisticdata;

import data.database.DatabaseManager;
import data.statisticdata.LogInsertData;
import data.statisticdata.OrderInquiryData;
import dataservice.exception.ElementNotFoundException;
import dataservice.logisticdataservice.ArrivalNoteOnServiceDataService;
import po.ArrivalNoteOnServicePO;
import po.DeliverNoteOnServicePO;
import util.BarcodeAndState;
import util.ResultMsg;
import util.enums.DocState;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/11/16.
 */
public class ArrivalNoteOnServiceData extends NoteInputData implements ArrivalNoteOnServiceDataService {

    private OrderInquiryData orderDataService;
    private LogInsertData logInsertData;

    @Override
    public ResultMsg insertArrivalNote(ArrivalNoteOnServicePO po) throws RemoteException, SQLException, ElementNotFoundException {
        Connection connection = DatabaseManager.getConnection();
        //新增到达单
        String sql = "insert into `note_arrival_on_service` ( " +
                "`arrivalKind`, `from`, `barcodes`, `TransferNumber`, `date`)" +
                " values ( ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        //区分到达类型
        int arrivalKind = po.isTransit() ? 1 : 2;
        statement.setInt(1, arrivalKind);
        statement.setString(2, po.getFrom());
        //存储所有条形码
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<BarcodeAndState> barcodeAndState = po.getBarcodeAndStates();
        for (BarcodeAndState history : barcodeAndState) {
            stringBuilder.append(history.getBarcode());
            stringBuilder.append(';');
        }
        statement.setString(3, stringBuilder.toString());
        statement.setString(4, po.getTransferNumber());
        statement.setString(5, po.getDate());
        //向数据库添加到达单
        statement.executeUpdate();
        statement.close();
        //记录系统日志
        logInsertData = new LogInsertData();
        logInsertData.insertSystemLog("营业员添加营业厅到达单,单据编号:" + po.getTransferNumber());
        //等待总经理审批过程,反复查询
        DocState result = this.waitForCheck("note_arrival_on_service",
                "TransferNumber", po.getTransferNumber());
        ResultMsg resultMsg = new ResultMsg(false);
        //审批通过
        if (result == DocState.PASSED) {
            System.out.println("ArrivalNoteOnServicePO is passed!");
            //追加修改物流信息
            orderDataService = new OrderInquiryData();
            for (BarcodeAndState history : barcodeAndState) {
                orderDataService.updateOrder(history.getBarcode(),
                        history.getState(), "货物已到达某某营业厅!");
            }
            resultMsg.setPass(true);
            //审批没有通过
        } else {
            System.out.println("ArrivalNoteOnServicePO is failed!");
            String advice = this.getFailedAdvice("note_arrival_on_service",
                    "TransferNumber", po.getTransferNumber());
            resultMsg.setMessage(advice);
        }
        //操作结束
        DatabaseManager.releaseConnection(connection, statement, null);
        return resultMsg;
    }

    @Override
    public ResultMsg insertDeliverNote(DeliverNoteOnServicePO po) throws RemoteException {
        return null;
    }
}
