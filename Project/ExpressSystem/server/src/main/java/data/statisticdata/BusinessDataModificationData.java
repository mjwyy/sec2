package data.statisticdata;
/**
 * @author wwz
 * @date 2015/11/14
 */
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.statisticdataservice.BusinessDataModificationDataService;
import po.DistancePO;
import util.enums.PriceType;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;

public class BusinessDataModificationData implements BusinessDataModificationDataService {

	@Override
	public boolean addCity(String name) throws RemoteException,
			InterruptWithExistedElementException {
		return false;
	}

	@Override
	public ArrayList<String> getAllCities() throws RemoteException {
		return null;
	}

	@Override
	public boolean setPrice(PriceType name, double newValue)
			throws RemoteException, ElementNotFoundException {
		return false;
	}

	@Override
	public double getPrice(PriceType name) throws RemoteException,
			ElementNotFoundException {
		return 0;
	}

	@Override
	public boolean setDistance(DistancePO distancePO) throws RemoteException,
			ElementNotFoundException {
		 
		return false;
		
	}

	@Override
	public DistancePO getDistance(DistancePO distancePO) throws RemoteException,
			ElementNotFoundException {
				return distancePO;
		 
		
	}
	

}
