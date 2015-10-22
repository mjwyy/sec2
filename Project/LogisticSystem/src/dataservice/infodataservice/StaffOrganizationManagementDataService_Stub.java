package dataservice.infodataservice;
/**
 * @author wwz
 * @data 2015/10/22
 *
 */
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.util.exception.ElementNotFoundException;
import dataservice.util.exception.InterruptWithExistedElementException;
import po.OrganizationPO;
import po.StaffPO;

public class StaffOrganizationManagementDataService_Stub implements StaffOrganizationManagementDataService{


	@Override
	public boolean addStaff(StaffPO staff) throws RemoteException,
			InterruptWithExistedElementException {
		System.out.println("add staff success");
		return true;
	}

	@Override
	public boolean addOrganization(OrganizationPO org) throws RemoteException,
			InterruptWithExistedElementException {
		System.out.println("add organization success");
		return false;
	}

	@Override
	public boolean removeStaff(StaffPO staff) throws RemoteException,
			ElementNotFoundException {
		System.out.println("remove staff success");
		return true;
	}

	@Override
	public boolean removeOrganization(OrganizationPO org)
			throws RemoteException, ElementNotFoundException {
		System.out.println("remove success");
		return true;
	}

	@Override
	public boolean modifyStaff(StaffPO original, StaffPO modified)
			throws RemoteException, ElementNotFoundException,
			InterruptWithExistedElementException {
		System.out.println("modify success");
		return true;
	}

	@Override
	public boolean modifyOrganization(OrganizationPO original,
			OrganizationPO modified) throws RemoteException,
			ElementNotFoundException, InterruptWithExistedElementException {
		System.out.println("modify success");
		return true;
	}

	@Override
	public StaffPO findStaff(String name) throws RemoteException,
			ElementNotFoundException {
		System.out.println("find success");
		return null;
	}

	@Override
	public OrganizationPO findOrganization(String name)
			throws RemoteException, ElementNotFoundException {
		System.out.println("find success");
		return null;
	}

	@Override
	public ArrayList<StaffPO> getAllStaff() throws RemoteException {
		System.out.println("get success");
		return null;
	}

	@Override
	public ArrayList<OrganizationPO> getAllOrganizations()
			throws RemoteException {
		System.out.println("get success");
		return null;
	}
	
    
}
