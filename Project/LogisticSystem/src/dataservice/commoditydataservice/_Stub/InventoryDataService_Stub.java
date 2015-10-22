package dataservice.commoditydataservice._Stub;

import dataservice.commoditydataservice.InventoryDataService;
import po.InventoryPO;
import po.StorageInPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/10/20.
 */
public class InventoryDataService_Stub implements InventoryDataService {

    private InventoryPO inventoryPO1;
    private InventoryPO inventoryPO2;
    private ArrayList<InventoryPO> inventoryPOs;

    public InventoryDataService_Stub() {
    	inventoryPOs = new ArrayList<InventoryPO>();
        ArrayList<String> place1 = new ArrayList<String>();
        place1.add("31区2排1架100位");
        place1.add("33区4排1架100位");
        place1.add("5区5排1架100位");
        place1.add("34区7排1架100位");
        place1.add("33区8排1架100位");
        place1.add("3区99排1架100位");
        inventoryPO1 = new InventoryPO("10","20","1000",place1);

        ArrayList<String> place2 = new ArrayList<String>();
        place2.add("6区8排1架100位");
        place2.add("3区99排1架100位");
        place2.add("3区99排1架20位");
        inventoryPO2 = new InventoryPO("10","20","1000",place2);

        inventoryPOs.add(inventoryPO1);
        inventoryPOs.add(inventoryPO2);
    }

    @Override
    public ArrayList<InventoryPO> findByTime(String sTime, String eTime) throws RemoteException {
        System.out.println("InventoryDataService findByTime succeed");
        return inventoryPOs;
    }

    @Override
    public ArrayList<InventoryPO> findAll() throws RemoteException {
        System.out.println("InventoryDataService findAll succeed");
        return inventoryPOs;
    }
}
