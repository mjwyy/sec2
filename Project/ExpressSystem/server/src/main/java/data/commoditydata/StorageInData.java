package data.commoditydata;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import po.StorageInPO;
import data.commoditydata.mock_object.MockStorageInPO;
import dataservice.commoditydataservice.StorageInDataService;

public class StorageInData implements StorageInDataService {

	ArrayList<MockStorageInPO> mock = new ArrayList<>();
	
	
	public StorageInData() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean insert(StorageInPO po) throws RemoteException {
		// TODO Auto-generated method stub
		mock.add((MockStorageInPO) po);
		return true;
	}

	@Override
	public boolean delete(StorageInPO po) throws RemoteException {
		// TODO Auto-generated method stub
		if(mock.contains(po)) {
			mock.remove(po);
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean update(StorageInPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
		Iterator it = mock.iterator();
		boolean removed = false;
		while(it.hasNext()) {
			if(it.next().equals(po)) {
				it.remove();
				removed = true;
			}
		}
		
		if(removed) {
			mock.add((MockStorageInPO) po);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public ArrayList<StorageInPO> find(StorageInPO po) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<StorageInPO> result = new ArrayList<>();
		
		if(mock.contains(po)) {
			result.add(po);
		}
		
		return result;
	}

}
