package data.logisticdata;

import data.logisticdata.MockObject.MockDeliveryNote;
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

    private DeliveryNoteInputDataService service = new DeliveryNoteInputData();

    //这个测试类之间的方法没有顺序,但是方法之间互相依赖十分严重
    @Before
    public void setUp() throws Exception {
        service = new DeliveryNoteInputData();
    }

    @Test
    public void testInsert() throws RemoteException, SQLException, ElementNotFoundException {

//        MockDeliveryNote po1 = new MockDeliveryNote("王二狗","江苏省南京市栖霞区南京大学仙林校区","150052120000",
//                "Tom Hanks","江苏省徐州市沛县第三中学语文组","19883490000","爆炸物",10,
//                10,2, DeliverCategory.EXPRESS,5,"0000000001");
//        SendDocMsg msg = service.insert(po1);
//        assertEquals(msg.getPrice(),235);
//        assertEquals(msg.getPredectedDate(),2015-12-22);

        DeliveryNotePO po1 = new DeliveryNotePO("王二狗", "江苏省", "15005"
                , "Tom Hanks", "江苏省徐州市沛县第三中学语文组", "19883490000", "book", 1, 2, 3
                , DeliverCategory.EXPRESS, 5, "000000008");
//        System.out.println(po1.getName());
        SendDocMsg msg2 = service.insert(po1);
    }


}
