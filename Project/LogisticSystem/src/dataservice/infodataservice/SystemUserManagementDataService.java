package dataservice.infodataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.util.exception.ElementNotFoundException;
import dataservice.util.exception.InterruptWithExistedElementException;
import po.UserPO;

public interface SystemUserManagementDataService extends Remote {
	/**
	 * Data向数据库中添加对应UserPO记录
     *
	 * @param user
	 * @return true for successful add operation
	 * @throws RemoteException
	 * @throws InterruptWithExistedElementException
	 */
	public boolean addUser(UserPO user)
			throws RemoteException, InterruptWithExistedElementException;

	/**
	 * Data从数据库中删除对应UserPO条目
     *
	 * @param user
	 * @return
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 */
	public boolean removeUser(UserPO user)
			throws RemoteException, ElementNotFoundException;

	/**
	 * Data将originalUserPO替换为modifiedUserPO
     *
	 * @param originalUser
	 * @param modified
	 * @return
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 */
	public boolean modifyUser(UserPO originalUser,UserPO modified)
			throws RemoteException, ElementNotFoundException,InterruptWithExistedElementException;

	/**
	 * Data查询对应的用户并返回其UserPO
     *
	 * @param userInfo
	 * @return
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 */
	public UserPO inquireUser(String acount)
			throws RemoteException, ElementNotFoundException;

	/**
	 * Data返回所有的UserPO
     *
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<UserPO> getAllUsers()
			throws RemoteException;


}
