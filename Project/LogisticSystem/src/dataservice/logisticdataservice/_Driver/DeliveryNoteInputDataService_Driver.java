package dataservice.logisticdataservice._Driver;

import dataservice.logisticdataservice.DeliveryNoteInputDataService;
import dataservice.logisticdataservice._Stub.DeliveryNoteInputDataService_Stub;
import po.DeliveryNoteInputPO;

import java.rmi.RemoteException;

/**
 * Created by kylin on 15/10/21.
 */
public class DeliveryNoteInputDataService_Driver {

    public static void main(String[] args) throws RemoteException {
        DeliveryNoteInputDataService service = new DeliveryNoteInputDataService_Stub();
        DeliveryNoteInputDataService_Driver driver = new DeliveryNoteInputDataService_Driver();
        driver.drive(service);
    }

    public void drive(DeliveryNoteInputDataService service) throws RemoteException {
        DeliveryNoteInputPO po1 = new DeliveryNoteInputPO("王二狗","江苏省南京市栖霞区南京大学仙林校区","南京大学仙林校区",
                "150052120000","1",0.5,20,"离散数学","书籍",5,"1234567890");
        DeliveryNoteInputPO po2 = new DeliveryNoteInputPO("kylin","江苏省南京市栖霞区南京大学仙林校区","南京大学仙林校区",
                "150052126666","1",0.5,20,"head first java","书籍",5,"1234567891");
        service.insert(po1);
        service.insert(po2);
        service.findAll();
        service.find("王二狗");
        service.find("离散数学");
        service.find("书籍");
        service.find("1234567891");
        service.delete(po1);
        service.findAll();
        po2 = new DeliveryNoteInputPO("一只麟","江苏省南京市栖霞区南京大学仙林校区","南京大学仙林校区",
                "150052126666","1",0.2,20,"人月神话","书籍",5,"1234567894");
        service.update(po2);
        service.findAll();
    }
}
