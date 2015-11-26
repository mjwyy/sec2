package data.commoditydata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.StorageOutPO;
import dataservice.commoditydataservice.StorageOutDataService;

/**
 * 
 * @author River
 * database:
 * id(varchar(32)),date(varchar(32)),destination(varchar(64)),transportType(varchar(16)),
 * code(varchar(32)),isTransfer(INT(11)),isPassed(INT(11))
 */

public class StorageOutData implements StorageOutDataService {

    @Override
    public boolean insert(StorageOutPO po,String staffID) throws RemoteException {
        return false;
    }


}
