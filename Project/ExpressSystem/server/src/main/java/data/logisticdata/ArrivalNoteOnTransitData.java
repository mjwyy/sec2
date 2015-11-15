package data.logisticdata;

import dataservice.logisticdataservice.ArrivalNoteOnTransitDataService;
import po.ArrivalNoteOnTransitPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/11/10.
 */
public class ArrivalNoteOnTransitData implements ArrivalNoteOnTransitDataService {
     
    public boolean insert(ArrivalNoteOnTransitPO po) throws RemoteException {
        return false;
    }

     
    public boolean delete(ArrivalNoteOnTransitPO po) throws RemoteException {
        return false;
    }

     
    public boolean update(ArrivalNoteOnTransitPO po) throws RemoteException {
        return false;
    }

     
    public ArrayList<ArrivalNoteOnTransitPO> find(ArrivalNoteOnTransitPO po) throws RemoteException {
        return null;
    }

     
    public ArrayList<ArrivalNoteOnTransitPO> findAll() throws RemoteException {
    	ArrayList<ArrivalNoteOnTransitPO> findList = new ArrayList<ArrivalNoteOnTransitPO>();
    	ArrivalNoteOnTransitPO po1 = new ArrivalNoteOnTransitPO("025100201510200000001","025100","2020-11-11","厦门", null);
    	findList.add(po1);
        return findList;
    }
}
