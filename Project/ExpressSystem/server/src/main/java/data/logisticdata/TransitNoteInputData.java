package data.logisticdata;

import dataservice.logisticdataservice.TransitNoteInputDataService;
import po.TransitNotePO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/11/10.
 */
public class TransitNoteInputData implements TransitNoteInputDataService {
    
    public boolean insert(TransitNotePO po) throws RemoteException {
        return false;
    }

    
    public boolean delete(TransitNotePO po) throws RemoteException {
        return false;
    }

    
    public boolean update(TransitNotePO po) throws RemoteException {
        return false;
    }

    
    public ArrayList<TransitNotePO> find(TransitNotePO po) throws RemoteException {
        return null;
    }

    
    public ArrayList<TransitNotePO> findAll() throws RemoteException {
        return null;
    }
}
