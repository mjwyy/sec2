package dataservice.logisticdataservice._Stub;


import dataservice.logisticdataservice.ArrivalNoteOnServiceDataService;
import po.ArrivalNoteOnServicePO;
import po.DeliverNoteOnServicePO;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.util.BarcodeAndState;
import businesslogic.util.GoodsState;

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
	public boolean insert(ArrivalNoteOnServicePO po) throws RemoteException {
		System.out.println("insert ArrivalNoteOnServicePO succeed");
return true;
	}

	@Override
	public boolean delete(ArrivalNoteOnServicePO po) throws RemoteException {
		System.out.println("delete ArrivalNoteOnServicePO succeed");
		return true;
	}

	@Override
	public boolean update(ArrivalNoteOnServicePO po) throws RemoteException {
		System.out.println("update ArrivalNoteOnServicePO succeed");
		return true;
	}

	@Override
	public ArrayList<ArrivalNoteOnServicePO> find(ArrivalNoteOnServicePO po) throws RemoteException {
		System.out.println("find ArrivalNoteOnServicePO succeed");
		return pos;
	}

	@Override
	public ArrayList<ArrivalNoteOnServicePO> findAll() throws RemoteException {
		System.out.println("findAll ArrivalNoteOnServicePO succeed");
		return pos;
	}


	@Override
	public boolean insert(DeliverNoteOnServicePO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean delete(DeliverNoteOnServicePO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean update(DeliverNoteOnServicePO po) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public ArrayList<DeliverNoteOnServicePO> find(DeliverNoteOnServicePO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
