package dataservice.commoditydataservice._Driver;

import dataservice.commoditydataservice.StorageOutDataService;
import dataservice.commoditydataservice._Stub.StorageOutDataService_Stub;
import po.StorageOutPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

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
        StorageOutPO po = new StorageOutPO("2015-10-23","02510012015102300001","上海",
                "铁路","025000201510230000001",true);
        StorageOutPO po2 = new StorageOutPO("2015-10-24","02510012015102300002","上海",
                "铁路","025000201510230000002",false);
        storageOutDataService.find("2015-10-22");
        storageOutDataService.find("南京");
        storageOutDataService.insert(po);
        storageOutDataService.insert(po2);
        po2 = po;
        storageOutDataService.update(po2);
        storageOutDataService.delete(po);
        storageOutDataService.delete(po2);
    }

}
