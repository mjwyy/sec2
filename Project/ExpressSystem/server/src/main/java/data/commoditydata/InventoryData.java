package data.commoditydata;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.util.ArrayList;

import po.InventoryPO;
import dataservice.commoditydataservice.InventoryDataService;

public class InventoryData implements InventoryDataService {

	private Connection connection;
	
	public InventoryData() {
		super();
	}
	
    @Override
    public ArrayList<InventoryPO> findByTime(String sTime, String eTime,String staffID) throws RemoteException {
        InventoryPO po1 = new InventoryPO(null,null,null,null);
        ArrayList<InventoryPO> list = new ArrayList<InventoryPO>();
        list.add(po1);
        return list;
    }
    
    @Override
    public ArrayList<InventoryPO> findAll(String staffID) throws RemoteException {
        InventoryPO po1 = new InventoryPO(null,null,null,null);
        ArrayList<InventoryPO> list = new ArrayList<InventoryPO>();
        list.add(po1);
        return list;
    }

	@Override
	public boolean setRecentTime(String staffID) {
		// TODO Auto-generated method stub
		return false;
	}
    
    
}
