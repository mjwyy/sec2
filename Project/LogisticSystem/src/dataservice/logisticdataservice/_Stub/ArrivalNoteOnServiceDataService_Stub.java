package dataservice.logisticdataservice._Stub;


import dataservice.logisticdataservice.ArrivalNoteOnServiceDataService;
import po.ArrivalNoteOnServicePO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by kylin on 15/10/20.
 */
public class ArrivalNoteOnServiceDataService_Stub implements ArrivalNoteOnServiceDataService {
	private ArrivalNoteOnServicePO arrivalNoteOnServicePO;
	private ArrivalNoteOnServicePO arrivalNoteOnServicePO2;
	private ArrivalNoteOnServicePO arrivalNoteOnServicePO3;
	private ArrayList<ArrivalNoteOnServicePO> pos;

	public ArrivalNoteOnServiceDataService_Stub() {
		pos = new ArrayList<ArrivalNoteOnServicePO>();
		Date date = new Date();
		this.arrivalNoteOnServicePO = new ArrivalNoteOnServicePO(date,"250000201510130000000","北京","南京");
		this.arrivalNoteOnServicePO2 = new ArrivalNoteOnServicePO(date,"250000201510130000001","北京","南京");
		this.arrivalNoteOnServicePO3 = new ArrivalNoteOnServicePO(date,"250000201510130000002","北京","南京");
		pos.add(arrivalNoteOnServicePO);
		pos.add(this.arrivalNoteOnServicePO2);
		pos.add(arrivalNoteOnServicePO3);
	}


	@Override
	public void insert(ArrivalNoteOnServicePO po) throws RemoteException {
		System.out.println("insert ArrivalNoteOnServicePO succeed");
	}

	@Override
	public void delete(ArrivalNoteOnServicePO po) throws RemoteException {
		System.out.println("delete ArrivalNoteOnServicePO succeed");
	}

	@Override
	public void update(ArrivalNoteOnServicePO po) throws RemoteException {
		System.out.println("update ArrivalNoteOnServicePO succeed");
	}

	@Override
	public ArrayList<ArrivalNoteOnServicePO> find(String name) throws RemoteException {
		System.out.println("find ArrivalNoteOnServicePO succeed");
		return pos;
	}

	@Override
	public ArrayList<ArrivalNoteOnServicePO> findAll() throws RemoteException {
		System.out.println("findAll ArrivalNoteOnServicePO succeed");
		return pos;
	}

}
