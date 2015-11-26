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
        //assertEquals(true,service.insert(po1));
        //assertEquals(true,service.insert(po2));
    }

}
