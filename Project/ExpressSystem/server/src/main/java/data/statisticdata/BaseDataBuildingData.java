package data.statisticdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataservice.statisticdataservice.BaseDataBuildingDataService;

public class BaseDataBuildingData extends UnicastRemoteObject implements BaseDataBuildingDataService{

    protected BaseDataBuildingData() throws RemoteException {
    }

    @Override
	public boolean startBaseDataBuilding(boolean withBase)
			throws RemoteException {
		return true;
	}

	@Override
	public boolean endBaseDataBuilding() throws RemoteException {
		return true;
	}
	

}
