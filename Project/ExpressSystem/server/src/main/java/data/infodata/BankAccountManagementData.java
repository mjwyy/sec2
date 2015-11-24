package data.infodata;

import data.database.DatabaseFactory;
import data.database.DatabaseFactoryMysqlImpl;
import data.statisticdata.inte.LogInsertDataService;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import dataservice.infodataservice.BankAccountManagementDataService;
import po.BankAccountPO;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/11/16.
 */
public class BankAccountManagementData implements BankAccountManagementDataService{
	
	private Connection connection;
	DatabaseFactory dataFac = null;
	
	public BankAccountManagementData(Connection con) throws RemoteException {
		super();
		connection = con;
		dataFac = DatabaseFactoryMysqlImpl.getInstance();
	}
	
    @Override
    public boolean addBankAccount(BankAccountPO account) throws RemoteException, InterruptWithExistedElementException, SQLException {
    	
    	LogInsertDataService logIns = dataFac.getLogInsertDataService();
    	
    	try {
			if(findBankAccount(account).size()>0) {
				logIns.insertSystemLog("试图新增银行账户:"+account.getName()+","+account.getNumber()+"，但银行账户已存在，取消操作");
				throw new InterruptWithExistedElementException();
			}
		} catch (ElementNotFoundException e1) {
			// That's OK
		}
    	
    	String stat = "insert into BankAccounts (name,number,balance) values ('"+account.getNumber()+"','"+
    			account.getNumber()+"','"+account.getBalance()+"')";
    	PreparedStatement statement = connection.prepareStatement(stat);
    	try {
			int result = statement.executeUpdate();
		} catch (SQLException e) {
			logIns.insertSystemLog("新增银行账户失败");
		}
    	
        return true;
    }

    @Override
    public boolean removeBankAccount(BankAccountPO account) throws RemoteException, ElementNotFoundException {
        return false;
    }


    @Override
    public ArrayList<BankAccountPO> findBankAccount(BankAccountPO accountInfo) throws RemoteException, ElementNotFoundException {
        return null;
    }

    @Override
    public ArrayList<BankAccountPO> getAllAccounts() throws RemoteException {
        return null;
    }

	@Override
	public boolean modifyBankAccount(BankAccountPO account)
			throws RemoteException, ElementNotFoundException,
			InterruptWithExistedElementException {
		return false;
	}
}
