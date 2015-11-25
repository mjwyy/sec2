package data.statisticdata;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import data.logisticdata.MockObject.MockArrivalNoteOnTransit;
import org.junit.Test;

import data.logisticdata.MockObject.MockArrivalNoteOnService;
import dataservice.exception.ElementNotFoundException;
import dataservice.statisticdataservice.NoteApprovingDataService;
import po.ArrivalNoteOnServicePO;
import po.ArrivalNoteOnTransitPO;
import po.NotePO;
import util.BarcodeAndState;
import util.enums.GoodsState;

public class NoteApprovingData_Test {
	
	private NoteApprovingDataService service = new NoteApprovingData();

    //	@Test
    public void testPassDoc() throws RemoteException, ElementNotFoundException, SQLException {
//        ArrivalNoteOnServicePO arrivalNoteOnServicePO = new ArrivalNoteOnServicePO(null, false,
//                "250001201512120002", null, null);
//        service.passDoc(arrivalNoteOnServicePO);

        ArrivalNoteOnTransitPO mock = new ArrivalNoteOnTransitPO(
                "666666", "025100", "2011-11-11", "北京", null);
        service.passDoc(mock);
    }

    @Test
    public void testFailDoc() throws RemoteException, ElementNotFoundException, SQLException {
        ArrivalNoteOnTransitPO mock = new ArrivalNoteOnTransitPO(
                "88888", "025100", "2011-11-11", "北京", null);
        service.passDoc(mock);
        service.failDoc(mock, "不高兴88888");
    }
}
