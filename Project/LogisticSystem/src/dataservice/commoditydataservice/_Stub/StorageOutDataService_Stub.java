package dataservice.commoditydataservice._Stub;

import dataservice.commoditydataservice.StorageOutDataService;
import po.StorageInPO;
import po.StorageOutPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/10/21.
 */
public class StorageOutDataService_Stub implements StorageOutDataService {
    @Override
    public boolean insert(StorageOutPO po) throws RemoteException {
        System.out.println("insert succeed!");
        return true;
    }

    @Override
    public boolean delete(StorageOutPO po) throws RemoteException {
        System.out.println("delete succeed!");
		return true;
    }

    @Override
    public boolean update(StorageOutPO po) throws RemoteException {
        System.out.println("update succeed!");
        return true;
    }

    @Override
    public ArrayList<StorageOutPO> find(StorageOutPO po) throws RemoteException {
        ArrayList<StorageOutPO> pos = new ArrayList<StorageOutPO>();
        StorageOutPO po1 = new StorageOutPO("2015-10-23","02510012015102300001","上海",
                "铁路","025000201510230000001",true);
        System.out.println("find succeed!");
        pos.add(po1);
        return pos;
    }
}
