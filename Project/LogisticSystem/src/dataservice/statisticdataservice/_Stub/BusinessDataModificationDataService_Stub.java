package dataservice.statisticdataservice._Stub;
/**
 * @author wwz
 * @data 2015-10-22
 */
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.statisticdataservice.BusinessDataModificationDataService;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import po.DistancePO;

// TODO
public class BusinessDataModificationDataService_Stub implements BusinessDataModificationDataService{

	@Override
	public boolean setDistance(double distance, String city1, String city2)
			throws RemoteException, ElementNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setPrice(String name, double newValue) throws RemoteException, ElementNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addCity(String name) throws RemoteException, InterruptWithExistedElementException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<String> getAllCities() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getDistance(String city1, String city2) throws RemoteException, ElementNotFoundException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getPrice(String name) throws RemoteException, ElementNotFoundException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setDistance(DistancePO distancePO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getDistance(DistancePO distancePO) {
		// TODO Auto-generated method stub
		
	}



	

}
