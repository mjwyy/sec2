package data.logisticdata;

import data.logisticdata.MockObject.MockArrivalNoteOnService;
import data.logisticdata.MockObject.MockDeliverNoteOnService;
import dataservice.logisticdataservice.ArrivalNoteOnServiceDataService;
import dataservice.logisticdataservice.ArrivalNoteOnTransitDataService;
import org.junit.Test;
import po.ArrivalNoteOnServicePO;
import po.DeliverNoteOnServicePO;

import java.rmi.RemoteException;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by kylin on 15/11/10.
 */
public class ArrivalNoteOnService_Test {

    private ArrivalNoteOnServiceDataService service = new ArrivalNoteOnServiceData();

    @Test
    public void testInsertArrivalNote() throws RemoteException {
        MockArrivalNoteOnService mock1 = new MockArrivalNoteOnService("2015-11-11",
                "250000201510130000000", "北京");
        MockArrivalNoteOnService mock2 = new MockArrivalNoteOnService("2015-11-11",
                "250000201510130000001", "北京");
        //assertEquals(true,service.insertArrivalNote(mock1));
        //assertEquals(true,service.insertArrivalNote(mock2));
    }

    @Test
    public void testDeleteArrivalNote() throws RemoteException {
        MockArrivalNoteOnService mock1 = new MockArrivalNoteOnService("2015-11-11",
                "250000201510130000002", "北京");
        MockArrivalNoteOnService mock2 = new MockArrivalNoteOnService("2015-11-11",
                "250000201510130000003", "北京");
        service.insertArrivalNote(mock1);
        service.insertArrivalNote(mock2);
        //assertEquals(true,service.deleteArrivalNote(mock1));
        //assertEquals(false,service.deleteArrivalNote(mock1));
        //assertEquals(true,service.deleteArrivalNote(mock2));
    }

    @Test
    public void testUpdateArrivalNote() throws RemoteException {
        MockArrivalNoteOnService mock1 = new MockArrivalNoteOnService("2015-11-11",
                "250000201510130000004", "北京");
        service.insertArrivalNote(mock1);
        mock1 = new MockArrivalNoteOnService("2016-12-12",
                "250000201510130000099", "北京");
        //assertEquals(true,service.updateArrivalNote(mock1));
    }

    @Test
    public void testFindArrivalNote() throws RemoteException {
        MockArrivalNoteOnService mock1 = new MockArrivalNoteOnService("2015-11-11",
                "250000201510130000005", "北京");
        service.insertArrivalNote(mock1);
        ArrivalNoteOnServicePO toFind = new ArrivalNoteOnServicePO(null,"250000201510130000005",null,null);
        ArrayList<ArrivalNoteOnServicePO> list = service.findArrivalNote(toFind);
        ArrivalNoteOnServicePO found = list.get(0);
        //assertEquals(1,list.size());
        //assertEquals("2015-11-11",found.getDate());
        //assertEquals("北京",found.getFrom());
    }

    @Test
    public void testFindAllArrivalNote() throws RemoteException {
        MockArrivalNoteOnService mock1 = new MockArrivalNoteOnService("2015-11-12",
                "250000201510130000006", "北京");
        MockArrivalNoteOnService mock2 = new MockArrivalNoteOnService("2015-11-13",
                "250000201510130000007", "北京");
        service.insertArrivalNote(mock1);
        service.insertArrivalNote(mock2);
        //assertEquals(true,service.findAllArrivalNote().size()>=2);
    }

    @Test
    public void testInsertDeliverNote() throws RemoteException {
        MockDeliverNoteOnService mock1 = new MockDeliverNoteOnService("2015-11-16","王小二");
        MockDeliverNoteOnService mock2 = new MockDeliverNoteOnService("2015-11-17","王小三");
        //assertEquals(true,service.insertDeliverNote(mock1));
        //assertEquals(true,service.insertDeliverNote(mock2));
    }

    @Test
    public void testDeleteDeliverNote() throws RemoteException {
        MockDeliverNoteOnService mock1 = new MockDeliverNoteOnService("2015-11-18","王小四");
        MockDeliverNoteOnService mock2 = new MockDeliverNoteOnService("2015-11-19","王小五");
        service.insertDeliverNote(mock1);
        service.insertDeliverNote(mock2);
        //assertEquals(true,service.deleteDeliverNote(mock1));
        //assertEquals(false,service.deleteDeliverNote(mock1));
        //assertEquals(true,service.deleteDeliverNote(mock2));
    }

    @Test
    public void testUpdateDeliverNote() throws RemoteException {
        MockDeliverNoteOnService mock1 = new MockDeliverNoteOnService("2015-11-16","王小六");
        service.insertDeliverNote(mock1);
        mock1 = new MockDeliverNoteOnService("2015-11-16","端木雪莹");
        //assertEquals(true,service.updateDeliverNote(mock1));
    }

    @Test
    public void testFindDeliverNote() throws RemoteException {
        MockDeliverNoteOnService toFind = new MockDeliverNoteOnService("2015-11-17","王小六");
        service.insertDeliverNote(toFind);
        ArrayList<DeliverNoteOnServicePO> list = service.findDeliverNote(toFind);
        DeliverNoteOnServicePO found = list.get(0);
        //assertEquals(1,list.size());
        //assertEquals("2015-11-17",found.getDate());
        //assertEquals("王小六",found.getDeliveryMan());
    }

    @Test
    public void testFindAllDeliverNote() throws RemoteException {
        MockDeliverNoteOnService mock1 = new MockDeliverNoteOnService("2015-11-18","王小四");
        MockDeliverNoteOnService mock2 = new MockDeliverNoteOnService("2015-11-19","王小五");
        service.insertDeliverNote(mock1);
        service.insertDeliverNote(mock2);
        //assertEquals(true,service.findAllDeliverNote().size()>=2);
    }

}