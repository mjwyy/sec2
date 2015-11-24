package data.infodata;

import data.database.DatabaseManager;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import dataservice.infodataservice.SystemUserManagementDataService;
import po.UserPO;
import util.LogInMsg;
import util.enums.Authority;

import java.net.ConnectException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/11/16.
 */
public class SystemUserManagementData extends UnicastRemoteObject implements SystemUserManagementDataService{

    public SystemUserManagementData() throws RemoteException {

    }

    @Override
    public boolean addUser(UserPO user) throws InterruptWithExistedElementException, SQLException {
        Connection connection = DatabaseManager.getConnection();
        String sqlInsert = "INSERT into user (account,rights,password) values(?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sqlInsert);
        statement.setString(1,user.getAccount());
        statement.setInt(2,user.getAuthority().getIntAuthority());
        statement.setString(3,user.getPassword());
        int result = statement.executeUpdate();
        DatabaseManager.releaseConnection(connection,statement,null);
        return result > 0;
    }

    @Override
    public boolean removeUser(UserPO user) throws ElementNotFoundException, SQLException {
        Connection connection = DatabaseManager.getConnection();
        String account = user.getAccount();
        String delete = "DELETE from user where account = '"+account+"'";
        PreparedStatement statement = connection.prepareStatement(delete);
        int result = statement.executeUpdate();
        DatabaseManager.releaseConnection(connection,statement,null);
        return result > 0;
    }

    @Override
    public boolean modifyUser(UserPO originalUser, UserPO modified) throws ElementNotFoundException, SQLException {
        Connection connection = DatabaseManager.getConnection();
        if(!originalUser.getAccount().equals(modified.getAccount()))
            return false;
        String modify;
        if(originalUser.getPassword()!=null && originalUser.getAuthority().getIntAuthority()!=0){
            modify = "update user set rights="+modified.getAuthority()
                    +",password="+modified.getPassword()+" where account = "+modified.getAccount();
        }else if(originalUser.getPassword()!=null&& originalUser.getAuthority().getIntAuthority()==0){
            modify = "update user set password="+modified.getPassword()+" where account = "+modified.getAccount();
        }else
            modify = "update user set rights="+modified.getAuthority()+" where account = "+modified.getAccount();
        PreparedStatement statement = connection.prepareStatement(modify);
        int result = statement.executeUpdate();
        DatabaseManager.releaseConnection(connection,statement,null);
        return result > 0;
    }

    @Override
    public ArrayList<UserPO> inquireUser(UserPO info) throws ElementNotFoundException, SQLException {
        Connection connection = DatabaseManager.getConnection();
        String accountToFind = info.getAccount();
        String sqlFindAll = "SELECT * from user where account = '"+accountToFind+"'";
        PreparedStatement statement = connection.prepareStatement(sqlFindAll);
        ResultSet resultSet = statement.executeQuery();
        ArrayList<UserPO> result = new ArrayList<>();
        UserPO userPO;
        while(resultSet.next()){
            String account = resultSet.getString(1);
            String password = resultSet.getString(2);
            int authority = resultSet.getInt(3);
            userPO = new UserPO(account,password,Authority.getAuthObject(authority));
            result.add(userPO);
        }
        DatabaseManager.releaseConnection(connection,statement,resultSet);
        return result;
    }

    @Override
    public ArrayList<UserPO> getAllUsers() throws SQLException {
        Connection connection = DatabaseManager.getConnection();
        String sqlFindAll = "SELECT * from user";
        PreparedStatement statement = connection.prepareStatement(sqlFindAll);
        ResultSet resultSet = statement.executeQuery();
        ArrayList<UserPO> result = new ArrayList<>();
        UserPO userPO;
        while(resultSet.next()){
            String account = resultSet.getString(1);
            String password = resultSet.getString(2);
            int authority = resultSet.getInt(3);
            userPO = new UserPO(account,password,Authority.getAuthObject(authority));
            result.add(userPO);
        }
        DatabaseManager.releaseConnection(connection,statement,resultSet);
        return result;
    }

}
