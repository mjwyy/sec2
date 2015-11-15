package data.logisticdata;

import data.logisticdata.MockObject.MockReceivingNote;
import org.junit.Assert;
import org.junit.Test;
import po.ReceivingNotePO;

import java.rmi.RemoteException;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by kylin on 15/11/10.
 */
public class ReceivingNoteInput_Test {

    private ReceivingNoteInputData service = new ReceivingNoteInputData();

    @Test
    public void testInsert() throws RemoteException {
        MockReceivingNote po1 = new MockReceivingNote("0123456789","旭爷","2015-10-23 14:00");
        MockReceivingNote po2 = new MockReceivingNote("0123456790","闪电球","2015-10-23 14:00");
        assertEquals(true,service.insert(po1));
        assertEquals(true,service.insert(po2));
    }

    @Test
    public void testDelete() throws RemoteException {
        MockReceivingNote po1 = new MockReceivingNote("0000000001","旭爷","2015-10-22 14:00");
        MockReceivingNote po2 = new MockReceivingNote("0000000002","闪电球","2015-10-24 14:00");
        service.insert(po1);
        service.insert(po2);
        assertEquals(true,service.delete(po1));
        assertEquals(false,service.delete(po1));
        assertEquals(true,service.delete(po2));
    }

    @Test
    public void testUpdate() throws RemoteException {
        MockReceivingNote po1 = new MockReceivingNote("0000000003","旭爷","2015-10-22 14:00");
        service.insert(po1);
        po1 = new MockReceivingNote("0000099999","旭爷","2015-10-22 22:00");
        assertEquals(true,service.update(po1));
    }

    @Test
    public void testFind() throws RemoteException {
        MockReceivingNote po1 = new MockReceivingNote("0000000004","旭爷","2015-10-22 14:00");
        service.insert(po1);
        ReceivingNotePO toFind = new ReceivingNotePO(null,"旭爷",null);
        ArrayList<ReceivingNotePO> list = service.find(toFind);
        MockReceivingNote found = (MockReceivingNote) list.get(0);
        assertEquals(list.size()>=1,true);
        assertEquals(found.getTime(),"2015-10-22 14:00");
    }

    @Test
    public void testFindAll() throws RemoteException {
        MockReceivingNote po1 = new MockReceivingNote("0000000005","旭爷","2015-10-22 14:00");
        MockReceivingNote po2 = new MockReceivingNote("0000000006","闪电球","2015-10-24 14:00");
        service.insert(po1);
        service.insert(po2);
        assertEquals(true,service.findAll().size()>=2);
    }
}
