package data.commoditydata;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import po.InventoryPO;
import data.commoditydata.mock_object.MockInventoryPO;
import dataservice.commoditydataservice.InventoryDataService;

public class InventoryData implements InventoryDataService {

	ArrayList<MockInventoryPO> mock = new ArrayList<>();
	
	public InventoryData() {
		mock.add(new MockInventoryPO(null, null, null, null, "2015-03-21"));
		mock.add(new MockInventoryPO(null, null, null, null, "2015-07-25"));
		mock.add(new MockInventoryPO(null, null, null, null, "2015-06-12"));
		mock.add(new MockInventoryPO(null, null, null, null, "2015-02-01"));
		mock.add(new MockInventoryPO(null, null, null, null, "2015-11-30"));
		mock.add(new MockInventoryPO(null, null, null, null, "2015-12-05"));
		mock.add(new MockInventoryPO(null, null, null, null, "2015-07-08"));
		mock.add(new MockInventoryPO(null, null, null, null, "2015-01-31"));
	}

	@Override
	public ArrayList<InventoryPO> findByTime(String sTime, String eTime)
			throws RemoteException {
		// TODO Auto-generated method stub
		Iterator it = mock.iterator();
		ArrayList<InventoryPO> result = new ArrayList<>();
		
		while(it.hasNext()) {
			MockInventoryPO temp = (MockInventoryPO) it.next();
			if(temp.getTime().compareTo(sTime)>=0&&temp.getTime().compareTo(eTime)<=0) {
				result.add(temp);
			}
		}
		
		return result;
	}

	@Override
	public ArrayList<InventoryPO> findAll() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<InventoryPO> result = new ArrayList<>();
		for(MockInventoryPO po:mock) {
			result.add(po);
		}
		return result;
	}

}
