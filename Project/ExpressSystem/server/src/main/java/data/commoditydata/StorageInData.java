package data.commoditydata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.StorageInPO;
import dataservice.commoditydataservice.StorageInDataService;

public class StorageInData implements StorageInDataService {


    @Override
    public boolean insert(StorageInPO po) throws RemoteException {
        return false;
    }

    @Override
    public boolean delete(StorageInPO po) throws RemoteException {
        return false;
    }

    @Override
    public boolean update(StorageInPO po) throws RemoteException {
        return false;
    }

    @Override
    public ArrayList<StorageInPO> find(StorageInPO po) throws RemoteException {
        return null;
    }
}
