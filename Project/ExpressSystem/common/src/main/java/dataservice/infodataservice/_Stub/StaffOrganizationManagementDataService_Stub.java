package dataservice.infodataservice._Stub;
/**
 * @author wwz
 * @data 2015/10/22
 *
 */
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.infodataservice.StaffOrganizationManagementDataService;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import po.OrganizationPO;
import po.StaffPO;

public class StaffOrganizationManagementDataService_Stub implements StaffOrganizationManagementDataService{


	public boolean addStaff(StaffPO staff) throws RemoteException,
			InterruptWithExistedElementException {
		System.out.println("add staff success");
		return true;
	}

	public boolean addOrganization(OrganizationPO org) throws RemoteException,
			InterruptWithExistedElementException {
		System.out.println("add organization success");
		return false;
	}

	public boolean removeStaff(StaffPO staff) throws RemoteException,
			ElementNotFoundException {
		System.out.println("remove staff success");
		return true;
	}

	public boolean removeOrganization(OrganizationPO org)
			throws RemoteException, ElementNotFoundException {
		System.out.println("remove success");
		return true;
	}

	public boolean modifyStaff(StaffPO original, StaffPO modified)
			throws RemoteException, ElementNotFoundException,
			InterruptWithExistedElementException {
		System.out.println("modify success");
		return true;
	}

	public boolean modifyOrganization(OrganizationPO original,
			OrganizationPO modified) throws RemoteException,
			ElementNotFoundException, InterruptWithExistedElementException {
		System.out.println("modify success");
		return true;
	}

	public ArrayList<StaffPO> getAllStaff() throws RemoteException {
		System.out.println("get success");
		return null;
	}

	public ArrayList<OrganizationPO> getAllOrganizations()
			throws RemoteException {
		System.out.println("get success");
		return null;
	}

	public ArrayList<StaffPO> findStaff(StaffPO info) throws RemoteException,
			ElementNotFoundException {
		System.out.println("find success");
		return null;
	}

	public ArrayList<OrganizationPO> findOrganization(OrganizationPO info)
			throws RemoteException, ElementNotFoundException {
		System.out.println("find success");
		return null;
	}
	
    
}
