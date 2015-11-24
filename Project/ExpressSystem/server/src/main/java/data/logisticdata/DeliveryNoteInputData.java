package data.logisticdata;

import dataservice.logisticdataservice.DeliveryNoteInputDataService;
import po.DeliveryNotePO;
import po.OrderPO;
import util.PresumedMsg;
import util.sendDocMsg;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/11/10.
 */
public class DeliveryNoteInputData implements DeliveryNoteInputDataService {

    private Connection connection;

    public DeliveryNoteInputData(Connection connection) {
        this.connection = connection;
    }

    @Override
    public sendDocMsg insert(DeliveryNotePO po) throws RemoteException, SQLException {
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
        statement.setString(10, po.getUserName());
        statement.setString(11, po.getReceiverTeleNumber());
        statement.setString(12, po.getSenderAddress());
        statement.setString(13, po.getSenderName());
        statement.setString(14, po.getName());
        statement.setInt(15, Integer.parseInt(po.getBarCode()));
        int result = statement.executeUpdate();
        if (result < 0)
            throw new SQLException();
        //等待总经理审批过程
        return null;
    }

    @Override
    public PresumedMsg insertOrderPO(OrderPO po) throws RemoteException, SQLException {
        String sql = "insert into order( `barcode`, `stateOfTransport`, `history`) " +
                "values (?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, po.getBarcode());
        statement.setString(2, po.getStateOfTransport());
        StringBuilder stringBuilder = new StringBuilder();
        for (String history : po.getHistory()) {
            stringBuilder.append(history);
            stringBuilder.append('\n');
        }
        statement.setString(3, stringBuilder.toString());
        int result = statement.executeUpdate();
        if (result < 0)
            throw new SQLException();
        //获取运费与预计到达日期

        return null;
    }

    @Override
    public ArrayList<DeliveryNotePO> find(DeliveryNotePO po) throws RemoteException {
        DeliveryNotePO pox = new DeliveryNotePO(null,null,null,null,null,null,null,0,0,0,null,0,null);
        ArrayList<DeliveryNotePO> list =  new ArrayList<DeliveryNotePO>();
        list.add(pox);
        return list;
    }

    @Override
    public ArrayList<DeliveryNotePO> findAll() throws RemoteException {
        DeliveryNotePO pox = new DeliveryNotePO(null,null,null,null,null,null,null,0,0,0,null,0,null);
        ArrayList<DeliveryNotePO> list =  new ArrayList<DeliveryNotePO>();
        list.add(pox);
        return list;
    }
}
