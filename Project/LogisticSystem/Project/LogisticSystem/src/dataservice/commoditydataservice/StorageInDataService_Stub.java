package dataservice.commoditydataservice;

import po.GoodsPO;
import po.StorageInPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/10/21.
 */
public class StorageInDataService_Stub implements StorageInDataService {

    @Override
    public void insert(StorageInPO po) throws RemoteException {
        System.out.println("insert succeed!");
    }

    @Override
    public void delete(StorageInPO po) throws RemoteException {
        System.out.println("delete succeed!");
    }

    @Override
    public void update(StorageInPO po) throws RemoteException {
        System.out.println("update succeed!");
    }

    @Override
    public StorageInPO find(String name) throws RemoteException {
        System.out.println("find succeed!");
        ArrayList<GoodsPO> GoodsInStorageInfo = new  ArrayList<GoodsPO>();
        StorageInPO inPO = new StorageInPO("2015-10-09",GoodsInStorageInfo);
        return inPO;
    }
}
