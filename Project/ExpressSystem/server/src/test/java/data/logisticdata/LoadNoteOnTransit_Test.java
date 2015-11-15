package data.logisticdata;

import data.logisticdata.MockObject.MockLoadNoteOnTransit;
import dataservice.logisticdataservice.LoadNoteOnTransitDataService;
import org.junit.Test;
import po.LoadNoteOnTransitPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by kylin on 15/11/10.
 */
public class LoadNoteOnTransit_Test {

    private LoadNoteOnTransitDataService service = new LoadNoteOnTransitData();

    @Test
    public void testInsert() throws RemoteException {
        MockLoadNoteOnTransit po1 = new MockLoadNoteOnTransit("025100120151023000001","北京","苏A 00001");
        MockLoadNoteOnTransit po2 = new MockLoadNoteOnTransit("025100120151023000002","北京","苏A 00002");
        assertEquals(true,service.insert(po1));
        assertEquals(true,service.insert(po2));
    }

    @Test
    public void testDelete() throws RemoteException {
        MockLoadNoteOnTransit po1 = new MockLoadNoteOnTransit("025100120151023000003","北京","苏A 00001");
        MockLoadNoteOnTransit po2 = new MockLoadNoteOnTransit("025100120151023000004","北京","苏A 00002");
        service.insert(po1);
        service.insert(po2);
        assertEquals(true,service.delete(po1));
        assertEquals(false,service.delete(po1));
        assertEquals(true,service.delete(po2));
    }

    @Test
    public void testUpdate() throws RemoteException {
        MockLoadNoteOnTransit po1 = new MockLoadNoteOnTransit("025100120151023000005","北京","苏A 00001");
        service.insert(po1);
        po1 = new MockLoadNoteOnTransit(
                "0251001201510220099","上海","苏A 09999");
        assertEquals(true,service.update(po1));
    }

    @Test
    public void testFind() throws RemoteException {
        MockLoadNoteOnTransit po1 = new MockLoadNoteOnTransit("025100120151023000006","北京","苏A 00888");
        service.insert(po1);
        MockLoadNoteOnTransit toFind = new MockLoadNoteOnTransit("025100120151023000006",null,null);
        ArrayList<LoadNoteOnTransitPO> list = service.find(toFind);
        MockLoadNoteOnTransit found = (MockLoadNoteOnTransit) list.get(0);
        assertEquals(list.size(),1);
        assertEquals(found.getCarNumber(),"苏A 00888");
        assertEquals(found.getDestination(),"北京");
    }

    @Test
    public void testFindAll() throws RemoteException {
        MockLoadNoteOnTransit po1 = new MockLoadNoteOnTransit("025100120151023000007","北京","苏A 00001");
        MockLoadNoteOnTransit po2 = new MockLoadNoteOnTransit("025100120151023000008","北京","苏A 00002");
        service.insert(po1);
        service.insert(po2);
        assertEquals(true,service.findAll().size()>=2);
    }
}
