package data.statisticdata;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Test;

import util.enums.DocType;
import data.statisticdata.MockObject.MockNote;
import dataservice.exception.ElementNotFoundException;
import dataservice.statisticdataservice.NoteApprovingDataService;

public class NoteApprovingData_Test {
	
	private NoteApprovingDataService service = new NoteApprovingData();
	private MockNote note;
	

	@Test
	public void testGetAllDoc() throws RemoteException {
		assertEquals(null,service.getAllDoc());
	}
	
	public void testGetDocByType() throws RemoteException{
		assertEquals(null,service.getDocByType(DocType.Arrival_Note_On_Service));	
	}
    
	public void testPassDoc() throws RemoteException, ElementNotFoundException{
		assertEquals(true,service.passDoc(note));	
	}
	
	public void testFailDoc() throws RemoteException, ElementNotFoundException{
		assertEquals(false,service.failDoc(note, "不高兴看了"));
	}
}
