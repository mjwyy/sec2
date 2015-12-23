package data.logisticdata;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import data.database.DatabaseManager;
import data.logisticdata.barcode.BarcodeUtil;
import data.statisticdata.LogInsHelper;
import data.statisticdata.LogInsertData;
import data.statisticdata.OrderInquiryData;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
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
    public ResultMsg insertArrivalNote(ArrivalNoteOnServicePO po) throws RemoteException,
            ElementNotFoundException, InterruptWithExistedElementException {
        Connection connection = DatabaseManager.getConnection();
        //新增到达单
        String sql = "insert into `note_arrival_on_service` ( " +
                "`arrivalKind`, `from`, `barcodes`, `TransferNumber`, `date`)" +
                " values ( ?, ?, ?, ?, ?)";
        PreparedStatement statement = null;
        ResultMsg resultMsg;
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
            if(this.isNoteInDB("note_arrival_on_service", "TransferNumber", po.getTransferNumber()))
                throw new InterruptWithExistedElementException("");

            if(this.isBarcodeInDB(po.getBarcodeAndStates(),true)){
                statement.executeUpdate();
                resultMsg = this.afterInsertArrival(po);
            }else
                throw new ElementNotFoundException();
        } catch (SQLException e) {
            e.printStackTrace();
            resultMsg = new ResultMsg(false,"添加营业厅到达单失败");
        }
        DatabaseManager.releaseConnection(connection, statement, null);
        return resultMsg;
    }

    private ResultMsg afterInsertArrival(ArrivalNoteOnServicePO po) throws ElementNotFoundException {
        ResultMsg resultMsg = new ResultMsg(false);
        LogInsHelper.insertLog(po.getOrganization()+" 业务员 " +po.getUserName()+
                "添加营业厅到达单,单据编号:" + po.getTransferNumber());
        DocState result = this.waitForCheck("note_arrival_on_service",
                "TransferNumber", po.getTransferNumber());
        //审批通过,追加修改物流信息
        if (result == DocState.PASSED) {
            this.updateOrder(po.getBarcodeAndStates(), "已到达"+po.getOrganization());
            resultMsg.setPass(true);
            resultMsg.setMessage("营业厅到达单提交成功!");
            //审批否决,获取总经理意见
        } else {
            String advice = this.getFailedAdvice("note_arrival_on_service",
                    "TransferNumber", po.getTransferNumber());
            resultMsg.setMessage(advice);
        }
        return resultMsg;
    }

    @Override
    public ResultMsg insertDeliverNote(DeliverNoteOnServicePO po) throws RemoteException, ElementNotFoundException, InterruptWithExistedElementException {
        Connection connection = DatabaseManager.getConnection();
        String sql = "insert into `note_delivery_on_service` ( `deliveryMan`, `id`, `barcodes`, `date`)" +
                " values ( ?, ?, ?, ?)";
        PreparedStatement statement = null;
        ResultMsg resultMsg;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, po.getDeliveryMan());
            statement.setString(2, po.getID());
            statement.setString(3, barcodeUtil.getDBbarsFromBarList(po.getBarCode()));
            statement.setString(4, po.getDate());
            if(this.isNoteInDB( "note_delivery_on_service", "id", po.getID() ))
                throw new InterruptWithExistedElementException("");
            //检查订单信息是否存在
            if(this.isBarcodeInDB(po.getBarCode())){
                statement.executeUpdate();
                resultMsg = this.afterInsertDelivery(po);
            }else
                throw new ElementNotFoundException();
        } catch (SQLException e) {
            e.printStackTrace();
            resultMsg = new ResultMsg(false,po.getUserName()+"添加派件单失败");
        }
        DatabaseManager.releaseConnection(connection, statement, null);
        return resultMsg;
    }

    private ResultMsg afterInsertDelivery(DeliverNoteOnServicePO po) throws ElementNotFoundException {
        ResultMsg resultMsg = new ResultMsg(false);
        DocState result = this.waitForCheck("note_delivery_on_service", "id", po.getID());
        LogInsHelper.insertLog(po.getOrganization()+" 业务员 "+po.getUserName()+
                "添加派件单,派件员:"+po.getDeliveryMan());
        if (result == DocState.PASSED) {
            this.updateOrder("正由 "+po.getOrganization()+" 的快递员 " + po.getDeliveryMan()
                    +" 派送",po.getBarCode());
            resultMsg.setPass(true);
            resultMsg.setMessage("派件单提交成功!");
        } else {
            String advice = this.getFailedAdvice("note_delivery_on_service", "id", po.getID());
            resultMsg.setMessage(advice);
        }
        return resultMsg;
    }

}
