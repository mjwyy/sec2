package data.infodata.inte;

import java.rmi.RemoteException;
import java.sql.SQLException;

import dataservice.exception.ElementNotFoundException;

public interface BankAccountBalanceAccess {
	/**
	 * 获取单个银行账户的余额
	 * @param accountNum
	 * @return
	 * @throws ElementNotFoundException
	 * @throws SQLException
	 * @throws RemoteException
	 */
	public double getAccountBalance(String accountNum)
			throws ElementNotFoundException,SQLException, RemoteException;
	
	/**
	 * 重设银行账户余额
	 * @param accountNum
	 * @param variance 变化量：收款则为正，付款则为负
	 * @throws ElementNotFoundException
	 * @throws SQLException
	 * @throws RemoteException
	 */
	public void setAccountBalance(String accountNum,String variance) 
			throws ElementNotFoundException,SQLException, RemoteException;
	
}
