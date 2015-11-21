package data.dao;

import data.infodata.UserDAOProxy;
import dataservice.infodataservice.SystemUserManagementDataService;

import java.rmi.RemoteException;

/**
 * Created by kylin on 15/11/18.
 */
public class DatabaseFactory {

    public static UserDAOProxy getSystemUserManagementDataInstance() throws RemoteException {
        //TODO 是否单例模式
        return new UserDAOProxy();
    }
}
