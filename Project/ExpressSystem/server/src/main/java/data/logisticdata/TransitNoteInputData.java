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
    public boolean delete(TransitNotePO po) throws RemoteException {
        return false;
    }

    @Override
    public boolean update(TransitNotePO po) throws RemoteException {
        return false;
    }

    @Override
    public ArrayList<TransitNotePO> find(TransitNotePO po) throws RemoteException {
        return null;
    }

    @Override
    public ArrayList<TransitNotePO> findAll() throws RemoteException {
        return null;
    }
}
