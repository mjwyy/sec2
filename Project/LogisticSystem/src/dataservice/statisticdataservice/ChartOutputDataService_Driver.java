package dataservice.statisticdataservice;
/**
 * @author wwz
 * @data 2015-10-22
 */
import java.rmi.RemoteException;

import po.ChartPO;

public class ChartOutputDataService_Driver {
	private ChartPO chartPO;

	public ChartOutputDataService_Driver() {
		chartPO = new ChartPO();
	}
	
	public void drive(ChartOutputDataService coDataService) throws RemoteException {
		coDataService.getChart(chartPO);	
	}
	
	public static void main(String[] args) throws RemoteException {
		ChartOutputDataService_Stub stub = new ChartOutputDataService_Stub();
		ChartOutputDataService_Driver driver = new ChartOutputDataService_Driver();
		driver.drive(stub);
	}
	
	
	

}
