package data.statisticdata;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.database.DatabaseManager;
import data.database.SqlHelper;
import dataservice.statisticdataservice.BusinessDataModificationDataService;
import po.OrderPO;
import dataservice.exception.ElementNotFoundException;
import dataservice.statisticdataservice.OrderInquiryDataService;
import util.PresumedMsg;
import util.enums.DeliverCategory;
import util.enums.GoodsState;

/**
 *
 * @author kylin
 *
 * @date 2015/11/14
 *
 */
public class OrderInquiryData implements OrderInquiryDataService{

    private BusinessDataModificationDataService businessDataModificationData;

	@Override
	public OrderPO findOrder(String barcode) throws RemoteException,
            ElementNotFoundException, SQLException {
        Connection connection = DatabaseManager.getConnection();
        String sql = "select `stateOfTransport`,`history` from `order` where `barcode` = '"+barcode+"'";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        ArrayList<String> listHistory = new ArrayList<>();
        OrderPO po;
        if (resultSet.next()){
            String stateOfTransport = resultSet.getString(1);
            String history = resultSet.getString(2);
            String[] historys = history.split(";");
            for(String str:historys){
                listHistory.add(str);
            }
            po = new OrderPO(barcode,GoodsState.getGoodsState(stateOfTransport),listHistory);
        }else
            throw new ElementNotFoundException();
        DatabaseManager.releaseConnection(connection, statement, resultSet);
        return po;
	}

    public boolean insertOrderPO(String barcode,String info) throws RemoteException, SQLException {
        Connection connection = DatabaseManager.getConnection();
        String sql = "insert into order( `barcode`, `stateOfTransport`, `history`) " +
                "values (?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, barcode);
        statement.setString(2, GoodsState.COMPLETE.toString());
        statement.setString(3, info);
        int result = statement.executeUpdate();
        if (result < 0)
            throw new SQLException();
        DatabaseManager.releaseConnection(connection, statement, null);
        return true;
    }

    public OrderPO updateOrder(String barcode, GoodsState goodsState, String newMesg) throws RemoteException,
            ElementNotFoundException {
        return null;
    }

    public OrderPO deleteOrder(String barcode) throws RemoteException,
            ElementNotFoundException {
        return null;
    }

}
