package dataservice.financedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.data_service_exception.ElementNotFoundException;
import dataservice.data_service_exception.InterruptWithExistedElementException;
import po.BankAccountPO;

public interface BankAccountManagementDataService extends Remote {

	/**
	 * 前置条件：BankAccountPO对象内部数据已经过检查，确定格式无误
	 * 后置条件：Data层对应对象向数据库添加账户记录
	 * @param account
	 * @return true for successful add operation
	 * @throws RemoteException
	 * @throws InterruptWithExistedElementException
	 */
	public boolean addBankAccount(BankAccountPO account) 
			throws RemoteException,	InterruptWithExistedElementException;
	
	/**
	 * 前置条件：BankAccountPO对象内部数据已经过检查，确定格式无误
	 * 后置条件：Data层对应对象向数据库删除账户记录
	 * @param account
	 * @return true for successful remove operation
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 */
	public boolean removeBankAccount(BankAccountPO account)
			throws RemoteException,	ElementNotFoundException;
	
	/**
	 * 前置条件：BankAccountPO对象内部数据已经过检查，确定格式无误
	 * 后置条件：Data层对应对象向数据库在账户记录中查找originalAccount，将其替换为modifiedAccount
	 * @param originalAccount
	 * @param modifiedAccount
	 * @return true for successful remove operation
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 */
	public boolean modifyBankAccount(BankAccountPO originalAccount,BankAccountPO modifiedAccount)
			throws RemoteException,	ElementNotFoundException,InterruptWithExistedElementException;
	
	/**
	 * 前置条件：BankAccountPO对象内部数据已经过检查，确定格式无误
	 * 后置条件：Data层根据参数中的不完全信息查询并返回账户详细信息
	 * @param account
	 * @return 详细账户信息
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 */
	public BankAccountPO findBankAccount(BankAccountPO account)
			throws RemoteException, ElementNotFoundException;
	/**
	 * 前置条件：无
	 * 后置条件：Data层查询得到所有账户信息并返回
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<BankAccountPO>  getAllAccounts()
			throws RemoteException;
	
}
