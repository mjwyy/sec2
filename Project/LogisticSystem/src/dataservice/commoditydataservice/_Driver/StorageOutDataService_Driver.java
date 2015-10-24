package dataservice.commoditydataservice._Driver;

import dataservice.commoditydataservice.StorageOutDataService;
import dataservice.commoditydataservice._Stub.StorageOutDataService_Stub;
import po.StorageOutPO;

import java.rmi.RemoteException;

/**
 * Created by kylin on 15/10/21.
 */
public class StorageOutDataService_Driver {

    public static void main(String[] args) throws RemoteException {
        StorageOutDataService storageOutDataService = new StorageOutDataService_Stub();
        StorageOutDataService_Driver driver = new StorageOutDataService_Driver();
        driver.drive(storageOutDataService);
    }

    public void drive(StorageOutDataService storageOutDataService) throws RemoteException {
        StorageOutPO po = new StorageOutPO(null, null, null, null, null, false);
        StorageOutPO po2 = new StorageOutPO(null, null, null, null, null, false);
        storageOutDataService.find(po);
        storageOutDataService.find(po2);
        storageOutDataService.insert(po);
        storageOutDataService.insert(po2);
        po2 = po;
        storageOutDataService.update(po2);
        storageOutDataService.delete(po);
        storageOutDataService.delete(po2);
    }

}
