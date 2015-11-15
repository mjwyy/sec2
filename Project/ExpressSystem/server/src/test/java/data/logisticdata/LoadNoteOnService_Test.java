package data.logisticdata;

import data.logisticdata.MockObject.MockLoadNoteOnService;
import dataservice.logisticdataservice.LoadNoteOnServiceDataService;
import org.junit.Assert;
import org.junit.Test;
import po.LoadNoteOnServicePO;

import java.rmi.RemoteException;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by kylin on 15/11/10.
 */
public class LoadNoteOnService_Test {

    private LoadNoteOnServiceDataService service = new LoadNoteOnServiceData();

    @Test
    public void testInsert() throws RemoteException {
        MockLoadNoteOnService mock1 = new MockLoadNoteOnService(
                "0251001201510220001","上海","苏A 00001");
        assertEquals(true,service.insert(mock1));
        assertEquals(80,mock1.getTransferPrice());
        MockLoadNoteOnService mock2 = new MockLoadNoteOnService(
                "0251001201510220002","厦门","苏A 00002");
        assertEquals(true,service.insert(mock1));
        assertEquals(460,mock1.getTransferPrice());
    }

    @Test
    public void testDelete() throws RemoteException {
        MockLoadNoteOnService po1 = new MockLoadNoteOnService(
                "0251001201510220003","上海","苏A 00003");
        MockLoadNoteOnService po2 = new MockLoadNoteOnService(
                "0251001201510220004","厦门","苏A 00004");
        service.insert(po1);
        service.insert(po2);
        assertEquals(true,service.delete(po1));
        assertEquals(false,service.delete(po1));
        assertEquals(true,service.delete(po2));
    }

    @Test
    public void testUpdate() throws RemoteException {
        MockLoadNoteOnService po1 = new MockLoadNoteOnService(
                "0251001201510220005","上海","苏A 00003");
        service.insert(po1);
        po1 = new MockLoadNoteOnService(
                "0251001201510220099","上海","苏A 09999");
        assertEquals(true,service.update(po1));
    }

    @Test
    public void testFind() throws RemoteException {
        MockLoadNoteOnService po1 = new MockLoadNoteOnService(
                "0251001201510220006","上海","苏A 00006");
        service.insert(po1);
        LoadNoteOnServicePO poToFind =  new MockLoadNoteOnService("0251001201510220006",null,null);
        ArrayList<LoadNoteOnServicePO> foundList = service.find(poToFind);
        LoadNoteOnServicePO found = foundList.get(0);
        assertEquals(foundList.size(),1);
        assertEquals(found.getCarNumber(),"苏A 00006");
    }

    @Test
    public void testFindAll() throws RemoteException {
        MockLoadNoteOnService po1 = new MockLoadNoteOnService(
                "0251001201510220003","上海","苏A 00003");
        MockLoadNoteOnService po2 = new MockLoadNoteOnService(
                "0251001201510220004","厦门","苏A 00004");
        service.insert(po1);
        service.insert(po2);
        assertEquals(true,service.findAll().size()>=2);
    }
}
