package data.logisticdata;

import dataservice.logisticdataservice.ArrivalNoteOnServiceDataService;
import po.ArrivalNoteOnServicePO;
import po.DeliverNoteOnServicePO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/11/10.
 */
public class ArrivalNoteOnServiceData implements ArrivalNoteOnServiceDataService {

	@Override
	public boolean insertArrivalNote(ArrivalNoteOnServicePO po) throws RemoteException {
		return false;
	}

	@Override
	public boolean deleteArrivalNote(ArrivalNoteOnServicePO po) throws RemoteException {
		return false;
	}

	@Override
	public boolean updateArrivalNote(ArrivalNoteOnServicePO po) throws RemoteException {
		return false;
	}

	@Override
	public ArrayList<ArrivalNoteOnServicePO> findArrivalNote(ArrivalNoteOnServicePO po) throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<ArrivalNoteOnServicePO> findAllArrivalNote() throws RemoteException {
		return null;
	}

	@Override
	public boolean insertDeliverNote(DeliverNoteOnServicePO po) throws RemoteException {
		return false;
	}

	@Override
	public boolean deleteDeliverNote(DeliverNoteOnServicePO po) throws RemoteException {
		return false;
	}

	@Override
	public boolean updateDeliverNote(DeliverNoteOnServicePO po) throws RemoteException {
		return false;
	}

	@Override
	public ArrayList<DeliverNoteOnServicePO> findDeliverNote(DeliverNoteOnServicePO po) throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<ArrivalNoteOnServicePO> findAllDeliverNote() throws RemoteException {
		return null;
	}
}
