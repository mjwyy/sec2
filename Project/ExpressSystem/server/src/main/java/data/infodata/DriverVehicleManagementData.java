package data.infodata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.DriverPO;
import po.VehiclePO;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import dataservice.infodataservice.DriverVehicleManagementDataService;

public class DriverVehicleManagementData implements DriverVehicleManagementDataService{

	@Override
	public boolean addDriver(DriverPO driver) throws RemoteException,
			InterruptWithExistedElementException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addVehicle(VehiclePO vehicle) throws RemoteException,
			InterruptWithExistedElementException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeDriver(DriverPO driver) throws RemoteException,
			ElementNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeVehicle(VehiclePO vehicle) throws RemoteException,
			ElementNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyDriver(DriverPO originalDriver, DriverPO modified)
			throws RemoteException, ElementNotFoundException,
			InterruptWithExistedElementException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyVehicle(VehiclePO originalVehicle, VehiclePO modified)
			throws RemoteException, ElementNotFoundException,
			InterruptWithExistedElementException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<DriverPO> getAllDriver() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<VehiclePO> getAllVehicles() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DriverPO> inquireDriver(DriverPO keywords)
			throws RemoteException, ElementNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<VehiclePO> inquireVehicle(VehiclePO keywords)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
