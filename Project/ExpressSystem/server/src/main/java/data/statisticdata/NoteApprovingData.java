package data.statisticdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.NotePO;
import util.enums.DocType;
import dataservice.exception.ElementNotFoundException;
import dataservice.statisticdataservice.NoteApprovingDataService;

/**
 * @author wwz
 * @date 2015/11/14
 *
 */
public class NoteApprovingData implements NoteApprovingDataService {
	

	@Override
	public ArrayList<NotePO> getAllDoc() throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<NotePO> getDocByType(DocType type) throws RemoteException {
		return null;
	}

	@Override
	public boolean passDoc(NotePO docPO) throws RemoteException,
			ElementNotFoundException {
		return true;
	}

	@Override
	public boolean failDoc(NotePO docPO, String comment)
			throws RemoteException, ElementNotFoundException {
		return false;
	}
	

}
