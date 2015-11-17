package data.commoditydata;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import po.StorageInPO;
import po.StorageOutPO;
import data.commoditydata.mock_object.MockStorageInPO;
import data.commoditydata.mock_object.MockStorageOutPO;
import dataservice.commoditydataservice.StorageOutDataService;

public class StorageOutData implements StorageOutDataService {

	ArrayList<MockStorageOutPO> mock = new ArrayList<>();
	
	public StorageOutData() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean insert(StorageOutPO po) throws RemoteException {
		// TODO Auto-generated method stub
		mock.add((MockStorageOutPO) po);
		return true;
	}

	@Override
	public boolean delete(StorageOutPO po) throws RemoteException {
		// TODO Auto-generated method stub
		if(mock.contains(po)) {
			mock.remove(po);
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean update(StorageOutPO po) throws RemoteException {
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
			mock.add((MockStorageOutPO) po);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public ArrayList<StorageOutPO> find(StorageOutPO po) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<StorageOutPO> result = new ArrayList<>();
		
		if(mock.contains(po)) {
			result.add(po);
		}
		
		return result;
	}

}
