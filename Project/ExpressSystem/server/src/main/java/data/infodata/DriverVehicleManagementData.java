package data.infodata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.DriverPO;
import po.VehiclePO;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import dataservice.infodataservice.DriverVehicleManagementDataService;

public class DriverVehicleManagementData implements DriverVehicleManagementDataService{

	private static final long serialVersionUID = -5119026736015127919L;

	@Override
	public boolean addDriver(DriverPO driver) throws RemoteException,
			InterruptWithExistedElementException {
		return false;
	}

	@Override
	public boolean addVehicle(VehiclePO vehicle) throws RemoteException,
			InterruptWithExistedElementException {
		return false;
	}

	@Override
	public boolean removeDriver(DriverPO driver) throws RemoteException,
			ElementNotFoundException {
		return false;
	}

	@Override
	public boolean removeVehicle(VehiclePO vehicle) throws RemoteException,
			ElementNotFoundException {
		 
		return false;
	}

	@Override
	public ArrayList<DriverPO> getAllDriver() throws RemoteException {
		 
		return null;
	}

	@Override
	public ArrayList<VehiclePO> getAllVehicles() throws RemoteException {
		 
		return null;
	}

	@Override
	public ArrayList<DriverPO> inquireDriver(DriverPO keywords)
			throws RemoteException, ElementNotFoundException {
		 
		return null;
	}

	@Override
	public ArrayList<VehiclePO> inquireVehicle(VehiclePO keywords)
			throws RemoteException {
		 
		return null;
	}

	@Override
	public boolean modifyDriver(DriverPO driver) throws RemoteException,
			ElementNotFoundException, InterruptWithExistedElementException {
		return false;
	}

	@Override
	public boolean modifyVehicle(VehiclePO originalVehicle)
			throws RemoteException, ElementNotFoundException,
			InterruptWithExistedElementException {
		return false;
	}

}
