package dataservice.commoditydataservice._Stub;

import dataservice.commoditydataservice.StorageInDataService;
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
    public ArrayList<StorageInPO> find(String name) throws RemoteException {
        System.out.println("find succeed!");
        return new ArrayList<StorageInPO>();
    }
}
