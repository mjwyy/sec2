package data.logisticdata.MockObject;

import po.DeliverNoteOnServicePO;

import java.util.ArrayList;

/**
 * Created by kylin on 15/11/12.
 */
public class MockDeliverNoteOnService extends DeliverNoteOnServicePO {
    public MockDeliverNoteOnService(String date, ArrayList<String> barCode, String deliveryMan) {
        super(date, barCode, deliveryMan);
    }
}
