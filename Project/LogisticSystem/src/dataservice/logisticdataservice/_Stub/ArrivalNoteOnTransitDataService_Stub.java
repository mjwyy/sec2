package dataservice.logisticdataservice._Stub;

import dataservice.logisticdataservice.ArrivalNoteOnTransitDataService;
import po.ArrivalNoteOnTransitPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.util.BarcodeAndState;
import businesslogic.util.GoodsState;

/**
 * Created by kylin on 15/10/21.
 */
public class ArrivalNoteOnTransitDataService_Stub implements ArrivalNoteOnTransitDataService {

    private ArrivalNoteOnTransitPO po1;
    private ArrivalNoteOnTransitPO po2;
    private ArrayList<ArrivalNoteOnTransitPO> pos;

    public ArrivalNoteOnTransitDataService_Stub() {
    	BarcodeAndState bar=new BarcodeAndState("0123456789",GoodsState.COMPLETE);
		ArrayList<BarcodeAndState> BarcodeAndStates=new ArrayList<BarcodeAndState> ();
		BarcodeAndStates.add(bar);
        po1 = new ArrivalNoteOnTransitPO("2011-11-11","025100","025100201510200000001","北京",BarcodeAndStates);
        po2 = new ArrivalNoteOnTransitPO("2011-11-11","025100","025100201510200000002","上海",BarcodeAndStates);
        pos = new ArrayList<ArrivalNoteOnTransitPO>();
        pos.add(po1);
        pos.add(po2);
    }

    @Override
    public boolean insert(ArrivalNoteOnTransitPO po) throws RemoteException {
        System.out.println("insert succeed!");
		return true;
    }

    @Override
    public boolean delete(ArrivalNoteOnTransitPO po) throws RemoteException {
        System.out.println("delete succeed!");
		return true;
    }

    @Override
    public boolean update(ArrivalNoteOnTransitPO po) throws RemoteException {
        System.out.println("update succeed!");
		return true;
    }

    @Override
    public ArrayList<ArrivalNoteOnTransitPO> find(ArrivalNoteOnTransitPO po) throws RemoteException {
        System.out.println("find succeed!");
        return pos;
    }

    @Override
    public ArrayList<ArrivalNoteOnTransitPO> findAll() throws RemoteException {
        System.out.println("findAll succeed!");
        return pos;
    }
}
