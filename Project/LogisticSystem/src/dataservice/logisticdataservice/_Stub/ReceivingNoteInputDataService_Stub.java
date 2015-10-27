package dataservice.logisticdataservice._Stub;

import dataservice.logisticdataservice.ReceivingNoteInputDataService;
import po.ReceivingNotePO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/10/21.
 */
public class ReceivingNoteInputDataService_Stub implements ReceivingNoteInputDataService {

    private ReceivingNotePO po1;
    private ReceivingNotePO po2;
    private ReceivingNotePO po3;
    private ArrayList<ReceivingNotePO> pos;

    public ReceivingNoteInputDataService_Stub() {
        pos = new ArrayList<ReceivingNotePO>();
        po1 = new ReceivingNotePO("0123456789","旭爷","2015-10-23 14:00");
        po1 = new ReceivingNotePO("0123456790","汪同学","2015-10-23 14:00");
        po3 = new ReceivingNotePO("0123456791","狗狗","2015-10-26 9:00");
        pos.add(po1);
        pos.add(po2);
        pos.add(po3);
    }

    @Override
    public boolean insert(ReceivingNotePO po) throws RemoteException {
        System.out.println("insert succeed!");
        return true;
    }

    @Override
    public boolean delete(ReceivingNotePO po) throws RemoteException {
        System.out.println("delete succeed!");
        return true;
    }

    @Override
    public boolean update(ReceivingNotePO po) throws RemoteException {
        System.out.println("update succeed!");
        return true;
    }

    @Override
    public ArrayList<ReceivingNotePO> find(ReceivingNotePO po) throws RemoteException {
        System.out.println("find succeed!");
        return pos;
    }

    @Override
    public ArrayList<ReceivingNotePO> findAll() throws RemoteException {
        System.out.println("find all succeed!");
        return pos;
    }
}
