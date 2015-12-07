package dataservice.statisticdataservice._Stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import po.*;
import util.ApproveNote;
import util.ResultMsg;
import util.enums.DocType;
import dataservice.exception.ElementNotFoundException;
import dataservice.statisticdataservice.NoteApprovingDataService;

/**
 * @author River
 */
public class NoteApprovingDataService_Stub implements NoteApprovingDataService{


	@Override
	public ArrayList<ApproveNote> getNotes() {
		return null;
	}


	@Override
	public ResultMsg pushResults(ArrayList<ApproveNote> results) {
		return null;
	}


   

}
