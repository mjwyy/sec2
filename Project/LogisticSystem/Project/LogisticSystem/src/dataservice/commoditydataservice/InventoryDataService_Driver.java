package dataservice.commoditydataservice;

import po.InventoryPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/10/20.
 */
public class InventoryDataService_Driver {

    public void drive(InventoryDataService inventoryDataService) throws RemoteException {
        inventoryDataService.findAll();
        inventoryDataService.findByTime("2015-10-01","2015-10-11");
        inventoryDataService.findByTime("2015-10-12","2015-11-26");
        inventoryDataService.findByTime("2015-11-01","2015-12-11");
    }

    public static void main(String[] args) throws RemoteException {
        InventoryDataService inventoryDataService = new InventoryDataService_Stub();
        InventoryDataService_Driver driver = new InventoryDataService_Driver();
        driver.drive(inventoryDataService);
    }

}
