package dataservice.commoditydataservice._Driver;

import dataservice.commoditydataservice.StorageInDataService;
import dataservice.commoditydataservice._Stub.StorageInDataService_Stub;
import po.GoodsPO;
import po.StorageInPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/10/21.
 */
public class StorageInDataService_Driver {

    public static void main(String[] args) throws RemoteException {
        StorageInDataService storageInDataService = new StorageInDataService_Stub();
        StorageInDataService_Driver driver = new StorageInDataService_Driver();
        driver.drive(storageInDataService);
    }

    public void drive(StorageInDataService storageInDataService) throws RemoteException {
        ArrayList<GoodsPO> GoodsInStorageInfo = new  ArrayList<GoodsPO>();
        StorageInPO inPO = new StorageInPO("2015-10-09",GoodsInStorageInfo);
        StorageInPO inPO2 = new StorageInPO("2015-10-09",GoodsInStorageInfo);
        StorageInPO inPO3 = new StorageInPO("2015-10-10",GoodsInStorageInfo);
        storageInDataService.find(inPO);
        storageInDataService.insert(inPO3);
        storageInDataService.delete(inPO2);
        inPO3 = new StorageInPO("2015-10-11",GoodsInStorageInfo);
        storageInDataService.update(inPO3);
    }

}
