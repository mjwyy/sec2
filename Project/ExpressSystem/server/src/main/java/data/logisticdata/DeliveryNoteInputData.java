package data.logisticdata;

import data.database.DatabaseManager;
import data.statisticdata.LogInsertData;
import data.statisticdata.OrderInquiryData;
import dataservice.logisticdataservice.DeliveryNoteInputDataService;
import po.DeliveryNotePO;
import po.OrderPO;
import util.ResultMsg;
import util.enums.DocState;
import util.enums.GoodsState;
import util.SendDocMsg;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/11/10.
 */
public class DeliveryNoteInputData extends NoteInputData implements DeliveryNoteInputDataService {

    private OrderInquiryData orderInquiryData;
    private LogInsertData logInsertData;

    @Override
    public SendDocMsg insert(DeliveryNotePO po) throws RemoteException, SQLException {
        Connection connection = DatabaseManager.getConnection();
        String sql = "insert into note_delivery ( `volume`, `category`, `senderTeleNumber`, " +
                "`receiverAddress`, `packPrice`, `weight`, `docState`, " + "`receiverName`," +
                " `goodsNumber`, `userName`, `receiverTeleNumber`, `senderAddress`," +
                " `senderName`, `name`, `barCode`) values " +
                "( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setDouble(1, po.getVolume());
        statement.setString(2, po.getCategory().getStrCategory());
        statement.setString(3, po.getSenderTeleNumber());
        statement.setString(4, po.getReceiverAddress());
        statement.setDouble(5, po.getPackPrice());
        statement.setDouble(6, po.getWeight());
        statement.setInt(7, po.getState().getIntState());
        statement.setString(8, po.getReceiverName());
        statement.setInt(9, po.getGoodsNumber());
//        statement.setString(10, po.getUserName());
        statement.setString(11, po.getReceiverTeleNumber());
        statement.setString(12, po.getSenderAddress());
        statement.setString(13, po.getSenderName());
        statement.setString(14, po.getName());
        statement.setInt(15, Integer.parseInt(po.getBarCode()));
        int result = statement.executeUpdate();
        if (result < 0)
            throw new SQLException();
        //记录系统日志
        logInsertData = new LogInsertData();
        logInsertData.insertSystemLog("营业厅业务员?新增营业厅到达单,单据编号:" + po.getBarCode());

        //等待总经理审批过程,反复查询
//        SendDocMsg result = this.waitForCheck("note_arrival_on_transit",
//                "transferNumber", po.getBarCode());
//        ResultMsg resultMsg = new ResultMsg(false);
//        //审批通过
//        if (result == DocState.PASSED) {
//            System.out.println("ArrivalNoteOnTransitPO is passed!");
//            //追加修改物流信息
//            orderDataService = new OrderInquiryData();
//            orderDataService.updateOrder("", GoodsState.COMPLETE,"");
//            resultMsg.setPass(true);
//            //审批没有通过
//        } else {
//            System.out.println("ArrivalNoteOnTransitPO is failed!");
//            String advice = this.getFailedAdvice("note_arrival_on_transit",
//                    "transferNumber", po.getBarCode());
//            resultMsg.setMessage(advice);
//        }
//        //操作结束
//        DatabaseManager.releaseConnection(connection, statement, null);
        return null;
    }

}
