package data.logisticdata;

import dataservice.logisticdataservice.LoadNoteOnTransitDataService;
import po.LoadNoteOnTransitPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/11/10.
 */
public class LoadNoteOnTransitData implements LoadNoteOnTransitDataService {
    
    public boolean insert(LoadNoteOnTransitPO po) throws RemoteException {
        return false;
    }

    
    public boolean delete(LoadNoteOnTransitPO po) throws RemoteException {
        return false;
    }

    
    public boolean update(LoadNoteOnTransitPO po) throws RemoteException {
        return false;
    }

    
    public ArrayList<LoadNoteOnTransitPO> find(LoadNoteOnTransitPO po) throws RemoteException {
        return null;
    }

    
    public ArrayList<LoadNoteOnTransitPO> findAll() throws RemoteException {
        return null;
    }
}
