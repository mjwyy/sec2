package data.statisticdata;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import data.database.DatabaseFactory;
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

    @Test
    public void testArrivalOnServiceDoc() throws RemoteException, ElementNotFoundException, SQLException {
        ArrivalNoteOnServicePO po1 = new ArrivalNoteOnServicePO(null, false,
                "025001201511260001", null, null);
        service.passDoc(po1);

        ArrivalNoteOnTransitPO po2 = new ArrivalNoteOnTransitPO(
                "025001201511260002", "025100", "2011-11-11", "北京", null);
        service.failDoc(po2, "不高兴1");
    }

    @Test
    public void testArrivalOnTransitDoc() throws RemoteException, ElementNotFoundException, SQLException {
        ArrivalNoteOnTransitPO po1 = new ArrivalNoteOnTransitPO(
                "025001201511260001", "025100", "2011-11-11", "北京", null);
        service.passDoc(po1);

        ArrivalNoteOnTransitPO po2 = new ArrivalNoteOnTransitPO(
                "025001201511260002", "025100", "2011-11-11", "北京", null);
        service.failDoc(po2, "不高兴2");
    }

    @Test
    public void testDeliveryDoc() throws RemoteException, ElementNotFoundException, SQLException {
        ArrivalNoteOnTransitPO po1 = new ArrivalNoteOnTransitPO(
                "025001201511260001", "025100", "2011-11-11", "北京", null);
        service.passDoc(po1);

        ArrivalNoteOnTransitPO po2 = new ArrivalNoteOnTransitPO(
                "025001201511260002", "025100", "2011-11-11", "北京", null);
        service.failDoc(po2, "不高兴2");
    }

    @Test
    public void testLoadOnServiceDoc() throws RemoteException, ElementNotFoundException, SQLException {
        ArrivalNoteOnTransitPO po1 = new ArrivalNoteOnTransitPO(
                "025001201511260001", "025100", "2011-11-11", "北京", null);
        service.passDoc(po1);

        ArrivalNoteOnTransitPO po2 = new ArrivalNoteOnTransitPO(
                "025001201511260002", "025100", "2011-11-11", "北京", null);
        service.failDoc(po2, "不高兴2");
    }

    @Test
    public void testLoadOnTransitDoc() throws RemoteException, ElementNotFoundException, SQLException {
        ArrivalNoteOnTransitPO po1 = new ArrivalNoteOnTransitPO(
                "025001201511260001", "025100", "2011-11-11", "北京", null);
        service.passDoc(po1);

        ArrivalNoteOnTransitPO po2 = new ArrivalNoteOnTransitPO(
                "025001201511260002", "025100", "2011-11-11", "北京", null);
        service.failDoc(po2, "不高兴2");
    }

    @Test
    public void testReceivingDoc() throws RemoteException, ElementNotFoundException, SQLException {
        ArrivalNoteOnTransitPO po1 = new ArrivalNoteOnTransitPO(
                "025001201511260001", "025100", "2011-11-11", "北京", null);
        service.passDoc(po1);

        ArrivalNoteOnTransitPO po2 = new ArrivalNoteOnTransitPO(
                "025001201511260002", "025100", "2011-11-11", "北京", null);
        service.failDoc(po2, "不高兴2");
    }

    @Test
    public void testTransitDoc() throws RemoteException, ElementNotFoundException, SQLException {
        ArrivalNoteOnTransitPO po1 = new ArrivalNoteOnTransitPO(
                "025001201511260001", "025100", "2011-11-11", "北京", null);
        service.passDoc(po1);

        ArrivalNoteOnTransitPO po2 = new ArrivalNoteOnTransitPO(
                "025001201511260002", "025100", "2011-11-11", "北京", null);
        service.failDoc(po2, "不高兴2");
    }

}
