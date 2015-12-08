package data.statisticdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import data.database.DatabaseManager;
import po.OrderPO;
import dataservice.exception.ElementNotFoundException;
import dataservice.statisticdataservice.OrderInquiryDataService;
import util.enums.GoodsState;

/**
 *
 * @author kylin
 *
 * @date 2015/11/14
 *
 */
public class OrderInquiryData extends UnicastRemoteObject implements OrderInquiryDataService{

    private static final long serialVersionUID = 72164956288888L;

    public OrderInquiryData() throws RemoteException {
    }

    @Override
    public boolean insertOrderPO(String barcode, String info, double price) throws RemoteException {
        Connection connection = DatabaseManager.getConnection();
        String sql = "insert into `order` ( `history`, `stateOfTransport`, `barcode`,`money`) " +
                "values (?,?,?)";
        PreparedStatement statement = null;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = df.format(new Date());
        System.out.println(info);
        String msg = (currentTime+","+info+";");
        int result = 0;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, msg);
            statement.setString(2, GoodsState.COMPLETE.toString());
            statement.setString(3, barcode);
            statement.setDouble(4, price);
            result = statement.executeUpdate();
            DatabaseManager.releaseConnection(connection, statement, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result > 0;
    }

    @Override
	public OrderPO findOrder(String barcode) throws RemoteException,
            ElementNotFoundException {
        Connection connection = DatabaseManager.getConnection();
        String sql = "select `stateOfTransport`,`history` from `order` where `barcode` = '"+barcode+"'";
        PreparedStatement statement = null;
        OrderPO po;
        try {
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            ArrayList<String> listHistory = new ArrayList<>();
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
            resultSet.close();
            return po;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseManager.releaseConnection(connection, statement, null);
        return null;
	}


}
