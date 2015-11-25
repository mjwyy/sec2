package data.statisticdata;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import data.database.DatabaseManager;
import po.OrderPO;
import dataservice.exception.ElementNotFoundException;
import dataservice.statisticdataservice.OrderInquiryDataService;
import util.PresumedMsg;
import util.enums.GoodsState;

/**
 *
 * @author kylin
 *
 * @date 2015/11/14
 *
 */
public class OrderInquiryData implements OrderInquiryDataService{

	@Override
	public OrderPO findOrder(String barcode) throws RemoteException,
			ElementNotFoundException {
		return null;
	}

    public PresumedMsg insertOrderPO(OrderPO po) throws RemoteException, SQLException {
        Connection connection = DatabaseManager.getConnection();
        String sql = "insert into order( `barcode`, `stateOfTransport`, `history`) " +
                "values (?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, po.getBarcode());
        statement.setString(2, po.getGoodsState().toString());
        StringBuilder stringBuilder = new StringBuilder();
        for (String history : po.getHistory()) {
            stringBuilder.append(history);
            stringBuilder.append(';');
        }
        statement.setString(3, stringBuilder.toString());
        int result = statement.executeUpdate();
        if (result < 0)
            throw new SQLException();
        //获取运费与预计到达日期

        DatabaseManager.releaseConnection(connection, statement, null);
        return null;
    }

    public OrderPO updateOrder(String barcode, GoodsState goodsStatem, String newMesg) throws RemoteException,
            ElementNotFoundException {
        return null;
    }

    public OrderPO deleteOrder(String barcode) throws RemoteException,
            ElementNotFoundException {
        return null;
    }

}
