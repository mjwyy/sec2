package dataservice.statisticdataservice;
/**
 * @author wwz
 * @data 2015-10-22
 */
import java.rmi.RemoteException;

import dataservice.util.exception.ElementNotFoundException;
import dataservice.util.exception.InterruptWithExistedElementException;
import po.DistancePO;

public class BusinessDataModificationDataService_Driver {
	private DistancePO distancePO;
	
	public BusinessDataModificationDataService_Driver() {
	distancePO = new DistancePO("上海","南京",1000000.0);
	}

	public void drive(BusinessDataModificationDataService businessDataService) throws RemoteException, InterruptWithExistedElementException, ElementNotFoundException {
		businessDataService.addCity("");
		businessDataService.setDistance(distancePO);
		businessDataService.setPrice("汽油",97.0);
		businessDataService.getAllCities();
		businessDataService.getDistance(distancePO);	
	}
	
	public static void main(String[] args) throws RemoteException, InterruptWithExistedElementException, ElementNotFoundException {
		BusinessDataModificationDataService_Stub stub = new BusinessDataModificationDataService_Stub();
		BusinessDataModificationDataService_Driver driver = new BusinessDataModificationDataService_Driver();
		driver.drive(stub);
	}

}
