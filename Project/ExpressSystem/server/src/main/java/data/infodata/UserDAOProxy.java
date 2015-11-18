package data.infodata;

import data.dao.DatabaseConnection;
import dataservice.infodataservice.SystemUserManagementDataService;
import po.UserPO;

import java.util.ArrayList;

/**
 * Created by kylin on 15/11/18.
 */
public class UserDAOProxy implements SystemUserManagementDataService {

    private DatabaseConnection connection;
    private SystemUserManagementData dataImpl;

    public UserDAOProxy(){
        connection = new DatabaseConnection();
        dataImpl = new SystemUserManagementData(connection.getConnection());
    }

    @Override
    public boolean addUser(UserPO user) throws Exception {
        boolean result = dataImpl.addUser(user);
        connection.close();
        return result;
    }

    @Override
    public boolean removeUser(UserPO user) throws Exception {
        boolean result = dataImpl.removeUser(user);
        connection.close();
        return result;
    }

    @Override
    public boolean modifyUser(UserPO originalUser, UserPO modified) throws Exception {
        boolean result = dataImpl.modifyUser(originalUser,modified);
        connection.close();
        return result;
    }

    @Override
    public ArrayList<UserPO> inquireUser(UserPO info) throws Exception {
        ArrayList<UserPO> result = dataImpl.inquireUser(info);
        connection.close();
        return result;
    }

    @Override
    public ArrayList<UserPO> getAllUsers() throws Exception {
        ArrayList<UserPO> result = dataImpl.getAllUsers();
        connection.close();
        return result;
    }
}
