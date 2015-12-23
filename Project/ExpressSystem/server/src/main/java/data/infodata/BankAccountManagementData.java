package data.infodata;

import data.database.DatabaseFactory;
import data.database.DatabaseFactoryMysqlImpl;
import data.database.DatabaseManager;
import data.infodata.inte.BankAccountBalanceAccess;
import data.statisticdata.LogInsHelper;
import data.statisticdata.inte.LogInsertDataService;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import dataservice.infodataservice.BankAccountManagementDataService;
import po.BankAccountPO;

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
public class BankAccountManagementData extends UnicastRemoteObject implements BankAccountManagementDataService, BankAccountBalanceAccess{


	private static final long serialVersionUID = -8080269551859558616L;

    public BankAccountManagementData() throws RemoteException {
        super();
        
    }

    @Override
    public boolean addBankAccount(BankAccountPO account) throws RemoteException, InterruptWithExistedElementException, SQLException {
    	Connection connection = DatabaseManager.getConnection();

        try {
            if(findBankAccount(account).size()>0) {
                LogInsHelper.insertLog("试图新增银行账户:"+account.getName()+","+account.getNumber()+"，但银行账户已存在，取消操作");
                DatabaseManager.releaseConnection(connection,null,null);
                throw new InterruptWithExistedElementException("银行账户："+account.getNumber()+"已存在。");
            }
        } catch (ElementNotFoundException e1) {
            // That's OK
        }

        String stat = "insert into BankAccounts (name,number,balance) values ('"+account.getName()+"','"+
                account.getNumber()+"','"+account.getBalance()+"')";
        PreparedStatement statement = connection.prepareStatement(stat);

        int result = 0;
        try {
            result = statement.executeUpdate();
        } catch (SQLException e) {
            LogInsHelper.insertLog("新增银行账户失败");
            DatabaseManager.releaseConnection(connection,statement,null);
            return false;
        }
        DatabaseManager.releaseConnection(connection,statement,null);
        return result > 0;
    }

    @Override
    public boolean removeBankAccount(BankAccountPO account) throws RemoteException, ElementNotFoundException, SQLException {
    	Connection connection = DatabaseManager.getConnection();
    	LogInsertDataService logIns = DatabaseFactoryMysqlImpl.getInstance().getLogInsertDataService();

        if(findBankAccount(account).size()==0) {
        	DatabaseManager.releaseConnection(connection,null,null);
        	throw new ElementNotFoundException("未找到此银行账户，删除操作取消");
        }

        String stmt = "delete from BankAccounts where number='"+account.getNumber()+"'";
        PreparedStatement stat = connection.prepareStatement(stmt);
        int result = 0;
        try {
            result = stat.executeUpdate();
        } catch (SQLException e) {
            logIns.insertSystemLog("删除银行账户失败");
            DatabaseManager.releaseConnection(connection,stat,null);
            return false;
        }
        DatabaseManager.releaseConnection(connection,stat,null);
        return result >0;

    }


    @Override
    public ArrayList<BankAccountPO> findBankAccount(BankAccountPO accountInfo) throws RemoteException, ElementNotFoundException, SQLException {
    	Connection connection = DatabaseManager.getConnection();
    	LogInsertDataService logIns = DatabaseFactoryMysqlImpl.getInstance().getLogInsertDataService();

        String stmt = "select * from BankAccounts ";

        if(accountInfo==null) {
            //Just get all acccounts.
        } else {
            stmt = stmt + "where ";
            if(accountInfo.getName()!=null) {
                stmt = stmt + "(name LIKE '%"+accountInfo.getName()+"%') ";
            }
            if(accountInfo.getNumber()!=null) {
                if(accountInfo.getName()!=null) stmt = stmt + " OR ";
                stmt = stmt + "(number='"+accountInfo.getNumber()+"')";
            }
        }


        PreparedStatement stat = connection.prepareStatement(stmt);
        ResultSet set = stat.executeQuery();

        ArrayList<BankAccountPO> result = new ArrayList<>();

        while(set.next()) {
            result.add(new BankAccountPO(set.getString("name"), set.getString("number"), set.getString("balance")));
        }
        
        logIns.insertSystemLog("查找了银行账户："+
        ((accountInfo==null)?("所有银行账户"):("name="+accountInfo.getName()+",number="+accountInfo.getNumber())));
        DatabaseManager.releaseConnection(connection,stat,set);
        return result;
    }

    @Override
    public ArrayList<BankAccountPO> getAllAccounts() throws RemoteException, ElementNotFoundException, SQLException {
        return findBankAccount(null);
    }

    @Override
    public boolean modifyBankAccount(BankAccountPO account)	throws RemoteException, ElementNotFoundException,
            InterruptWithExistedElementException, SQLException {
    	Connection connection = DatabaseManager.getConnection();
    	LogInsertDataService logIns = DatabaseFactoryMysqlImpl.getInstance().getLogInsertDataService();

        BankAccountPO searched = new BankAccountPO(null, account.getNumber(), null);
        if(findBankAccount(searched).size()==0){
            logIns.insertSystemLog("修改银行账户,但账户不存在");
            DatabaseManager.releaseConnection(connection,null,null);
            throw new ElementNotFoundException("未找到银行账户，修改操作取消");
        }

        String stmt = "update BankAccounts set name='"+account.getName()+"' where number='"+account.getNumber()+"'";
        PreparedStatement stat = connection.prepareStatement(stmt);
        int result = stat.executeUpdate();

        LogInsHelper.insertLog("修改银行账户,number="+account.getNumber()+",name="+account.getName());
        DatabaseManager.releaseConnection(connection,stat,null);
        return result > 0;
    }

	@Override
	public double getAccountBalance(String accountNum)
			throws ElementNotFoundException, SQLException, RemoteException {
		ArrayList<BankAccountPO> list = findBankAccount(new BankAccountPO(null, accountNum, null));
		
		if(list.size()==0) {
			throw new ElementNotFoundException();
		}
		
		return Double.parseDouble(list.get(0).getBalance());
	}

	@Override
	public synchronized  void setAccountBalance(String accountNum, String variance)
			throws ElementNotFoundException, SQLException, RemoteException {
		
		double left = getAccountBalance(accountNum);
		
		assert (left+Double.parseDouble(variance))>=0;

		String balance = null;
		
		Connection connection = DatabaseManager.getConnection();
    	LogInsertDataService logIns = DatabaseFactoryMysqlImpl.getInstance().getLogInsertDataService();

        BankAccountPO searched = new BankAccountPO(null, accountNum, null);
        if(findBankAccount(searched).size()==0){
            logIns.insertSystemLog("修改银行账户,但账户不存在");
            DatabaseManager.releaseConnection(connection,null,null);
            throw new ElementNotFoundException("未找到银行账户，修改操作取消");
        }

        String stmt = "update BankAccounts balance='"+balance+"' where number='"+accountNum+"'";
        PreparedStatement stat = connection.prepareStatement(stmt);
        int result = stat.executeUpdate();

        logIns.insertSystemLog("修改银行账户,number='"+accountNum+"',name="+balance);
        DatabaseManager.releaseConnection(connection,stat,null);
		
	}
}
