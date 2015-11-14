package data.logisticdata;

import dataservice.logisticdataservice.ArrivalNoteOnServiceDataService;
import po.ArrivalNoteOnServicePO;
import po.DeliverNoteOnServicePO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/11/10.
 */
public class ArrivalNoteOnServiceData implements ArrivalNoteOnServiceDataService {
    @Override
    public boolean insert(ArrivalNoteOnServicePO po) throws RemoteException {
        return false;
    }

    @Override
    public boolean delete(ArrivalNoteOnServicePO po) throws RemoteException {
        return false;
    }

    @Override
    public boolean update(ArrivalNoteOnServicePO po) throws RemoteException {
        return false;
    }

    @Override
    public ArrayList<ArrivalNoteOnServicePO> find(ArrivalNoteOnServicePO po) throws RemoteException {
        return null;
    }

    @Override
    public ArrayList<ArrivalNoteOnServicePO> findAll() throws RemoteException {
        return null;
    }

    @Override
    public boolean insert(DeliverNoteOnServicePO po) throws RemoteException {
        return false;
    }

    @Override
    public boolean delete(DeliverNoteOnServicePO po) throws RemoteException {
        return false;
    }

    @Override
    public boolean update(DeliverNoteOnServicePO po) throws RemoteException {
        return false;
    }

    @Override
    public ArrayList<DeliverNoteOnServicePO> find(DeliverNoteOnServicePO po) throws RemoteException {
        return null;
    }
}
