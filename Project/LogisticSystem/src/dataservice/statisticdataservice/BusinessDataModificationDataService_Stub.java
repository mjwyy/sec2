package dataservice.statisticdataservice;
/**
 * @author wwz
 * @data 2015-10-22
 */
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.util.exception.ElementNotFoundException;
import dataservice.util.exception.InterruptWithExistedElementException;
import po.DistancePO;
import businesslogic.util.ConstantType;
import businesslogic.util.ResultMsg;
import businesslogicservice.statisticblservice.BusinessDataModificationBLService;

public class BusinessDataModificationDataService_Stub implements BusinessDataModificationDataService{

	@Override
	public boolean setDistance(DistancePO distancePO)
			throws RemoteException, ElementNotFoundException {
		System.out.println("set distance success");
		return false;
	}

	@Override
	public boolean setPrice(String name, double newValue)
			throws RemoteException, ElementNotFoundException {
		System.out.println("set price success");
		return false;
	}

	@Override
	public boolean addCity(String name) throws RemoteException,
			InterruptWithExistedElementException {
		System.out.println("add city success");
		return false;
	}

	@Override
	public ArrayList<String> getAllCities() throws RemoteException {
		System.out.println("get all citirs success");
		return null;
	}

	@Override
	public double getDistance(DistancePO distancePO) throws RemoteException,
			ElementNotFoundException {
		System.out.println("get distance success");
		return 0;
	}


	

}
