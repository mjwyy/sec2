package data.logisticdata.MockObject;

import po.DeliveryNotePO;
import util.enums.DeliverCategory;

/**
 * Created by kylin on 15/11/10.
 */
public class MockDeliveryNote extends DeliveryNotePO {

    public MockDeliveryNote(String senderName, String senderAddress,
                            String senderWorkPlace, String senderTeleNumber,
                            String number, double weight, double volume, String name,
                            DeliverCategory category, double packPrice, String barCode) {
        super(senderName, senderAddress, senderWorkPlace, senderTeleNumber, number,
                weight, volume, name, category, packPrice, barCode);
    }


}
