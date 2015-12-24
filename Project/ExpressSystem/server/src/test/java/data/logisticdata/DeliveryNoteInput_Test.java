package data.logisticdata;

import data.database.DatabaseFactoryMysqlImpl;
import data.statisticdata.BusinessDataModificationData;
import data.statisticdata.OrderInquiryData;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import dataservice.logisticdataservice.DeliveryNoteInputDataService;

import org.junit.Before;
import org.junit.Test;
import po.DeliveryNotePO;
import util.SendDocMsg;
import util.enums.DeliverCategory;
import util.enums.PackageType;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by kylin on 15/11/10.
 */
public class DeliveryNoteInput_Test {

    DeliveryNoteInputDataService service;

    public DeliveryNoteInput_Test() throws RemoteException {
        service = DatabaseFactoryMysqlImpl.getInstance().getDeliveryNoteInputDataService();
    }

    @Test
    public void testInsert() throws RemoteException, SQLException, ElementNotFoundException, InterruptWithExistedElementException {

        DeliveryNotePO po1 = new DeliveryNotePO("王二狗", "南京市", "15005"
                , "Tom Hanks", "北京市", "19883490000", "book", 1, 2, 3
                , DeliverCategory.EXPRESS, PackageType.Bag, "5555555556");
        SendDocMsg msg2 = service.insert(po1);
        System.out.println(msg2.isPass());
    }
//
//    @Test
//    public void testCal() throws RemoteException, ElementNotFoundException, SQLException {
//        TimePresumeStrategy timePresumeStrategy = new TimePresumeStrategy();
//        PriceStrategy priceStrategy = new PriceStrategy(new BusinessDataModificationData());
//        DeliveryInfo deliveryInfo = new DeliveryInfo("nanjing","beijing",900,2,1,
//                DeliverCategory.NORMAL,PackageType.WoodenBox);
//        System.out.println(priceStrategy.getPrice(deliveryInfo));
//        System.out.println(timePresumeStrategy.getPresumedTime(deliveryInfo));
//    }

}
