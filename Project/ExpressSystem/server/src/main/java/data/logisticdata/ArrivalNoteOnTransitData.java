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
    public ArrayList<ArrivalNoteOnTransitPO> find(ArrivalNoteOnTransitPO po) throws RemoteException {
        ArrivalNoteOnTransitPO pox = new ArrivalNoteOnTransitPO();
        ArrayList<ArrivalNoteOnTransitPO> list =  new ArrayList<ArrivalNoteOnTransitPO>();
        list.add(pox);
        return list;
    }

    @Override
    public ArrayList<ArrivalNoteOnTransitPO> findAll() throws RemoteException {
        ArrivalNoteOnTransitPO pox = new ArrivalNoteOnTransitPO();
        ArrayList<ArrivalNoteOnTransitPO> list =  new ArrayList<ArrivalNoteOnTransitPO>();
        list.add(pox);
        return list;
    }
}
