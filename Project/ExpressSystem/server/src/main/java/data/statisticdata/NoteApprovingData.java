package data.statisticdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import data.database.SqlHelper;
import dataservice.logisticdataservice.*;
import po.*;
import util.ApproveNote;
import util.ResultMsg;
import dataservice.exception.ElementNotFoundException;
import dataservice.statisticdataservice.NoteApprovingDataService;

/**
 * @author wwz
 * @date 2015/11/14
 *
 */
public class NoteApprovingData extends UnicastRemoteObject implements NoteApprovingDataService {


	private static final long serialVersionUID = 110929119545388322L;


    private HashMap<String, String> nameAndTableName;
    private HashMap<String, String> nameAndTableID;

    public NoteApprovingData() throws RemoteException {
        
    }

	@Override
	public ArrayList<ApproveNote> getNotes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMsg pushResults(ArrayList<ApproveNote> results) {
		// TODO Auto-generated method stub
		return null;
	}



}
