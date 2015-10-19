package dataservice.infodataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.util.exception.ElementNotFoundException;
import dataservice.util.exception.InterruptWithExistedElementException;
import po.OrganizationPO;
import po.StaffPO;

public interface StaffOrganizationManagementDataService extends Remote {
	/**
	 * ǰ�������������˸�ʽ���
	 * ����������Data�����������Ա����Ϣ
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
