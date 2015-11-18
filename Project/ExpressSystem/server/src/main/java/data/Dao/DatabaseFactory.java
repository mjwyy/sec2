package data.dao;

import data.infodata.UserDAOProxy;

/**
 * Created by kylin on 15/11/18.
 */
public class DatabaseFactory {

    public static UserDAOProxy getSystemUserManagementDataInstance(){
        return new UserDAOProxy();
    }
}
