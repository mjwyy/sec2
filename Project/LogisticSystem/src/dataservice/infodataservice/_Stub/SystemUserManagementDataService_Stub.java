package dataservice.infodataservice._Stub;
/**
 * @author wwz
 * @data 2015/10/22
 *
 */
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.UserPO;
import dataservice.infodataservice.SystemUserManagementDataService;
import dataservice.util.exception.ElementNotFoundException;
import dataservice.util.exception.InterruptWithExistedElementException;

public class SystemUserManagementDataService_Stub implements SystemUserManagementDataService{

	@Override
	public boolean addUser(UserPO user) throws RemoteException,
			InterruptWithExistedElementException {
		System.out.println("add success");
		return false;
	}

	@Override
	public boolean removeUser(UserPO user) throws RemoteException,
			ElementNotFoundException {
		System.out.println("remove success");
		return false;
	}

	@Override
	public boolean modifyUser(UserPO originalUser, UserPO modified)
			throws RemoteException, ElementNotFoundException,
			InterruptWithExistedElementException {
		System.out.println("modift success");
		return false;
	}

	@Override
	public UserPO inquireUser(String account) throws RemoteException,
			ElementNotFoundException {
		System.out.println("inquireUser success");
		return null;
	}

	@Override
	public ArrayList<UserPO> getAllUsers() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("get success");
		return null;
	}
	

}
