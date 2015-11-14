package data.logisticdata;

import dataservice.logisticdataservice.ArrivalNoteOnTransitDataService;
import po.ArrivalNoteOnTransitPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/11/10.
 */
public class ArrivalNoteOnTransitData implements ArrivalNoteOnTransitDataService {
    @Override
    public boolean insert(ArrivalNoteOnTransitPO po) throws RemoteException {
        return false;
    }

    @Override
    public boolean delete(ArrivalNoteOnTransitPO po) throws RemoteException {
        return false;
    }

    @Override
    public boolean update(ArrivalNoteOnTransitPO po) throws RemoteException {
        return false;
    }

    @Override
    public ArrayList<ArrivalNoteOnTransitPO> find(ArrivalNoteOnTransitPO po) throws RemoteException {
        return null;
    }

    @Override
    public ArrayList<ArrivalNoteOnTransitPO> findAll() throws RemoteException {
        return null;
    }
}
