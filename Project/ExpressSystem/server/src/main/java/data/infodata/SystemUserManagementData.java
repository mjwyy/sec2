package data.infodata;

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
public class SystemUserManagementData  implements SystemUserManagementDataService{

    private Connection connection;

    private PreparedStatement statement;

    public SystemUserManagementData() throws RemoteException {
        super();
    }

    public SystemUserManagementData(Connection con) throws RemoteException {
        super();
        this.connection = con;
    }

    @Override
    public boolean addUser(UserPO user) throws InterruptWithExistedElementException, SQLException {
        String sqlInsert = "insert into user (account,rights,password) values(?,?,?)";
        statement = connection.prepareStatement(sqlInsert);
        statement.setString(1,user.getAccount());
        statement.setInt(2,user.getAuthority());
        statement.setString(3,user.getPassword());
        int result = statement.executeUpdate();
        statement.close();
        return result > 0;
    }

    @Override
    public boolean removeUser(UserPO user) throws ElementNotFoundException, SQLException {
        String account = user.getAccount();
        String delete = "delete from user where account = '"+account+"'";
        statement = connection.prepareStatement(delete);
        int result = statement.executeUpdate();
        statement.close();
        return result > 0;
    }

    @Override
    public boolean modifyUser(UserPO originalUser, UserPO modified) throws ElementNotFoundException, SQLException {
        if(!originalUser.getAccount().equals(modified.getAccount()))
            return false;
        String modify;
        if(originalUser.getPassword()!=null && originalUser.getAuthority()!=0){
            modify = "update user set rights="+modified.getAuthority()
                    +",password="+modified.getPassword()+" where account = "+modified.getAccount();
        }else if(originalUser.getPassword()!=null&& originalUser.getAuthority()==0){
            modify = "update user set password="+modified.getPassword()+" where account = "+modified.getAccount();
        }else
            modify = "update user set rights="+modified.getAuthority()+" where account = "+modified.getAccount();
        statement = connection.prepareStatement(modify);
        int result = statement.executeUpdate();
        statement.close();
        return result > 0;
    }

    @Override
    public ArrayList<UserPO> inquireUser(UserPO info) throws ElementNotFoundException, SQLException {
        String accountToFind = info.getAccount();
        String sqlFindAll = "select * from user where account = '"+accountToFind+"'";
        statement = connection.prepareStatement(sqlFindAll);
        ResultSet resultSet = statement.executeQuery();
        ArrayList<UserPO> result = new ArrayList<>();
        UserPO userPO;
        while(resultSet.next()){
            String account = resultSet.getString(1);
            String password = resultSet.getString(2);
            int authority = resultSet.getInt(3);
            userPO = new UserPO(account,password,authority);
            result.add(userPO);
        }
        statement.close();
        return result;
    }

    @Override
    public ArrayList<UserPO> getAllUsers() throws SQLException {
        String sqlFindAll = "select * from user";
        statement = connection.prepareStatement(sqlFindAll);
        ResultSet resultSet = statement.executeQuery();
        ArrayList<UserPO> result = new ArrayList<>();
        UserPO userPO;
        while(resultSet.next()){
            String account = resultSet.getString(1);
            String password = resultSet.getString(2);
            int authority = resultSet.getInt(3);
            userPO = new UserPO(account,password,authority);
            result.add(userPO);
        }
        statement.close();
        return result;
    }

}
