package dataservice.statisticdataservice;
/**
 * @author wwz
 * @data 2015-10-22
 */
import java.rmi.RemoteException;

public class BaseDataBuildingDataService_Driver {
	
	public void drive(BaseDataBuildingDataService baseDataBuildingDataService) throws RemoteException{
		baseDataBuildingDataService.startBaseDataBuilding(false);
		baseDataBuildingDataService.startBaseDataBuilding(true);
		baseDataBuildingDataService.endBaseDataBuilding();		
	}
	
	public static void main(String[] args) throws RemoteException{
		BaseDataBuildingDataService_Stub  baseDataBuildingDataService_Stub  = new BaseDataBuildingDataService_Stub();
		BaseDataBuildingDataService_Driver baseDataBuildingDataService_Driver = new BaseDataBuildingDataService_Driver();
		baseDataBuildingDataService_Driver.drive(baseDataBuildingDataService_Stub);
	}

}
