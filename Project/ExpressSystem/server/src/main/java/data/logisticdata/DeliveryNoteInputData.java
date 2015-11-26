package data.logisticdata;

import data.database.DatabaseManager;
import data.statisticdata.LogInsertData;
import data.statisticdata.OrderInquiryData;
import dataservice.exception.ElementNotFoundException;
import dataservice.logisticdataservice.DeliveryNoteInputDataService;
import po.DeliveryNotePO;
import util.ResultMsg;
import util.SendDocMsg;
import util.enums.DocState;
import util.enums.GoodsState;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by kylin on 15/11/10.
 */
public class DeliveryNoteInputData extends NoteInputData implements DeliveryNoteInputDataService {

    private LogInsertData logInsertData;
    private OrderInquiryData orderDataService;

    @Override
    public SendDocMsg insert(DeliveryNotePO po) throws RemoteException, SQLException, ElementNotFoundException {
        Connection connection = DatabaseManager.getConnection();
        String sql = "insert into `Express`.`note_delivery` " +
                "( `volume`, `category`, `senderTeleNumber`, `receiverAddress`, " +
                "`packPrice`, `weight`, `userName`, `receiverName`, `goodsNumber`," +
                " `receiverTeleNumber`, `senderAddress`, `senderName`, `name`, `barCode`) values " +
                "( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setDouble(1, po.getVolume());
        statement.setString(2, po.getCategory().getStrCategory());
        statement.setString(3, po.getSenderTeleNumber());
        statement.setString(4, po.getReceiverAddress());
        statement.setDouble(5, po.getPackPrice());
        statement.setDouble(6, po.getWeight());
        statement.setString(7, "测试");
        statement.setString(8, po.getReceiverName());
        statement.setInt(9, po.getGoodsNumber());
        statement.setString(10, po.getReceiverTeleNumber());
        statement.setString(11, po.getSenderAddress());
        statement.setString(12, po.getSenderName());
        statement.setString(13, po.getName());
        statement.setString(14, po.getBarCode());
        int result = statement.executeUpdate();
        if (result < 0)
            throw new SQLException();
        //记录系统日志
        logInsertData = new LogInsertData();
        //TODO 获取业务员的信息
        logInsertData.insertSystemLog("营业厅业务员?新增寄件单,单据编号:" + po.getBarCode());

        //等待总经理审批过程,反复查询
        DocState docState = this.waitForCheck("note_delivery",
                "barCode", po.getBarCode());
        ResultMsg resultMsg = new ResultMsg(false);
        //审批通过
        if (docState == DocState.PASSED) {
            System.out.println("DeliveryNote is passed!");
            //追加修改物流信息
            orderDataService = new OrderInquiryData();
            orderDataService.updateOrder(po.getBarCode(),GoodsState.COMPLETE,
                    "?营业厅已收件!");
            resultMsg.setPass(true);
            //TODO 获取总价格与预计到达日期

        } else { //审批没有通过
            System.out.println("DeliveryNote is failed!");
            String advice = this.getFailedAdvice("note_delivery",
                    "barCode", po.getBarCode());
            resultMsg.setMessage(advice);
        }
        //操作结束
        DatabaseManager.releaseConnection(connection, statement, null);
        return null;
    }

}
