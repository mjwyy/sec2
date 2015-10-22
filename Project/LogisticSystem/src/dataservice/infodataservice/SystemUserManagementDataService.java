package dataservice.infodataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.util.exception.ElementNotFoundException;
import dataservice.util.exception.InterruptWithExistedElementException;
import po.UserPO;

public interface SystemUserManagementDataService extends Remote {
	/**
	 * ǰ��������UserPO����Ϣ�Ѿ����ʽ���
	 * ����������Data�����������û���Ϣ
	 * @param user
	 * @return true for successful add operation
	 * @throws RemoteException
	 * @throws InterruptWithExistedElementException
	 */
	public boolean addUser(UserPO user)
			throws RemoteException, InterruptWithExistedElementException;
	
	/**
	 * ǰ��������UserPO����Ϣ�Ѿ����ʽ���
	 * ����������Data���Ҳ�ɾ����û�
	 * @param user
	 * @return
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 */
	public boolean removeUser(UserPO user)
			throws RemoteException, ElementNotFoundException;
	
	/**
	 * ǰ����������
	 * ����������Data���originalUser�����û�����modified���֮
	 * @param originalUser
	 * @param modified
	 * @return
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 */
	public boolean modifyUser(UserPO originalUser,UserPO modified)
			throws RemoteException, ElementNotFoundException,InterruptWithExistedElementException;
	
	/**
	 * ǰ��������userInfo�����˸�ʽ��������а�������һ����Ϣ
	 * ����������Data���Ҵ��û���������������Ϣ
	 * @param userInfo
	 * @return
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 */
	public UserPO inquireUser(String acount)
			throws RemoteException, ElementNotFoundException;
	
	/**
	 * ǰ����������
	 * ����������Data���������û���Ϣ
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<UserPO> getAllUsers()
			throws RemoteException;
}
