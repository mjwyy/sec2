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
        ArrayList<String> citys  = this.getAllCities();
        Connection connection = DatabaseManager.getConnection();
        if(citys.contains(name))
            throw new InterruptWithExistedElementException();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("");
            for(String city : citys){
                String sql = "insert into `Express`.`distance` ( `city1`, `city2`) values ( ?, ?)";
                statement = connection.prepareStatement(sql);
                statement.setString(1,name);
                statement.setString(2,city);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseManager.releaseConnection(connection, statement, null);
		return true;
	}

	@Override
	public ArrayList<String> getAllCities() throws RemoteException {
        Connection connection = DatabaseManager.getConnection();
        ArrayList<String> citys = new ArrayList<>();
        String sql = "select `city1`,`city2` from `Express`.`distance`";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            String city1,city2;
            while(resultSet.next()){
                city1 = resultSet.getString(1);
                city2 = resultSet.getString(2);
                if(!citys.contains(city1))
                    citys.add(city1);
                if(!citys.contains(city2))
                    citys.add(city2);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseManager.releaseConnection(connection,statement,null);
        return citys;
	}

	@Override
	public boolean setPrice(PriceType name, double newValue)
            throws RemoteException, ElementNotFoundException {
        String sql = "update `Express`.`businessPrice` set `price`='" + newValue
                + "' where `type`= '" + name.toString() + "'";
        try {
            SqlHelper.excUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

	@Override
	public double getPrice(PriceType name) throws RemoteException,
            ElementNotFoundException {
        Connection connection = DatabaseManager.getConnection();
        String sql = "select `price` from `Express`.`businessPrice` where  `type`= '" + name.toString() + "' ";
        PreparedStatement statement = null;
        double distance = 0;
        try {
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
                distance = resultSet.getDouble(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseManager.releaseConnection(connection,statement,null);
        return distance;
    }

	@Override
	public boolean setDistance(DistancePO distancePO) throws RemoteException,
            ElementNotFoundException {
        String city1 = distancePO.getCity1();
        String city2 = distancePO.getCity2();
        if(this.getDistance(city1,city2) == -1)
            throw new ElementNotFoundException();
        String sql = "select `id` from `Express`.`distance` where "+
                "(city1 = '"+city1+"' AND city2 = '"+city2+"') " +
                "OR (city1 = '"+city2+"' AND city2 = '"+city1+"')";
        Connection connection = DatabaseManager.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            int id = 0;
            if(resultSet.next())
                id = resultSet.getInt(1);
            DatabaseManager.releaseConnection(connection,statement,resultSet);
            String sqlSet = "update `Express`.`distance` set `distance` = "+distancePO.getDistance()
                    +"where `id` = "+id;
            SqlHelper.excUpdate(sqlSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

	@Override
    public double getDistance(String city1, String city2) throws RemoteException,
            ElementNotFoundException {
        Connection connection = DatabaseManager.getConnection();
        String sql = "select `distance` from `Express`.`distance` where "+
                "(city1 = '"+city1+"' AND city2 = '"+city2+"') " +
                "OR (city1 = '"+city2+"' AND city2 = '"+city1+"')";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                double result = resultSet.getDouble(1);
                DatabaseManager.releaseConnection(connection,statement,resultSet);
                return result;
            }
            else{
                DatabaseManager.releaseConnection(connection,statement,resultSet);
                return -1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
