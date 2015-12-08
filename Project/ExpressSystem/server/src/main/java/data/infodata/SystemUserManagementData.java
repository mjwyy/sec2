package data.infodata;

import data.database.DatabaseManager;
import data.statisticdata.LogInsHelper;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import dataservice.infodataservice.SystemUserManagementDataService;
import po.UserPO;
import util.LogInMsg;
import util.enums.Authority;

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

    private static final long serialVersionUID = 72164956257035L;

    public SystemUserManagementData() throws RemoteException {

    }

    @Override
    public boolean addUser(UserPO user) throws InterruptWithExistedElementException {
        Connection connection = DatabaseManager.getConnection();
        String sqlInsert = "INSERT into user (account,rights,password) values(?,?,MD5(?))";
        PreparedStatement statement = null;
        try {
            if(!this.inquireUser(user).isEmpty()){
                LogInsHelper.insertLog("新增系统用户失败:信息已存在!");
                DatabaseManager.releaseConnection(connection,null,null);
                throw new InterruptWithExistedElementException("新增系统用户失败:信息已存在!");
            }
        } catch (ElementNotFoundException e) {}
        int result = 0;
        try {
            statement = connection.prepareStatement(sqlInsert);
            statement.setString(1,user.getAccount());
            statement.setInt(2,user.getAuthority().getIntAuthority());
            statement.setString(3,user.getPassword());
            result = statement.executeUpdate();
            LogInsHelper.insertLog("新增系统用户:"+user.getAccount());
        } catch (SQLException e) {
            LogInsHelper.insertLog("新增系统用户失败!");
            e.printStackTrace();
        }
        DatabaseManager.releaseConnection(connection,statement,null);
        return result > 0;
    }

    @Override
    public boolean removeUser(UserPO user) throws ElementNotFoundException {
        Connection connection = DatabaseManager.getConnection();
        String account = user.getAccount();
        String delete = "DELETE from user where account = '"+account+"'";
        PreparedStatement statement = null;
        try {
            if(this.inquireUser(user).isEmpty()){
                LogInsHelper.insertLog("删除系统用户失败:信息不存在!");
                DatabaseManager.releaseConnection(connection,null,null);
                throw new ElementNotFoundException();
            }
        } catch (ElementNotFoundException e) {}
        int result = 0;
        try {
            statement = connection.prepareStatement(delete);
            result = statement.executeUpdate();
            LogInsHelper.insertLog("删除系统用户:"+user.getAccount());
            DatabaseManager.releaseConnection(connection,statement,null);
        } catch (SQLException e) {
            e.printStackTrace();
            LogInsHelper.insertLog("删除系统用户失败!");
            DatabaseManager.releaseConnection(connection,statement,null);
        }
        return result > 0;
    }

    @Override
    public boolean modifyUser(UserPO originalUser, UserPO modified) throws ElementNotFoundException {
        Connection connection = DatabaseManager.getConnection();
        if(!originalUser.getAccount().equals(modified.getAccount()))
            return false;
        String modify;
        if(originalUser.getPassword()!=null && originalUser.getAuthority().getIntAuthority()!=0){
            modify = "update user set rights="+modified.getAuthority()
                    +",password = MD5('"+modified.getPassword()+"') where account = '"+modified.getAccount()+"'";
        }else if(originalUser.getPassword()!=null&& originalUser.getAuthority().getIntAuthority()==0){
            modify = "update user set password = MD5('"+modified.getPassword()+
                    "') where account = '"+modified.getAccount()+"'";
        }else
            modify = "update user set rights = "+modified.getAuthority()
                    +" where account = '"+modified.getAccount()+"'";
        PreparedStatement statement = null;
        int result = 0;
        try {
            statement = connection.prepareStatement(modify);
            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseManager.releaseConnection(connection,statement,null);
        return result > 0;
    }

    @Override
    public ArrayList<UserPO> inquireUser(UserPO info) throws ElementNotFoundException {
        Connection connection = DatabaseManager.getConnection();
        String sqlFindAll = null;
        if(info.getAuthority() != null){
            sqlFindAll = "SELECT * from user where `rights` = "+info.getAuthority().getIntAuthority();
        }else if(info.getAccount() != null)
            sqlFindAll = "SELECT * from user where `account` like '%"+info.getAccount()+"%'";
        PreparedStatement statement = null;
        ArrayList<UserPO> result = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sqlFindAll);
            ResultSet resultSet = statement.executeQuery();
            UserPO userPO;
            while(resultSet.next()){
                String account = resultSet.getString(1);
                String password = resultSet.getString(2);
                int authority = resultSet.getInt(3);
                userPO = new UserPO(account,password,Authority.getAuthObject(authority));
                result.add(userPO);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseManager.releaseConnection(connection,statement,null);
        return result;
    }

    @Override
    public ArrayList<UserPO> getAllUsers(){
        Connection connection = DatabaseManager.getConnection();
        String sqlFindAll = "SELECT * from user";
        PreparedStatement statement = null;
        ArrayList<UserPO> result = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sqlFindAll);
            ResultSet resultSet = statement.executeQuery();
            UserPO userPO;
            while(resultSet.next()){
                String account = resultSet.getString(1);
                String password = resultSet.getString(2);
                int authority = resultSet.getInt(3);
                userPO = new UserPO(account,password,Authority.getAuthObject(authority));
                result.add(userPO);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseManager.releaseConnection(connection,statement,null);
        return result;
    }

	@Override
	public LogInMsg logIn(String account, String password) throws RemoteException{
		Connection connection = DatabaseManager.getConnection();
		
		//First, find if the account exist.
		ArrayList<UserPO> list;
		try {
			list = inquireUser(new UserPO(account, password, null));
		} catch (ElementNotFoundException e) {
			//由于未明确异常的行为，所以有一点代码重复，不过还好
			return new LogInMsg(false, null, "账户名为"+account+"的用户不存在，请检查输入。");
		}
		if(list.size()==0) return new LogInMsg(false, null, "账户名为"+account+"的用户不存在，请检查输入。");
		
		//Second, find if there exists an account that has the same password.
		String sql = "SELECT * from user where account='"+account+"' AND password=MD5('"+password+"')";
        PreparedStatement stmt = null;
        LogInMsg logInMsg = null;
        try {
            stmt = connection.prepareStatement(sql);
            ResultSet set = stmt.executeQuery();
            if(set.next()) { // Found it!
                Authority a = Authority.getAuthObject(set.getInt("rights"));
                sql = "SELECT name,organization from staff where staff_id = '"+account+"'";
                stmt = connection.prepareStatement(sql);
                set = stmt.executeQuery();
                String userName = "";
                String organization = "";
                while (set.next()){
                    userName = set.getString("name");
                    organization =  set.getString("organization");
                }
                logInMsg = new LogInMsg(true,a,"",userName,organization);
            } else { // No such user.
                logInMsg = new LogInMsg(false, null, "密码错误，请检查输入");
            }
            set.close();
            DatabaseManager.releaseConnection(connection,stmt,null);
            return logInMsg;
        } catch (SQLException e) {
        	LogInsHelper.insertLog(e.getLocalizedMessage());
            e.printStackTrace();
            DatabaseManager.releaseConnection(connection,stmt,null);
        }
        return logInMsg;
	}

}
