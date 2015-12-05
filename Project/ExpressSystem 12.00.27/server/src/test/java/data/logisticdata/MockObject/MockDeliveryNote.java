package data.logisticdata.MockObject;

import po.DeliveryNotePO;
import util.enums.DeliverCategory;
import util.enums.PackageType;

/**
 * Created by kylin on 15/11/10.
 */
public class MockDeliveryNote extends DeliveryNotePO{
    public MockDeliveryNote(String senderName, String senderAddress, String senderTeleNumber, String receiverName, String receiverAddress, String receiverTeleNumber, String name, int goodsNumber, double weight, double volume, DeliverCategory category, PackageType packageType, String barCode) {
        super(senderName, senderAddress, senderTeleNumber, receiverName, receiverAddress, receiverTeleNumber, name, goodsNumber, weight, volume, category, packageType, barCode);
    }
}
