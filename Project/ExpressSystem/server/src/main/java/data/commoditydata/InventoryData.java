package data.commoditydata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.InventoryPO;
import dataservice.commoditydataservice.InventoryDataService;

public class InventoryData implements InventoryDataService {


    @Override
    public ArrayList<InventoryPO> findByTime(String sTime, String eTime) throws RemoteException {
        InventoryPO po1 = new InventoryPO(null,null,null,null);
        ArrayList<InventoryPO> list = new ArrayList<InventoryPO>();
        list.add(po1);
        return list;
    }

    @Override
    public ArrayList<InventoryPO> findAll() throws RemoteException {
        InventoryPO po1 = new InventoryPO(null,null,null,null);
        ArrayList<InventoryPO> list = new ArrayList<InventoryPO>();
        list.add(po1);
        return list;
    }
}
