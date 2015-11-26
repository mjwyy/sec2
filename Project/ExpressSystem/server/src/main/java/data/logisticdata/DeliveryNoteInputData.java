package data.logisticdata;

import data.database.DatabaseManager;
import data.statisticdata.OrderInquiryData;
import dataservice.logisticdataservice.DeliveryNoteInputDataService;
import po.DeliveryNotePO;
import po.OrderPO;
//import util.SendDocMsg;
//import util.SendDocMsg;
import util.SendDocMsg;
import util.enums.GoodsState;

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
    private OrderPO orderPO;

    @Override
    public SendDocMsg insert(DeliveryNotePO po) throws RemoteException, SQLException {
//        Connection connection = DatabaseManager.getConnection();
//        String sql = "insert into note_delivery ( `volume`, `category`, `senderTeleNumber`, " +
//                "`receiverAddress`, `packPrice`, `weight`, `docState`, " + "`receiverName`," +
//                " `goodsNumber`, `userName`, `receiverTeleNumber`, `senderAddress`," +
//                " `senderName`, `name`, `barCode`) values " +
//                "( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//        PreparedStatement statement = connection.prepareStatement(sql);
//        statement.setDouble(1, po.getVolume());
//        statement.setString(2, po.getCategory().getStrCategory());
//        statement.setString(3, po.getSenderTeleNumber());
//        statement.setString(4, po.getReceiverAddress());
//        statement.setDouble(5, po.getPackPrice());
//        statement.setDouble(6, po.getWeight());
//        statement.setInt(7, po.getState().getIntState());
//        statement.setString(8, po.getReceiverName());
//        statement.setInt(9, po.getGoodsNumber());
////        statement.setString(10, po.getUserName());
//        statement.setString(11, po.getReceiverTeleNumber());
//        statement.setString(12, po.getSenderAddress());
//        statement.setString(13, po.getSenderName());
//        statement.setString(14, po.getName());
//        statement.setInt(15, Integer.parseInt(po.getBarCode()));
//        int result = statement.executeUpdate();
//        if (result < 0)
//            throw new SQLException();
//        //等待总经理审批过程
//
//        //审批通过
//        orderInquiryData = new OrderInquiryData();
//        ArrayList<String> history = new ArrayList<>();
//        history.add("快递员已收件!");
//        orderPO = new OrderPO(po.getBarCode(), GoodsState.COMPLETE, history);
//        orderInquiryData.insertOrderPO(orderPO);
//        DatabaseManager.releaseConnection(connection,statement,null);
        return null;
    }



    @Override
    public ArrayList<DeliveryNotePO> find(DeliveryNotePO po) throws RemoteException {
        Connection connection = DatabaseManager.getConnection();
        DeliveryNotePO pox = new DeliveryNotePO(null,null,null,null,null,null,null,0,0,0,null,0,null);
        ArrayList<DeliveryNotePO> list =  new ArrayList<DeliveryNotePO>();
        list.add(pox);

        DatabaseManager.releaseConnection(connection,null,null);
        return list;
    }

    @Override
    public ArrayList<DeliveryNotePO> findAll() throws RemoteException {
        Connection connection = DatabaseManager.getConnection();
        DeliveryNotePO pox = new DeliveryNotePO(null,null,null,null,null,null,null,0,0,0,null,0,null);
        ArrayList<DeliveryNotePO> list =  new ArrayList<DeliveryNotePO>();
        list.add(pox);

        DatabaseManager.releaseConnection(connection,null,null);
        return list;
    }
}
