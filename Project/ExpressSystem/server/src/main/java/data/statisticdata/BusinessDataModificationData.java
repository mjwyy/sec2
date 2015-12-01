package data.statisticdata;
/**
 * @author wwz
 * @date 2015/11/14
 */
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import data.database.DatabaseManager;
import data.database.SqlHelper;
import dataservice.statisticdataservice.BusinessDataModificationDataService;
import po.DistancePO;
import util.enums.PriceType;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;

public class BusinessDataModificationData implements BusinessDataModificationDataService {

	@Override
	public boolean addCity(String name) throws RemoteException,
			InterruptWithExistedElementException {
		return false;
	}

	@Override
	public ArrayList<String> getAllCities() throws RemoteException {
		return null;
	}

	@Override
	public boolean setPrice(PriceType name, double newValue)
            throws RemoteException, ElementNotFoundException, SQLException {
        String sql = "update `Express`.`businessPrice` set `price`='" + newValue
                + "' where `type`= '" + name.toString() + "'";
        return SqlHelper.excUpdate(sql);
    }

	@Override
	public double getPrice(PriceType name) throws RemoteException,
            ElementNotFoundException, SQLException {
        Connection connection = DatabaseManager.getConnection();
        String sql = "select `price` from `Express`.`businessPrice` where  `type`= '" + name.toString() + "' ";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        double distance = 0;
        if (resultSet.next())
            distance = resultSet.getDouble(1);
        return distance;
    }

	@Override
	public boolean setDistance(DistancePO distancePO) throws RemoteException,
            ElementNotFoundException, SQLException {
        String sql = "update `Express`.`distance` set `" + distancePO.getCity1() + "` = " + distancePO.getDistance()
                + " where `city` = '" + distancePO.getCity2() + "'";
        return SqlHelper.excUpdate(sql);

    }

	@Override
    public double getDistance(String city1, String city2) throws RemoteException,
            ElementNotFoundException, SQLException {
        Connection connection = DatabaseManager.getConnection();
        String sql = "select `" + city1 + "` from `Express`.`distance` where  `city`='" + city2 + "' ";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        double distance = 0;
        if (resultSet.next())
            distance = resultSet.getDouble(1);
        return distance;
    }
	

}
