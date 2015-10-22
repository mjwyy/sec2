package dataservice.financedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.util.exception.ElementNotFoundException;
import dataservice.util.exception.InterruptWithExistedElementException;
import po.BankAccountPO;

public interface BankAccountManagementDataService extends Remote {

	/**
<<<<<<< HEAD
	 * Data向数据库中添加对应PO信息
	 *
=======
	 * ǰ��������BankAccountPO�����ڲ�����Ѿ����飬ȷ����ʽ����
	 * ����������Data���Ӧ��������ݿ�����˻���¼
>>>>>>> master
	 * @param account
	 * @return true for successful add operation
	 * @throws RemoteException
	 * @throws InterruptWithExistedElementException
	 */
	public boolean addBankAccount(BankAccountPO account) 
			throws RemoteException,	InterruptWithExistedElementException;
<<<<<<< HEAD

	/**
	 * Data删除对应PO记录
     *
=======
	
	/**
	 * ǰ��������BankAccountPO�����ڲ�����Ѿ����飬ȷ����ʽ����
	 * ����������Data���Ӧ��������ݿ�ɾ���˻���¼
>>>>>>> master
	 * @param account
	 * @return true for successful remove operation
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 */
	public boolean removeBankAccount(BankAccountPO account)
			throws RemoteException,	ElementNotFoundException;
<<<<<<< HEAD

	/**
	 * Data将originalAccount 替换为modifiedAccount
     *
=======
	
	/**
	 * ǰ��������BankAccountPO�����ڲ�����Ѿ����飬ȷ����ʽ����
	 * ����������Data���Ӧ��������ݿ����˻���¼�в���originalAccount�������滻ΪmodifiedAccount
>>>>>>> master
	 * @param originalAccount
	 * @param modifiedAccount
	 * @return true for successful remove operation
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 */
	public boolean modifyBankAccount(BankAccountPO originalAccount,BankAccountPO modifiedAccount)
			throws RemoteException,	ElementNotFoundException,InterruptWithExistedElementException;
<<<<<<< HEAD

	/**
	 * Data返回符合信息的BankAccountPO
     *
	 * @param account
	 * @return
=======
	
	/**
	 * ǰ��������BankAccountPO�����ڲ�����Ѿ����飬ȷ����ʽ����
	 * ����������Data���ݲ����еĲ���ȫ��Ϣ��ѯ�������˻���ϸ��Ϣ
	 * @param account
	 * @return ��ϸ�˻���Ϣ
>>>>>>> master
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 */
	public BankAccountPO findBankAccount(BankAccountPO account)
			throws RemoteException, ElementNotFoundException;
	/**
<<<<<<< HEAD
     * Data返回所有BankAccountPO记录
     *
=======
	 * ǰ����������
	 * ����������Data���ѯ�õ������˻���Ϣ������
>>>>>>> master
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<BankAccountPO>  getAllAccounts()
			throws RemoteException;
	
}
