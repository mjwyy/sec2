package data.statisticdata;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Test;

import data.logisticdata.MockObject.MockArrivalNoteOnService;
import dataservice.exception.ElementNotFoundException;
import dataservice.statisticdataservice.NoteApprovingDataService;

public class NoteApprovingData_Test {
	
	private NoteApprovingDataService service = new NoteApprovingData();
	private MockArrivalNoteOnService arrivalNoteOnService;
	
	

	@Test  
	public void testPassDoc() throws RemoteException, ElementNotFoundException{
		assertEquals(true,service.passDoc(arrivalNoteOnService));	
	}
	
	public void testFailDoc() throws RemoteException, ElementNotFoundException{
		assertEquals(false,service.failDoc(arrivalNoteOnService, "不高兴看了"));
	}
}
