package data.logisticdata;

import dataservice.exception.ElementNotFoundException;
import dataservice.logisticdataservice.DeliveryNoteInputDataService;

import org.junit.Before;
import org.junit.Test;
import po.DeliveryNotePO;
import util.SendDocMsg;
import util.enums.DeliverCategory;

import java.rmi.RemoteException;
import java.sql.SQLException;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by kylin on 15/11/10.
 */
public class DeliveryNoteInput_Test {

    private DeliveryNoteInputDataService service;

    public DeliveryNoteInput_Test() throws RemoteException {
        service = new DeliveryNoteInputData();
    }

    //这个测试类之间的方法没有顺序,但是方法之间互相依赖十分严重
    @Before
    public void setUp() throws Exception {
        service = new DeliveryNoteInputData();
    }

    @Test
    public void testInsert() throws RemoteException, SQLException, ElementNotFoundException {

        DeliveryNotePO po1 = new DeliveryNotePO("王二狗", "南京市", "15005"
                , "Tom Hanks", "北京市", "19883490000", "book", 1, 2, 3
                , DeliverCategory.EXPRESS, 5, "123123123");
        SendDocMsg msg2 = service.insert(po1);
        System.out.println(msg2.getPrice());
    }


}
