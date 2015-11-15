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

	public boolean delete(ArrivalNoteOnServicePO arg0) throws RemoteException {
		return false;
	}

	public boolean delete(DeliverNoteOnServicePO arg0) throws RemoteException {
		return false;
	}

	public ArrayList<ArrivalNoteOnServicePO> find(ArrivalNoteOnServicePO arg0) throws RemoteException {
		return null;
	}

	public ArrayList<DeliverNoteOnServicePO> find(DeliverNoteOnServicePO arg0) throws RemoteException {
		return null;
	}

	public ArrayList<ArrivalNoteOnServicePO> findAll() throws RemoteException {
		return null;
	}

	public boolean insert(ArrivalNoteOnServicePO arg0) throws RemoteException {
		return false;
	}

	public boolean insert(DeliverNoteOnServicePO arg0) throws RemoteException {
		return false;
	}

	public boolean update(ArrivalNoteOnServicePO arg0) throws RemoteException {
		return false;
	}

	public boolean update(DeliverNoteOnServicePO arg0) throws RemoteException {
		return false;
	}
}
