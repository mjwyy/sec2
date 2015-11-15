package data.logisticdata;

import dataservice.logisticdataservice.LoadNoteOnServiceDataService;
import po.LoadNoteOnServicePO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/11/10.
 */
public class LoadNoteOnServiceData implements LoadNoteOnServiceDataService {
    
    public boolean insert(LoadNoteOnServicePO po) throws RemoteException {
        return false;
    }

    
    public boolean delete(LoadNoteOnServicePO po) throws RemoteException {
        return false;
    }

    
    public boolean update(LoadNoteOnServicePO po) throws RemoteException {
        return false;
    }

    
    public ArrayList<LoadNoteOnServicePO> find(LoadNoteOnServicePO po) throws RemoteException {
        return null;
    }

    
    public ArrayList<LoadNoteOnServicePO> findAll() throws RemoteException {
        return null;
    }
}
