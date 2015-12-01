package data.logisticdata;

import data.database.DatabaseManager;
import data.logisticdata.barcode.BarcodeUtil;
import data.statisticdata.LogInsHelper;
import data.statisticdata.LogInsertData;
import data.statisticdata.OrderInquiryData;
import dataservice.exception.ElementNotFoundException;
import dataservice.logisticdataservice.ArrivalNoteOnServiceDataService;
import po.ArrivalNoteOnServicePO;
import po.DeliverNoteOnServicePO;
import util.BarcodeAndState;
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
 * Created by kylin on 15/11/16.
 */
public class ArrivalNoteOnServiceData extends NoteInputData implements ArrivalNoteOnServiceDataService {

    private BarcodeUtil barcodeUtil;

    public ArrivalNoteOnServiceData() throws RemoteException {
        barcodeUtil = new BarcodeUtil();
    }

    @Override
    public ResultMsg insertArrivalNote(ArrivalNoteOnServicePO po) throws RemoteException,  ElementNotFoundException {
        Connection connection = DatabaseManager.getConnection();
        //新增到达单
        String sql = "insert into `note_arrival_on_service` ( " +
                "`arrivalKind`, `from`, `barcodes`, `TransferNumber`, `date`)" +
                " values ( ?, ?, ?, ?, ?)";
        PreparedStatement statement = null;
        ResultMsg resultMsg = new ResultMsg(false);
        try {
            statement = connection.prepareStatement(sql);
            //区分到达类型
            int arrivalKind = po.isTransit() ? 1 : 2;
            statement.setInt(1, arrivalKind);
            statement.setString(2, po.getFrom());
            statement.setString(3, barcodeUtil.getDBbarsFromBarAndStateList(po.getBarcodeAndStates()));
            statement.setString(4, po.getTransferNumber());
            statement.setString(5, po.getDate());
            //向数据库添加到达单
            statement.executeUpdate();

            //记录系统日志
            LogInsHelper.insertLog(po.getOrganization()+" 业务员 "+po.getUserName()+
                    "添加营业厅到达单,单据编号:" + po.getTransferNumber());

            //等待总经理审批过程,反复查询
            DocState result = this.waitForCheck("note_arrival_on_service",
                    "TransferNumber", po.getTransferNumber());

            //审批通过
            if (result == DocState.PASSED) {
                System.out.println("ArrivalNoteOnServicePO is passed!");
                //追加修改物流信息
                this.updateOrder(po.getBarcodeAndStates(), "已到达"+po.getOrganization());
                resultMsg.setPass(true);
                //审批没有通过
            } else {
                System.out.println("ArrivalNoteOnServicePO is failed!");
                String advice = this.getFailedAdvice("note_arrival_on_service",
                        "TransferNumber", po.getTransferNumber());
                resultMsg.setMessage(advice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            resultMsg = new ResultMsg(false,"添加营业厅到达单失败");
        }
        DatabaseManager.releaseConnection(connection, statement, null);
        return resultMsg;
    }

    @Override
    public ArrayList<ArrivalNoteOnServicePO> getArrivalNoteOnService() throws RemoteException{
        ArrayList<ArrivalNoteOnServicePO> result = new ArrayList<>();
        Connection connection = DatabaseManager.getConnection();
        String sql = "select * from `note_arrival_on_service` where isPassed = 0";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            ArrivalNoteOnServicePO arrivalNoteOnServicePO;
            while(resultSet.next()){
                String date = resultSet.getString(1);
                String arrivalType = resultSet.getString(2);
                boolean isTransit = arrivalType.equals("中转到达");
                String transferNumber =  resultSet.getString(3);
                String from =  resultSet.getString(4);
                String barcodes =  resultSet.getString(5);
                ArrayList<BarcodeAndState> barcodeAndStates = barcodeUtil.getBarcodeAndStateFromDBbars(barcodes);
                arrivalNoteOnServicePO = new ArrivalNoteOnServicePO(date,isTransit,transferNumber,from,barcodeAndStates);
                result.add(arrivalNoteOnServicePO);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseManager.releaseConnection(connection, statement, null);
        return result;
    }

    @Override
    public ResultMsg insertDeliverNote(DeliverNoteOnServicePO po) throws RemoteException, ElementNotFoundException {
        Connection connection = DatabaseManager.getConnection();
        String sql = "insert into `note_delivery_on_service` ( `deliveryMan`, `id`, `barcodes`, `date`)" +
                " values ( ?, ?, ?, ?)";
        PreparedStatement statement = null;
        ResultMsg resultMsg = new ResultMsg(false);
        try {
            statement = connection.prepareStatement(sql);

            statement.setString(1, po.getDeliveryMan());
            statement.setString(2, po.getID());
            statement.setString(3, barcodeUtil.getDBbarsFromBarList(po.getBarCode()));
            statement.setString(4, po.getDate());
            //向数据库添加到达单
            statement.executeUpdate();

            //等待总经理审批过程,反复查询
            DocState result = this.waitForCheck("note_delivery_on_service", "id", po.getID());

            //记录系统日志
            LogInsHelper.insertLog(po.getOrganization()+" 业务员 "+po.getUserName()+
                    "添加派件单,派件员:"+po.getDeliveryMan());

            //审批通过
            if (result == DocState.PASSED) {
                //追加修改物流信息
                this.updateOrder("正由 "+po.getUserName()+" 快递员派送",po.getBarCode());
                resultMsg.setPass(true);
            } else {
                String advice = this.getFailedAdvice("note_delivery_on_service", "id", po.getID());
                resultMsg.setMessage(advice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            resultMsg = new ResultMsg(false,po.getUserName()+"添加派件单失败");
        }
        DatabaseManager.releaseConnection(connection, statement, null);
        return resultMsg;
    }

    @Override
    public ArrayList<DeliverNoteOnServicePO> getDeliverNoteOnService() throws RemoteException {
        ArrayList<DeliverNoteOnServicePO> result = new ArrayList<>();
        Connection connection = DatabaseManager.getConnection();
        String sql = "select * from `note_delivery_on_service` where isPassed = 0";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            DeliverNoteOnServicePO deliverNoteOnServicePO;
            while(resultSet.next()){
                String id = resultSet.getString("id");
                String date = resultSet.getString("date");
                String man = resultSet.getString("deliveryMan");
                String barcodes =  resultSet.getString("barcodes");
                ArrayList<String> allBarcodes = barcodeUtil.getBarcodesFromDBbars(barcodes);
                deliverNoteOnServicePO = new DeliverNoteOnServicePO(id,date,allBarcodes,man);
                result.add(deliverNoteOnServicePO);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseManager.releaseConnection(connection, statement, null);
        return result;
    }

}
