package data.logisticdata;

import dataservice.logisticdataservice.ReceivingNoteInputDataService;
import po.ReceivingNotePO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/11/10.
 */
public class ReceivingNoteInputData implements ReceivingNoteInputDataService {

    @Override
    public boolean insert(ReceivingNotePO po) throws RemoteException {
        return false;
    }

    @Override
    public ArrayList<ReceivingNotePO> find(ReceivingNotePO po) throws RemoteException {
        ReceivingNotePO pox = new ReceivingNotePO(null,null,null);
        ArrayList<ReceivingNotePO> list =  new ArrayList<ReceivingNotePO>();
        list.add(pox);
        return list;
    }

    @Override
    public ArrayList<ReceivingNotePO> findAll() throws RemoteException {
        ReceivingNotePO pox = new ReceivingNotePO(null,null,null);
        ArrayList<ReceivingNotePO> list =  new ArrayList<ReceivingNotePO>();
        list.add(pox);
        return list;
    }
}
