package dataservice.logisticdataservice;

import po.ReceivingNoteInputPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/10/21.
 */
public class ReceivingNoteInputDataService_Stub implements ReceivingNoteInputDataService {

    private ReceivingNoteInputPO po1;
    private ReceivingNoteInputPO po2;
    private ReceivingNoteInputPO po3;
    private ArrayList<ReceivingNoteInputPO> pos;

    public ReceivingNoteInputDataService_Stub() {
        pos = new ArrayList<ReceivingNoteInputPO>();
        po1 = new ReceivingNoteInputPO("0123456789","旭爷","2015-10-23 14:00");
        po1 = new ReceivingNoteInputPO("0123456790","汪同学","2015-10-23 14:00");
        po3 = new ReceivingNoteInputPO("0123456791","狗狗","2015-10-26 9:00");
        pos.add(po1);
        pos.add(po2);
        pos.add(po3);
    }

    @Override
    public void insert(ReceivingNoteInputPO po) throws RemoteException {
        System.out.println("insert succeed!");
    }

    @Override
    public void delete(ReceivingNoteInputPO po) throws RemoteException {
        System.out.println("delete succeed!");
    }

    @Override
    public void update(ReceivingNoteInputPO po) throws RemoteException {
        System.out.println("update succeed!");
    }

    @Override
    public ReceivingNoteInputPO findByName(String name) throws RemoteException {
        System.out.println("findByName succeed!");
        return po1;
    }

    @Override
    public ArrayList<ReceivingNoteInputPO> show() throws RemoteException {
        System.out.println("show succeed!");
        return pos;
    }
}
