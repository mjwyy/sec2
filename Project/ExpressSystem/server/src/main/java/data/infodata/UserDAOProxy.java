package data.infodata;

import data.dao.DatabaseConnection;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import dataservice.infodataservice.SystemUserManagementDataService;
import po.UserPO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/11/18.
 */
public class UserDAOProxy extends UnicastRemoteObject implements SystemUserManagementDataService {
    //实现RMI接口的类必须继承自java.rmi.server.UnicastRemoteObject


    //由于基类UnicastRemoteObject的默认构造方法抛出异常，因此实现类必须同时提供一个构造方法
    public UserDAOProxy() throws RemoteException {

    }

    @Override
    public boolean addUser(UserPO user) throws InterruptWithExistedElementException, SQLException, RemoteException {
        DatabaseConnection connection = new DatabaseConnection();
        SystemUserManagementData dataImpl = new SystemUserManagementData(connection.getConnection());
        boolean result = dataImpl.addUser(user);
        System.out.println("server addUser success!");
        connection.close();
        return result;
    }

    @Override
    public boolean removeUser(UserPO user) throws ElementNotFoundException, SQLException, RemoteException {
        DatabaseConnection connection = new DatabaseConnection();
        SystemUserManagementData dataImpl = new SystemUserManagementData(connection.getConnection());boolean result = dataImpl.removeUser(user);
        connection.close();
        return result;
    }

    @Override
    public boolean modifyUser(UserPO originalUser, UserPO modified) throws ElementNotFoundException, SQLException, RemoteException {
        DatabaseConnection connection = new DatabaseConnection();
        SystemUserManagementData dataImpl = new SystemUserManagementData(connection.getConnection()); boolean result = dataImpl.modifyUser(originalUser,modified);
        connection.close();
        return result;
    }

    @Override
    public ArrayList<UserPO> inquireUser(UserPO info) throws ElementNotFoundException, SQLException, RemoteException {
        DatabaseConnection connection = new DatabaseConnection();
        SystemUserManagementData dataImpl = new SystemUserManagementData(connection.getConnection()); ArrayList<UserPO> result = dataImpl.inquireUser(info);
        connection.close();
        return result;
    }

    @Override
    public ArrayList<UserPO> getAllUsers() throws SQLException, RemoteException {
        DatabaseConnection connection = new DatabaseConnection();
        SystemUserManagementData dataImpl = new SystemUserManagementData(connection.getConnection());ArrayList<UserPO> result = dataImpl.getAllUsers();
        connection.close();
        return result;
    }

}
