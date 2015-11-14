package data.logisticdata;

import dataservice.logisticdataservice.LoadNoteOnTransitDataService;
import po.LoadNoteOnTransitPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/11/10.
 */
public class LoadNoteOnTransitData implements LoadNoteOnTransitDataService {
    @Override
    public boolean insert(LoadNoteOnTransitPO po) throws RemoteException {
        return false;
    }

    @Override
    public boolean delete(LoadNoteOnTransitPO po) throws RemoteException {
        return false;
    }

    @Override
    public boolean update(LoadNoteOnTransitPO po) throws RemoteException {
        return false;
    }

    @Override
    public ArrayList<LoadNoteOnTransitPO> find(LoadNoteOnTransitPO po) throws RemoteException {
        return null;
    }

    @Override
    public ArrayList<LoadNoteOnTransitPO> findAll() throws RemoteException {
        return null;
    }
}
