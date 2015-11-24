package data.logisticdata;

import data.logisticdata.MockObject.MockDeliveryNote;
import dataservice.logisticdataservice.DeliveryNoteInputDataService;
<<<<<<< HEAD
import org.junit.Before;
=======

>>>>>>> origin/master
import org.junit.Test;

import po.DeliveryNotePO;
import util.enums.DeliverCategory;
import util.sendDocMsg;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by kylin on 15/11/10.
 */
public class DeliveryNoteInput_Test {

<<<<<<< HEAD
    private DeliveryNoteInputDataService service;
=======
    private DeliveryNoteInputDataService service = new DeliveryNoteInputData(null);
>>>>>>> origin/master

    //这个测试类之间的方法没有顺序,但是方法之间互相依赖十分严重

    @Before
    public void setUp() throws Exception {
        service = new DeliveryNoteInputData();
    }

    @Test
<<<<<<< HEAD
    public void testInsert() throws Exception {
        setUp();
=======
    public void testInsert() throws RemoteException, SQLException {
>>>>>>> origin/master
        MockDeliveryNote po1 = new MockDeliveryNote("王二狗","江苏省南京市栖霞区南京大学仙林校区","150052120000",
                "Tom Hanks","江苏省徐州市沛县第三中学语文组","19883490000","爆炸物",10,
                10,2, DeliverCategory.EXPRESS,5,"0000000001");
        sendDocMsg msg = service.insert(po1);
        assertEquals(msg.getPrice(),235);
        assertEquals(msg.getPredectedDate(),2015-12-22);

        MockDeliveryNote po2 = new MockDeliveryNote("王二狗","江苏省南京市栖霞区南京大学仙林校区","150052120000",
                "Tom Hanks","上海环球金融中心78层优则金融有限公司","19883490000","爆炸物",10,
                1,2, DeliverCategory.EXPRESS,5,"0000000001");
        sendDocMsg msg2 = service.insert(po1);
        //assertEquals(msg2.getPrice(),28);
        //assertEquals(msg2.getPredectedDate(),2015-11-22);
    }

    @Test
    public void testDelete() throws RemoteException, SQLException {
        MockDeliveryNote po1 = new MockDeliveryNote("王二狗","江苏省南京市栖霞区南京大学仙林校区","150052120000",
                "Tom Hanks","江苏省徐州市沛县第三中学语文组","19883490000","爆炸物",10,
                10,2, DeliverCategory.EXPRESS,5,"0000000001");
        service.insert(po1);
        MockDeliveryNote po2 = new MockDeliveryNote("王二狗","江苏省南京市栖霞区南京大学仙林校区","150052120000",
                "Tom Hanks","江苏省徐州市沛县第三中学语文组","19883490000","爆炸物",10,
                10,2, DeliverCategory.EXPRESS,5,"0000000002");
        service.insert(po1);
        service.insert(po2);
        //assertEquals(true,service.delete(po1));
        //assertEquals(false,service.delete(po1));
        //assertEquals(true,service.delete(po2));
    }

    @Test
    public void testUpdate() throws RemoteException, SQLException {
        MockDeliveryNote po1 = new MockDeliveryNote("王二狗","江苏省南京市栖霞区南京大学仙林校区","150052120000",
                "Tom Hanks","江苏省徐州市沛县第三中学语文组","19883490000","爆炸物",10,
                10,2, DeliverCategory.EXPRESS,5,"0000000001");
        service.insert(po1);
        po1 = new MockDeliveryNote("王二狗2","江苏省南京市栖霞区南京大学仙林校区","150052120000",
                "Tom Hanks","江苏省徐州市沛县第三中学语文组","19883490000","爆炸物",10,
                10,2, DeliverCategory.EXPRESS,5,"0000000999");
        //assertEquals(true,service.update(po1));
    }

    @Test
    public void testFind() throws RemoteException, SQLException {
        MockDeliveryNote po1 =  new MockDeliveryNote("王二狗","江苏省南京市栖霞区南京大学仙林校区","150052120000",
                "Tom Hanks","江苏省徐州市沛县第三中学语文组","19883490000","爆炸物",10,
                10,2, DeliverCategory.EXPRESS,5,"0000000001");
        service.insert(po1);
        DeliveryNotePO poToFind =  new MockDeliveryNote("爆炸物",null,null,null,null,null,null
                ,0,0,0,null,0,null);
        ArrayList<DeliveryNotePO> foundList = service.find(poToFind);
        DeliveryNotePO found = foundList.get(0);
        //assertEquals(foundList.size(),1);
        //assertEquals(found.getBarCode(),"0000000001");
        //assertEquals(found.getCategory(),DeliverCategory.EXPRESS);
        //assertEquals(found.getReceiverName(),"Tom Hanks");
    }

    @Test
    public void testFindAll() throws RemoteException, SQLException {
        MockDeliveryNote po1 = new MockDeliveryNote("王二狗","江苏省南京市栖霞区南京大学仙林校区","150052120000",
                "Tom Hanks","江苏省徐州市沛县第三中学语文组","19883490000","爆炸物",10,
                10,2, DeliverCategory.EXPRESS,5,"0000000001");
        service.insert(po1);
        MockDeliveryNote po2 = new MockDeliveryNote("王二狗","江苏省南京市栖霞区南京大学仙林校区","150052120000",
                "Tom Hanks","江苏省徐州市沛县第三中学语文组","19883490000","爆炸物",10,
                10,2, DeliverCategory.EXPRESS,5,"0000000002");
        service.insert(po2);
        MockDeliveryNote po3 = new MockDeliveryNote("王二狗","江苏省南京市栖霞区南京大学仙林校区","150052120000",
                "Tom Hanks","江苏省徐州市沛县第三中学语文组","19883490000","爆炸物",10,
                10,2, DeliverCategory.EXPRESS,5,"0000000003");
        service.insert(po2);
        ArrayList<DeliveryNotePO> findPOS = service.findAll();
        //assertEquals(findPOS.size(),3);
    }
}
