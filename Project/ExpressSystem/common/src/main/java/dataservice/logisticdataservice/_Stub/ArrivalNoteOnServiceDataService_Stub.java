package dataservice.logisticdataservice._Stub;


import dataservice.logisticdataservice.ArrivalNoteOnServiceDataService;
import po.ArrivalNoteOnServicePO;
import po.DeliverNoteOnServicePO;
import util.BarcodeAndState;
import util.enums.GoodsState;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/10/20.
 */
public class ArrivalNoteOnServiceDataService_Stub implements ArrivalNoteOnServiceDataService {
	private ArrivalNoteOnServicePO arrivalNoteOnServicePO;
	private ArrivalNoteOnServicePO arrivalNoteOnServicePO2;
	private ArrivalNoteOnServicePO arrivalNoteOnServicePO3;
	private ArrayList<ArrivalNoteOnServicePO> pos;

	public ArrivalNoteOnServiceDataService_Stub() {
		BarcodeAndState bar=new BarcodeAndState("0123456789",GoodsState.COMPLETE);
		ArrayList<BarcodeAndState> BarcodeAndStates=new ArrayList<BarcodeAndState> ();
		BarcodeAndStates.add(bar);
        pos = new ArrayList<ArrivalNoteOnServicePO>();
        arrivalNoteOnServicePO = new ArrivalNoteOnServicePO("2011-11-11","250000201510130000000",
        		"北京",BarcodeAndStates);
        arrivalNoteOnServicePO2 = new ArrivalNoteOnServicePO("2011-11-11","250000201510130000001",
        		"北京",BarcodeAndStates);
        arrivalNoteOnServicePO3 = new ArrivalNoteOnServicePO("2011-11-11","250000201510130000002",
        		"北京",BarcodeAndStates);
		pos.add(arrivalNoteOnServicePO);
		pos.add(this.arrivalNoteOnServicePO2);
		pos.add(arrivalNoteOnServicePO3);
	}


    @Override
    public boolean insertArrivalNote(ArrivalNoteOnServicePO po) throws RemoteException {
        System.out.println("insertArrivalNote success");
        return false;
    }

    @Override
    public boolean deleteArrivalNote(ArrivalNoteOnServicePO po) throws RemoteException {
        System.out.println("deleteArrivalNote success");
        return false;
    }

    @Override
    public boolean updateArrivalNote(ArrivalNoteOnServicePO po) throws RemoteException {
        System.out.println("updateArrivalNote success");
        return false;
    }

    @Override
    public ArrayList<ArrivalNoteOnServicePO> findArrivalNote(ArrivalNoteOnServicePO po) throws RemoteException {
        System.out.println("findArrivalNote success");
        return null;
    }

    @Override
    public ArrayList<ArrivalNoteOnServicePO> findAllArrivalNote() throws RemoteException {
        System.out.println("findAllArrivalNote success");
        return null;
    }

    @Override
    public boolean insertDeliverNote(DeliverNoteOnServicePO po) throws RemoteException {
        System.out.println("insertDeliverNote success");
        return false;
    }

    @Override
    public boolean deleteDeliverNote(DeliverNoteOnServicePO po) throws RemoteException {
        System.out.println("deleteDeliverNote success");
        return false;
    }

    @Override
    public boolean updateDeliverNote(DeliverNoteOnServicePO po) throws RemoteException {
        System.out.println("updateDeliverNote success");
        return false;
    }

    @Override
    public ArrayList<DeliverNoteOnServicePO> findDeliverNote(DeliverNoteOnServicePO po) throws RemoteException {
        System.out.println("findDeliverNote success");
        return null;
    }

    @Override
    public ArrayList<DeliverNoteOnServicePO> findAllDeliverNote() throws RemoteException {
        System.out.println("findAllDeliverNote success");
        return null;
    }
}
