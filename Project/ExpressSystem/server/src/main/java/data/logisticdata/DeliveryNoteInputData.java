package data.logisticdata;

import dataservice.logisticdataservice.DeliveryNoteInputDataService;
import po.DeliveryNotePO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/11/10.
 */
public class DeliveryNoteInputData implements DeliveryNoteInputDataService {
     

     
    public boolean delete(DeliveryNotePO po) throws RemoteException {
        return false;
    }

     
    public boolean update(DeliveryNotePO po) throws RemoteException {
        return false;
    }

     
    public ArrayList<DeliveryNotePO> find(DeliveryNotePO po) throws RemoteException {
        return null;
    }

     
    public ArrayList<DeliveryNotePO> findAll() throws RemoteException {
        return null;
    }

}
