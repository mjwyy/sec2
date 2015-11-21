package data.dao;

import data.infodata.UserDAOProxy;

import java.rmi.RemoteException;

/**
 * Created by kylin on 15/11/18.
 */
public class DatabaseFactory {

    public static UserDAOProxy getSystemUserManagementDataInstance() throws RemoteException {
        return new UserDAOProxy();
    }
}
