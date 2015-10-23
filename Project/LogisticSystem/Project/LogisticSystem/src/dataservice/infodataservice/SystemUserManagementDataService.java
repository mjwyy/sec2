package dataservice.infodataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.util.exception.ElementNotFoundException;
import dataservice.util.exception.InterruptWithExistedElementException;
import po.UserPO;

public interface SystemUserManagementDataService extends Remote {
	/**
	 * 前锟斤拷锟斤拷锟斤拷锟斤拷UserPO锟斤拷锟斤拷息锟窖撅拷锟斤拷锟绞斤拷锟斤拷
	 * 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷Data锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟矫伙拷锟斤拷息
	 * @param user
	 * @return true for successful add operation
	 * @throws RemoteException
	 * @throws InterruptWithExistedElementException
	 */
	public boolean addUser(UserPO user)
			throws RemoteException, InterruptWithExistedElementException;
	
	/**
	 * 前锟斤拷锟斤拷锟斤拷锟斤拷UserPO锟斤拷锟斤拷息锟窖撅拷锟斤拷锟绞斤拷锟斤拷
	 * 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷Data锟斤拷锟揭诧拷删锟斤拷锟斤拷没锟�
	 * @param user
	 * @return
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 */
	public boolean removeUser(UserPO user)
			throws RemoteException, ElementNotFoundException;
	
	/**
	 * 前锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
	 * 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷Data锟斤拷锟給riginalUser锟斤拷锟斤拷锟矫伙拷锟斤拷锟斤拷modified锟斤拷锟街�
	 * @param originalUser
	 * @param modified
	 * @return
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 */
	public boolean modifyUser(UserPO originalUser,UserPO modified)
			throws RemoteException, ElementNotFoundException,InterruptWithExistedElementException;
	
	/**
	 * 前锟斤拷锟斤拷锟斤拷锟斤拷userInfo锟斤拷锟斤拷锟剿革拷式锟斤拷锟斤拷锟斤拷锟斤拷邪锟斤拷锟斤拷锟斤拷锟揭伙拷锟斤拷锟较�
	 * 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷Data锟斤拷锟揭达拷锟矫伙拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷息
	 * @param userInfo
	 * @return
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 */
	public UserPO inquireUser(UserPO userInfo)
			throws RemoteException, ElementNotFoundException;
	
	/**
	 * 前锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
	 * 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷Data锟斤拷锟斤拷锟斤拷锟斤拷锟矫伙拷锟斤拷息
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<UserPO> getAllUsers()
			throws RemoteException;
	/**
	 * 前置条件：无
	 * 后置条件：Data查询UserPO中的内容是否正确，包括账号密码匹配、权限检查
	 * @param user
	 * @return
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 */
	public boolean logIn(UserPO user)
			throws RemoteException, ElementNotFoundException;
}
