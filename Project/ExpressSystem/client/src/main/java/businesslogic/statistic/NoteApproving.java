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

    private ArrayList<ApproveNote> tempStorage = null;
    
    public NoteApproving() {
        RemoteObjectGetter getter = new RemoteObjectGetter();
        this.dataService =
                (NoteApprovingDataService)getter.getObjectByName("NoteApprovingDataService");
    }

	@Override
	public ArrayList<ApproveNote> getNotes() throws Exception{
		
		ArrayList<ApproveNote> result = null;
		
		try {
			result = dataService.getNotes();
			tempStorage = result;
		} catch (RemoteException e) {
			throw e;
		}
		
		return result;
	}

	@Override
	public ResultMsg pushResults(ArrayList<ApproveNote> results) throws Exception {
		assert results!=null;
		
		if(tempStorage==null) {
			return new ResultMsg(false, "尚未获取过待审批单据！");
		}

		for(ApproveNote note:results) {
			if( !note.isPass() && note.getRejectionMessage()==null ) {
				return new ResultMsg(false, note.getType()+":"+note.getInfo()+"未填写审批意见！");
			}
		}
		
		ResultMsg msg = new ResultMsg(true);
		
		try {
			msg = dataService.pushResults(results);
		} catch (RemoteException e) {
			throw e;
		}
		
		return msg;
	}

   
}
