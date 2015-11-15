package data.logisticdata;

import dataservice.logisticdataservice.ReceivingNoteInputDataService;
import po.ReceivingNotePO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/11/10.
 */
public class ReceivingNoteInputData implements ReceivingNoteInputDataService {
    
    public boolean insert(ReceivingNotePO po) throws RemoteException {
        return false;
    }

    
    public boolean delete(ReceivingNotePO po) throws RemoteException {
        return false;
    }

    
    public boolean update(ReceivingNotePO po) throws RemoteException {
        return false;
    }

    
    public ArrayList<ReceivingNotePO> find(ReceivingNotePO po) throws RemoteException {
        return null;
    }

    
    public ArrayList<ReceivingNotePO> findAll() throws RemoteException {
        return null;
    }
}
