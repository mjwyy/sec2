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
        //assertEquals(true,service.insert(po1));
        //assertEquals(true,service.insert(po2));
    }

}
