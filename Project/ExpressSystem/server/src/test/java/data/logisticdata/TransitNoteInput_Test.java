package data.logisticdata;

import data.logisticdata.MockObject.MockTransitNote;
import dataservice.logisticdataservice.TransitNoteInputDataService;
import org.junit.Test;
import po.TransitNotePO;

import java.lang.reflect.Array;
import java.rmi.RemoteException;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by kylin on 15/11/10.
 */
public class TransitNoteInput_Test {

    private TransitNoteInputDataService service = new TransitNoteInputData();

    @Test
    public void testInsert() throws RemoteException {
        MockTransitNote po1 = new MockTransitNote("025100201510200000012","CA1206","南京");
        MockTransitNote po2 = new MockTransitNote("025100201510200000013","CA1206","南京");
        assertEquals(true,service.insert(po1));
        assertEquals(true,service.insert(po2));
    }

    @Test
    public void testDelete() throws RemoteException {
        MockTransitNote po1 = new MockTransitNote("025100201510200000014","CA1206","南京");
        MockTransitNote po2 = new MockTransitNote("025100201510200000015","CA1206","南京");
        service.insert(po1);
        service.insert(po2);
        assertEquals(true,service.delete(po1));
        assertEquals(false,service.delete(po1));
        assertEquals(true,service.delete(po2));
    }

    @Test
    public void testUpdate() throws RemoteException {
        MockTransitNote po1 = new MockTransitNote("025100201510200000016","CA1206","南京");
        service.insert(po1);
        po1 = new MockTransitNote(
                "025100201510200000016","CA8888","南京");
        assertEquals(true,service.update(po1));
    }

    @Test
    public void testFind() throws RemoteException {
        MockTransitNote po1 = new MockTransitNote("025100201510200000200","CA9999","南京");
        MockTransitNote po2 = new MockTransitNote("025100201510200000302","CA9999","南京");
        MockTransitNote po3 = new MockTransitNote("025100201510200000405","CA9999","南京");
        MockTransitNote po4 = new MockTransitNote("025100201510200000509","CA9999","南京");
        service.insert(po1);
        service.insert(po2);
        service.insert(po3);
        service.insert(po4);
        MockTransitNote toFind = new MockTransitNote(null,"CA1209",null);
        ArrayList<TransitNotePO> list = service.find(toFind);
        assertEquals(4,list.size());
        assertEquals("南京",list.get(0).getDesitination());
        assertEquals("南京",list.get(1).getDesitination());
    }

    @Test
    public void testFindAll() throws RemoteException {
        MockTransitNote po1 = new MockTransitNote("025100201510200000017","CA1206","南京");
        MockTransitNote po2 = new MockTransitNote("025100201510200000018","CA1206","南京");
        service.insert(po1);
        service.insert(po2);
        assertEquals(true,service.findAll().size()>=2);
    }
}
