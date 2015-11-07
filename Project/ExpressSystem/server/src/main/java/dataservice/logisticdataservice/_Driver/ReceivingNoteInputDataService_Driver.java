package dataservice.logisticdataservice._Driver;

import dataservice.logisticdataservice.ReceivingNoteInputDataService;
import dataservice.logisticdataservice._Stub.ReceivingNoteInputDataService_Stub;
import po.ReceivingNotePO;

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
        ReceivingNotePO po1 = new ReceivingNotePO("0123456789","旭爷","2015-10-23 14:00");
        ReceivingNotePO po2 = new ReceivingNotePO("0123456790","汪同学","2015-10-23 14:00");
        ReceivingNotePO po3 = new ReceivingNotePO("0123456791","狗狗","2015-10-26 9:00");
        if(service.insert(po1))
        	System.out.println("insert succeed");
        else
        	System.out.println("insert failed");
        if(service.insert(po2))
        	System.out.println("insert succeed");
        else
        	System.out.println("insert failed");
        if(service.insert(po3))
        	System.out.println("insert succeed");
        else
        	System.out.println("insert failed");
        service.findAll();
        service.find(po1);
        service.find(po2);
        if(service.delete(po1))
        	System.out.println("delete succeed");
        else
        	System.out.println("delete failed");
        if(service.delete(po2))
        	System.out.println("delete succeed");
        else
        	System.out.println("delete failed");
        service.findAll();
        po3 = new ReceivingNotePO("0123456791","狗狗","2015-10-26 9:30");
        if(service.update(po3))
        	System.out.println("update succeed");
        else
        	System.out.println("update failed");
        service.findAll();
    }

}
