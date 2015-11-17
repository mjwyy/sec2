package data.infodata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.OrganizationPO;
import po.StaffPO;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import dataservice.infodataservice.StaffOrganizationManagementDataService;

public class StaffOrganizationManagementData implements
		StaffOrganizationManagementDataService {

	public StaffOrganizationManagementData() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addStaff(StaffPO staff) throws RemoteException,
			InterruptWithExistedElementException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addOrganization(OrganizationPO org) throws RemoteException,
			InterruptWithExistedElementException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeStaff(StaffPO staff) throws RemoteException,
			ElementNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeOrganization(OrganizationPO org)
			throws RemoteException, ElementNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyStaff(StaffPO original, StaffPO modified)
			throws RemoteException, ElementNotFoundException,
			InterruptWithExistedElementException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyOrganization(OrganizationPO original,
			OrganizationPO modified) throws RemoteException,
			ElementNotFoundException, InterruptWithExistedElementException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<StaffPO> findStaff(StaffPO info) throws RemoteException,
			ElementNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrganizationPO> findOrganization(OrganizationPO info)
			throws RemoteException, ElementNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<StaffPO> getAllStaff() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrganizationPO> getAllOrganizations()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
