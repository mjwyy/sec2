package dataservice.commoditydataservice._Stub;

import dataservice.commoditydataservice.StorageOutDataService;
import po.StorageOutPO;

import java.rmi.RemoteException;

/**
 * Created by kylin on 15/10/21.
 */
public class StorageOutDataService_Stub implements StorageOutDataService {
    @Override
    public void insert(StorageOutPO po) throws RemoteException {
        System.out.println("insert succeed!");
    }

    @Override
    public void delete(StorageOutPO po) throws RemoteException {
        System.out.println("delete succeed!");
    }

    @Override
    public void update(StorageOutPO po) throws RemoteException {
        System.out.println("update succeed!");
    }

    @Override
    public StorageOutPO find(String name) throws RemoteException {
        StorageOutPO po = new StorageOutPO("2015-10-23","02510012015102300001","上海",
                "铁路","025000201510230000001");
        System.out.println("find succeed!");
        return po;
    }
}
