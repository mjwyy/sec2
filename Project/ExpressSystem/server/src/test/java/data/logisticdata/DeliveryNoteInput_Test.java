package data.logisticdata;

import data.logisticdata.MockObject.MockDeliveryNote;
import dataservice.logisticdataservice.DeliveryNoteInputDataService;

import org.junit.Before;
import org.junit.Test;
import po.DeliveryNotePO;
import util.enums.DeliverCategory;
import util.SendDocMsg;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

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
    public void testInsert() throws RemoteException, SQLException {

        MockDeliveryNote po1 = new MockDeliveryNote("王二狗","江苏省南京市栖霞区南京大学仙林校区","150052120000",
                "Tom Hanks","江苏省徐州市沛县第三中学语文组","19883490000","爆炸物",10,
                10,2, DeliverCategory.EXPRESS,5,"0000000001");
        SendDocMsg msg = service.insert(po1);
        assertEquals(msg.getPrice(),235);
        assertEquals(msg.getPredectedDate(),2015-12-22);

        MockDeliveryNote po2 = new MockDeliveryNote("王二狗","江苏省南京市栖霞区南京大学仙林校区","150052120000",
                "Tom Hanks","上海环球金融中心78层优则金融有限公司","19883490000","爆炸物",10,
                1,2, DeliverCategory.EXPRESS,5,"0000000001");
        SendDocMsg msg2 = service.insert(po1);
        //assertEquals(msg2.getPrice(),28);
        //assertEquals(msg2.getPredectedDate(),2015-11-22);
    }


}
