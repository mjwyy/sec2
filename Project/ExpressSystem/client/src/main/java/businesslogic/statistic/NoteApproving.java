package businesslogic.statistic;

import businesslogicservice.statisticblservice.NoteApprovingBLService;
import connection.RemoteObjectGetter;
import dataservice.exception.ElementNotFoundException;
import dataservice.statisticdataservice.NoteApprovingDataService;
import po.NotePO;
import util.ApproveNote;
import util.ResultMsg;
import util.enums.DocType;
import vo.*;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/11/17.
 */
public class NoteApproving implements NoteApprovingBLService {

    private NoteApprovingDataService dataService;

    public NoteApproving() {
        RemoteObjectGetter getter = new RemoteObjectGetter();
        this.dataService =
                (NoteApprovingDataService)getter.getObjectByName("NoteApprovingDataService");
    }

	@Override
	public ArrayList<ApproveNote> getNotes() {
		
		ArrayList<ApproveNote> result = null;
		
		try {
			result = dataService.getNotes();
		} catch (RemoteException e) {
			
		}
		
		return result;
	}

	@Override
	public ResultMsg pushResults(ArrayList<ApproveNote> results) {
		// TODO Auto-generated method stub
		return null;
	}

   
}
