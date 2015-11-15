package data.infodata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.UserPO;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import dataservice.infodataservice.SystemUserManagementDataService;

public class SystemUserManagementData implements SystemUserManagementDataService{

	@Override
	public boolean addUser(UserPO user) throws RemoteException,
			InterruptWithExistedElementException {
		return false;
	}

	@Override
	public boolean removeUser(UserPO user) throws RemoteException,
			ElementNotFoundException {
		return false;
	}

	@Override
	public boolean modifyUser(UserPO originalUser, UserPO modified)
			throws RemoteException, ElementNotFoundException,
			InterruptWithExistedElementException {
		return false;
	}

	@Override
	public ArrayList<UserPO> inquireUser(UserPO info) throws RemoteException,
			ElementNotFoundException {
		return null;
	}

	@Override
	public ArrayList<UserPO> getAllUsers() throws RemoteException {
		return null;
	}

}
