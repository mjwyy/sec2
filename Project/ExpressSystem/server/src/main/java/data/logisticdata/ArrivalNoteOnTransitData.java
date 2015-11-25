package data.logisticdata;

import data.database.DatabaseManager;
import data.statisticdata.LogInsertData;
import data.statisticdata.OrderInquiryData;
import dataservice.exception.ElementNotFoundException;
import dataservice.logisticdataservice.ArrivalNoteOnTransitDataService;
import po.ArrivalNoteOnTransitPO;
import util.BarcodeAndState;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/11/10.
 */
public class ArrivalNoteOnTransitData implements ArrivalNoteOnTransitDataService {

    private OrderInquiryData orderDataService;
    private LogInsertData logInsertData;

    @Override
    public boolean insert(ArrivalNoteOnTransitPO po) throws RemoteException, SQLException, ElementNotFoundException {
        Connection connection = DatabaseManager.getConnection();
        String sql = "insert into `note_arrival_on_transit` " +
                "( `date`, `barcodes`, `departurePlace`, `centerNumber`, `transferNumber`) " +
                "values ( ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, po.getDate());
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<BarcodeAndState> barcodeAndState = po.getBarcodeAndStates();
        for (BarcodeAndState history : barcodeAndState) {
            stringBuilder.append(history.getBarcode());
            stringBuilder.append(';');
        }
        statement.setString(2, stringBuilder.toString());
        statement.setString(3, po.getDeparturePlace());
        statement.setString(4, po.getCenterNumber());
        statement.setString(5, po.getTransferNumber());
        //向数据库添加到达单
        int result1 = statement.executeUpdate();
        statement.close();
        //等待总经理审批过程,反复查询
        String id = po.getTransferNumber();
        while (true) {
            if (this.checkArrivalNote(id))
                break;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ArrivalNoteOnService is not passed yet...");
        }
        //审批通过,追加修改物流信息
        System.out.println("ArrivalNoteOnServicePO is passed!");
        orderDataService = new OrderInquiryData();
        for (BarcodeAndState history : barcodeAndState) {
            //TODO 如何获得业务员名称与地点
            orderDataService.updateOrder(history.getBarcode(),
                    history.getState(), "货物已到达某某营业厅!");
        }
        //记录系统日志
        logInsertData = new LogInsertData();
        logInsertData.insertSystemLog("某某营业员添加营业厅到达单,单据编号:" + po.getTransferNumber());
        //操作结束
        DatabaseManager.releaseConnection(connection, statement, null);
        return result1 > 0;
    }

    private boolean checkArrivalNote(String id) throws SQLException {
        Connection connection = DatabaseManager.getConnection();
        int result = 0;
        String sql = "select isPassed from note_arrival_on_transit" +
                " where transferNumber = '" + id + "'";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next())
            result = resultSet.getInt(1);
        DatabaseManager.releaseConnection(connection, statement, resultSet);
        return result == 1;
    }

    @Override
    public ArrayList<ArrivalNoteOnTransitPO> find(ArrivalNoteOnTransitPO po) throws RemoteException {
        ArrivalNoteOnTransitPO pox = new ArrivalNoteOnTransitPO();
        ArrayList<ArrivalNoteOnTransitPO> list =  new ArrayList<ArrivalNoteOnTransitPO>();
        list.add(pox);
        return list;
    }

    @Override
    public ArrayList<ArrivalNoteOnTransitPO> findAll() throws RemoteException {
        ArrivalNoteOnTransitPO pox = new ArrivalNoteOnTransitPO();
        ArrayList<ArrivalNoteOnTransitPO> list =  new ArrayList<ArrivalNoteOnTransitPO>();
        list.add(pox);
        return list;
    }
}
