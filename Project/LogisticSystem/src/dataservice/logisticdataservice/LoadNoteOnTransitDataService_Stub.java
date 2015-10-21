package dataservice.logisticdataservice;

import po.LoadNoteOnTransitPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/10/21.
 */
public class LoadNoteOnTransitDataService_Stub implements LoadNoteOnTransitDataService {

    private LoadNoteOnTransitPO po1;
    private LoadNoteOnTransitPO po2;
    private ArrayList<LoadNoteOnTransitPO> pos;


    public LoadNoteOnTransitDataService_Stub() {
        ArrayList<String> codes = new ArrayList<String>();
        codes.add("0000000004");
        codes.add("0000000005");
        ArrayList<String> codes2 = new ArrayList<String>();
        codes2.add("0000000006");
        codes2.add("0000000019");
        codes2.add("0000000020");
        codes2.add("0000000030");
        po1 = new LoadNoteOnTransitPO("2015-10-23","025100120151023000001","北京","苏A 00001",
                "朱梦晴","武昌昊",codes);
        po2 = new LoadNoteOnTransitPO("2015-10-23","025100120151023000001","北京","苏A 00001",
                "李沪东","吴大爷",codes2);
        pos = new ArrayList<LoadNoteOnTransitPO>();
        pos.add(po1);
        pos.add(po2);
    }

    @Override
    public void insert(LoadNoteOnTransitPO po) throws RemoteException {
        System.out.println("insert succeed!");
    }

    @Override
    public void delete(LoadNoteOnTransitPO po) throws RemoteException {
        System.out.println("delete succeed!");
    }

    @Override
    public void update(LoadNoteOnTransitPO po) throws RemoteException {
        System.out.println("update succeed!");
    }

    @Override
    public LoadNoteOnTransitPO findByName(String name) throws RemoteException {
        System.out.println("findByName succeed!");
        return po1;
    }

    @Override
    public ArrayList<LoadNoteOnTransitPO> show() throws RemoteException {
        System.out.println("show succeed!");
        return pos;
    }
}
