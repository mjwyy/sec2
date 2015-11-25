package data.logisticdata;

import data.database.DatabaseManager;
import data.statisticdata.OrderInquiryData;
import dataservice.exception.ElementNotFoundException;
import dataservice.logisticdataservice.ArrivalNoteOnServiceDataService;
import po.ArrivalNoteOnServicePO;
import po.DeliverNoteOnServicePO;
import util.BarcodeAndState;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/11/16.
 */
public class ArrivalNoteOnServiceData implements ArrivalNoteOnServiceDataService {

    private OrderInquiryData orderDataService;

    @Override
    public boolean insertArrivalNote(ArrivalNoteOnServicePO po) throws RemoteException, SQLException, ElementNotFoundException {
        Connection connection = DatabaseManager.getConnection();
        //新增到达单
        String sql = "insert into `note_arrival_on_service` ( " +
                "`arrivalKind`, `from`, `barcodes`, `TransferNumber`, `date`)" +
                " values ( ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        //区分到达类型
        String arrivalKind = po.isTransit() ? "中转到达" : "营业厅到达";
        statement.setString(1, arrivalKind);
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
        int result1 = statement.executeUpdate();
        statement.close();
        //等待总经理审批过程

        //审批通过,追加修改物流信息
        orderDataService = new OrderInquiryData();
        for (BarcodeAndState history : barcodeAndState) {
            //TODO 如何获得业务员名称与地点
            orderDataService.updateOrder(history.getBarcode(),
                    history.getState(), "货物已到达某某营业厅!");
        }


        //记录系统日志

        DatabaseManager.releaseConnection(connection, statement, null);
        return result1 > 0;
    }

    @Override
    public ArrayList<ArrivalNoteOnServicePO> findArrivalNote(ArrivalNoteOnServicePO po) throws RemoteException {
        return null;
    }

    @Override
    public ArrayList<ArrivalNoteOnServicePO> findAllArrivalNote() throws RemoteException {
        return null;
    }

    @Override
    public boolean insertDeliverNote(DeliverNoteOnServicePO po) throws RemoteException {
        return false;
    }

    @Override
    public ArrayList<DeliverNoteOnServicePO> findDeliverNote(DeliverNoteOnServicePO po) throws RemoteException {
        return null;
    }

    @Override
    public ArrayList<DeliverNoteOnServicePO> findAllDeliverNote() throws RemoteException {
        return null;
    }
}
