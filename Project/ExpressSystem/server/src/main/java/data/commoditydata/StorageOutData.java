package data.commoditydata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.StorageOutPO;
import dataservice.commoditydataservice.StorageOutDataService;

public class StorageOutData implements StorageOutDataService {

    @Override
    public boolean insert(StorageOutPO po) throws RemoteException {
        return false;
    }

    @Override
    public boolean delete(StorageOutPO po) throws RemoteException {
        return false;
    }

    @Override
    public boolean update(StorageOutPO po) throws RemoteException {
        return false;
    }

    @Override
    public ArrayList<StorageOutPO> find(StorageOutPO po) throws RemoteException {
        return null;
    }
}
