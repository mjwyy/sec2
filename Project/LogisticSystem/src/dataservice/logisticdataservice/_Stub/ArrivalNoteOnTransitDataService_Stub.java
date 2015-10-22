package dataservice.logisticdataservice._Stub;

import dataservice.logisticdataservice.ArrivalNoteOnTransitDataService;
import po.ArrivalNoteOnTransitPO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by kylin on 15/10/21.
 */
public class ArrivalNoteOnTransitDataService_Stub implements ArrivalNoteOnTransitDataService {

    private ArrivalNoteOnTransitPO po1;
    private ArrivalNoteOnTransitPO po2;
    private ArrayList<ArrivalNoteOnTransitPO> pos;

    public ArrivalNoteOnTransitDataService_Stub() {
        Date date = new Date();
        po1 = new ArrivalNoteOnTransitPO(date,"025100","025100201510200000001","北京","完整");
        po2 = new ArrivalNoteOnTransitPO(date,"025100","025100201510200000002","上海","完整");
        pos = new ArrayList<ArrivalNoteOnTransitPO>();
        pos.add(po1);
        pos.add(po2);
    }

    @Override
    public void insert(ArrivalNoteOnTransitPO po) throws RemoteException {
        System.out.println("insert succeed!");
    }

    @Override
    public void delete(ArrivalNoteOnTransitPO po) throws RemoteException {
        System.out.println("delete succeed!");
    }

    @Override
    public void update(ArrivalNoteOnTransitPO po) throws RemoteException {
        System.out.println("update succeed!");
    }

    @Override
    public ArrayList<ArrivalNoteOnTransitPO> find(String name) throws RemoteException {
        System.out.println("find succeed!");
        return pos;
    }

    @Override
    public ArrayList<ArrivalNoteOnTransitPO> findAll() throws RemoteException {
        System.out.println("findAll succeed!");
        return pos;
    }
}
