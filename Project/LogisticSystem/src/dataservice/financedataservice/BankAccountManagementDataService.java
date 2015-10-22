package dataservice.financedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.util.exception.ElementNotFoundException;
import dataservice.util.exception.InterruptWithExistedElementException;
import po.BankAccountPO;

public interface BankAccountManagementDataService extends Remote {

	/**
	 * ǰ��������BankAccountPO�����ڲ�����Ѿ����飬ȷ����ʽ����
	 * ����������Data���Ӧ��������ݿ�����˻���¼
	 * @param account
	 * @return true for successful add operation
	 * @throws RemoteException
	 * @throws InterruptWithExistedElementException
	 */
	public boolean addBankAccount(BankAccountPO account) 
			throws RemoteException,	InterruptWithExistedElementException;
	
	/**
	 * ǰ��������BankAccountPO�����ڲ�����Ѿ����飬ȷ����ʽ����
	 * ����������Data���Ӧ��������ݿ�ɾ���˻���¼
	 * @param account
	 * @return true for successful remove operation
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 */
	public boolean removeBankAccount(BankAccountPO account)
			throws RemoteException,	ElementNotFoundException;
	
	/**
	 * ǰ��������BankAccountPO�����ڲ�����Ѿ����飬ȷ����ʽ����
	 * ����������Data���Ӧ��������ݿ����˻���¼�в���originalAccount�������滻ΪmodifiedAccount
	 * @param originalAccount
	 * @param modifiedAccount
	 * @return true for successful remove operation
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 */
	public boolean modifyBankAccount(BankAccountPO originalAccount,BankAccountPO modifiedAccount)
			throws RemoteException,	ElementNotFoundException,InterruptWithExistedElementException;
	
	/**
	 * ǰ��������BankAccountPO�����ڲ�����Ѿ����飬ȷ����ʽ����
	 * ����������Data���ݲ����еĲ���ȫ��Ϣ��ѯ�������˻���ϸ��Ϣ
	 * @param account
	 * @return ��ϸ�˻���Ϣ
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 */
	public BankAccountPO findBankAccount(String number)
			throws RemoteException, ElementNotFoundException;
	/**
	 * ǰ����������
	 * ����������Data���ѯ�õ������˻���Ϣ������
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<BankAccountPO>  getAllAccounts()
			throws RemoteException;
	
}
