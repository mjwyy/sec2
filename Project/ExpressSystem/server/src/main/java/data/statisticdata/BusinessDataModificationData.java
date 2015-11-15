package data.statisticdata;
/**
 * @author wwz
 * @date 2015/11/14
 */
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.DistancePO;
import util.enums.PriceType;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import dataservice.statisticdataservice.BusinessDataModificationDataService;

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
	public void setDistance(DistancePO distancePO) throws RemoteException,
			ElementNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getDistance(DistancePO distancePO) throws RemoteException,
			ElementNotFoundException {
		// TODO Auto-generated method stub
		
	}
	

}
