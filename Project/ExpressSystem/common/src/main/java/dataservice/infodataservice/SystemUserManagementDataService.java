package dataservice.infodataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import po.UserPO;

/**
* @author River
*/
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
            throws Exception;

	/**
	 * Data从数据库中删除对应UserPO条目
     *
	 * @param user
	 * @return
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 */
	public boolean removeUser(UserPO user)
            throws Exception;

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
			throws RemoteException, ElementNotFoundException,InterruptWithExistedElementException, Exception;
	/**
	 * Data查询对应的用户并返回其UserPO
     *
	 * @param info
	 * @return
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 */
	public ArrayList<UserPO> inquireUser(UserPO info)
			throws RemoteException, ElementNotFoundException, Exception;

	/**
	 * Data返回所有的UserPO
     *
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<UserPO> getAllUsers()
            throws Exception;


}
