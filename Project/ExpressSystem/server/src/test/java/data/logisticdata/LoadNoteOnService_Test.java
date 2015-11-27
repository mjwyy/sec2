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
        //assertEquals(true,service.insert(mock1));
        //assertEquals(80,mock1.getTransferPrice());
        MockLoadNoteOnService mock2 = new MockLoadNoteOnService(
                "0251001201510220002","厦门","苏A 00002");
        //assertEquals(true,service.insert(mock1));
        //assertEquals(460,mock1.getTransferPrice());
    }

}
