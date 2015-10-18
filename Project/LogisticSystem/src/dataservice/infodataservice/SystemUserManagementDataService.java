package dataservice.infodataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.UserPO;
import dataservice.data_service_exception.ElementNotFoundException;
import dataservice.data_service_exception.InterruptWithExistedElementException;

public interface SystemUserManagementDataService extends Remote {
	/**
	 * 前置条件：UserPO内信息已经过格式检查
	 * 后置条件：Data向数据内添加用户信息
	 * @param user
	 * @return true for successful add operation
	 * @throws RemoteException
	 * @throws InterruptWithExistedElementException
	 */
	public boolean addUser(UserPO user)
			throws RemoteException, InterruptWithExistedElementException;
	
	/**
	 * 前置条件：UserPO内信息已经过格式检查
	 * 后置条件：Data查找并删除此用户
	 * @param user
	 * @return
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 */
	public boolean removeUser(UserPO user)
			throws RemoteException, ElementNotFoundException;
	
	/**
	 * 前置条件：无
	 * 后置条件：Data根据originalUser查找用户并用modified替代之
	 * @param originalUser
	 * @param modified
	 * @return
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 */
	public boolean modifyUser(UserPO originalUser,UserPO modified)
			throws RemoteException, ElementNotFoundException,InterruptWithExistedElementException;
	
	/**
	 * 前置条件：userInfo经过了格式检查且其中包含了至少一条信息
	 * 后置条件：Data查找此用户并返回其完整信息
	 * @param userInfo
	 * @return
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 */
	public UserPO inquireUser(UserPO userInfo)
			throws RemoteException, ElementNotFoundException;
	
	/**
	 * 前置条件：无
	 * 后置条件：Data返回所有用户信息
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<UserPO> getAllUsers()
			throws RemoteException;
}
