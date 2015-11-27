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
        //assertEquals(true,service.insert(po1));
        //assertEquals(true,service.insert(po2));
    }


}
