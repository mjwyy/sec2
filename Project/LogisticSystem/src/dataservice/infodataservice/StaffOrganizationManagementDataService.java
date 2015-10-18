package dataservice.infodataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.data_service_exception.ElementNotFoundException;
import dataservice.data_service_exception.InterruptWithExistedElementException;
import po.OrganizationPO;
import po.StaffPO;

public interface StaffOrganizationManagementDataService extends Remote {
	/**
	 * 前置条件：经过了格式检查
	 * 后置条件：Data向数据中增加员工信息
	 * @param staff
	 * @return
	 * @throws RemoteException
	 * @throws InterruptWithExistedElementException
	 */
	public boolean addStaff(StaffPO staff)
			throws RemoteException,InterruptWithExistedElementException;
	
	public boolean addOrganization(OrganizationPO org)
			throws RemoteException,InterruptWithExistedElementException;
	
	public boolean removeStaff(StaffPO staff)
			throws RemoteException,ElementNotFoundException;
	
	public boolean removeOrganization(OrganizationPO org)
			throws RemoteException,ElementNotFoundException;
	
	public boolean modifyStaff(StaffPO original,StaffPO modified)
			throws RemoteException,ElementNotFoundException,InterruptWithExistedElementException;
	
	public boolean modifyOrganization(OrganizationPO original,OrganizationPO modified)
			throws RemoteException,ElementNotFoundException,InterruptWithExistedElementException;
	
	public StaffPO findStaff(StaffPO name)
			throws RemoteException,ElementNotFoundException;
	
	public OrganizationPO findOrganization(OrganizationPO name)
			throws RemoteException,ElementNotFoundException;
	
	public ArrayList<StaffPO> getAllStaff()
			throws RemoteException;
	
	public ArrayList<OrganizationPO> getAllOrganizations()
			throws RemoteException;
	
	
}
