package data.logisticdata;

import dataservice.logisticdataservice.TransitNoteInputDataService;
import po.TransitNotePO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/11/10.
 */
public class TransitNoteInputData implements TransitNoteInputDataService {

    @Override
    public boolean insert(TransitNotePO po) throws RemoteException {
        return false;
    }

    @Override
    public ArrayList<TransitNotePO> find(TransitNotePO po) throws RemoteException {
        TransitNotePO pox = new TransitNotePO(null,null,null,null,null,null,null,null);
        ArrayList<TransitNotePO> list =  new ArrayList<TransitNotePO>();
        list.add(pox);
        return list;
    }

    @Override
    public ArrayList<TransitNotePO> findAll() throws RemoteException {
        return null;
    }
}
