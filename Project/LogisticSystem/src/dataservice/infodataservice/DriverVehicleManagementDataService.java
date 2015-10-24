package dataservice.infodataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.util.exception.ElementNotFoundException;
import dataservice.util.exception.InterruptWithExistedElementException;
import po.DriverPO;
import po.VehiclePO;

public interface DriverVehicleManagementDataService extends Remote {

	/**
	 * ǰ��������DriverPO����Ϣ�����˸�ʽ���
	 * ����������Data��������м���˼�¼
	 * @param driver
	 * @return
	 * @throws RemoteException
	 * @throws InterruptWithExistedElementException
	 */
	public boolean addDriver(DriverPO driver)
			throws RemoteException,InterruptWithExistedElementException;
	
	public boolean addVehicle(VehiclePO vehicle)
			throws RemoteException,InterruptWithExistedElementException;
	
	public boolean removeDriver(DriverPO driver)
			throws RemoteException,ElementNotFoundException;
	
	public boolean removeVehicle(VehiclePO vehicle)
			throws RemoteException,ElementNotFoundException;
	
	public boolean modifyDriver(DriverPO originalDriver,DriverPO modified)
			throws RemoteException,ElementNotFoundException,InterruptWithExistedElementException;
	
	public boolean modifyVehicle(VehiclePO originalVehicle,VehiclePO modified)
			throws RemoteException,ElementNotFoundException,InterruptWithExistedElementException;
	
	public ArrayList<DriverPO> getAllDriver()
			throws RemoteException;
	
	public ArrayList<VehiclePO> getAllVehicles()
			throws RemoteException;
	
<<<<<<< HEAD
	public ArrayList<DriverPO> inquireDriver(String string)
			throws RemoteException,ElementNotFoundException;
	
	public ArrayList<VehiclePO> inquireVehicle(String keywords)
=======
	public ArrayList<DriverPO> inquireDriver(String[] keywords)
			throws RemoteException,ElementNotFoundException;
	
	public ArrayList<VehiclePO> inquireVehicle(String[] keywords)
>>>>>>> parent of 2d8eb69... 10.22这个世界没有锟斤拷版本
			throws RemoteException;
	
	
}
