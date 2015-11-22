package data.logisticdata;

import dataservice.logisticdataservice.DeliveryNoteInputDataService;
import po.DeliveryNotePO;
import po.OrderPO;
import util.PresumedMsg;
import util.sendDocMsg;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/11/10.
 */
public class DeliveryNoteInputData implements DeliveryNoteInputDataService {


    @Override
    public sendDocMsg insert(DeliveryNotePO po) throws RemoteException {
        return null;
    }

    @Override
    public PresumedMsg insertOrderPO(OrderPO po) throws RemoteException {
        return null;
    }

    @Override
    public boolean delete(DeliveryNotePO po) throws RemoteException {
        return false;
    }

    @Override
    public boolean update(DeliveryNotePO po) throws RemoteException {
        return false;
    }

    @Override
    public ArrayList<DeliveryNotePO> find(DeliveryNotePO po) throws RemoteException {
        DeliveryNotePO pox = new DeliveryNotePO(null,null,null,null,null,null,null,0,0,0,null,0,null);
        ArrayList<DeliveryNotePO> list =  new ArrayList<DeliveryNotePO>();
        list.add(pox);
        return list;
    }

    @Override
    public ArrayList<DeliveryNotePO> findAll() throws RemoteException {
        DeliveryNotePO pox = new DeliveryNotePO(null,null,null,null,null,null,null,0,0,0,null,0,null);
        ArrayList<DeliveryNotePO> list =  new ArrayList<DeliveryNotePO>();
        list.add(pox);
        return list;
    }
}
