package dataservice.logisticdataservice;

import po.ReceivingNoteInputPO;

import java.rmi.RemoteException;

/**
 * Created by kylin on 15/10/21.
 */
public class ReceivingNoteInputDataService_Driver {

    public static void main(String[] args) throws RemoteException {
        ReceivingNoteInputDataService service = new ReceivingNoteInputDataService_Stub();
        ReceivingNoteInputDataService_Driver driver = new ReceivingNoteInputDataService_Driver();
        driver.drive(service);
    }

    public void drive(ReceivingNoteInputDataService service) throws RemoteException {
        ReceivingNoteInputPO po1 = new ReceivingNoteInputPO("0123456789","旭爷","2015-10-23 14:00");
        ReceivingNoteInputPO po2 = new ReceivingNoteInputPO("0123456790","汪同学","2015-10-23 14:00");
        ReceivingNoteInputPO po3 = new ReceivingNoteInputPO("0123456791","狗狗","2015-10-26 9:00");
        service.insert(po1);
        service.insert(po2);
        service.insert(po3);
        service.findAll();
        service.find("汪同学");
        service.find("0123456789");
        service.delete(po1);
        service.delete(po2);
        service.findAll();
        po3 = new ReceivingNoteInputPO("0123456791","狗狗","2015-10-26 9:30");
        service.update(po3);
        service.findAll();
    }

}
