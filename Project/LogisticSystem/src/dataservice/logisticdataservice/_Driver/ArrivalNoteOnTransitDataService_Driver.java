<<<<<<< HEAD:Project/LogisticSystem/src/dataservice/logisticdataservice/_Driver/ArrivalNoteOnTransitDataService_Driver.java
package dataservice.logisticdataservice._Driver;

import dataservice.logisticdataservice.ArrivalNoteOnTransitDataService;
import dataservice.logisticdataservice._Stub.ArrivalNoteOnTransitDataService_Stub;
import po.ArrivalNoteOnTransitPO;

import java.rmi.RemoteException;
import java.util.Date;

/**
 * Created by kylin on 15/10/21.
 */
public class ArrivalNoteOnTransitDataService_Driver {

    public static void main(String[] args) throws RemoteException {
        ArrivalNoteOnTransitDataService service = new ArrivalNoteOnTransitDataService_Stub();
        ArrivalNoteOnTransitDataService_Driver driver = new ArrivalNoteOnTransitDataService_Driver();
        driver.drive(service);
    }

    public void drive(ArrivalNoteOnTransitDataService service) throws RemoteException {
        Date date = new Date();
        ArrivalNoteOnTransitPO po1 = new ArrivalNoteOnTransitPO(date,"025100","025100201510200000001","北京","完整");
        ArrivalNoteOnTransitPO po2 = new ArrivalNoteOnTransitPO(date,"025100","025100201510200000002","上海","完整");
        service.insert(po1);
        service.insert(po2);
        service.findAll();
        service.find("北京");
        service.find("上海");
        service.find("完整");
        service.delete(po1);
        service.findAll();
        po2= new ArrivalNoteOnTransitPO(date,"025100","025100201510200000002","上海","损失");
        service.update(po2);
        service.findAll();
        service.find("损失");
    }

}
=======
package dataservice.logisticdataservice;

import po.ArrivalNoteOnTransitPO;

import java.rmi.RemoteException;
import java.util.Date;

/**
 * Created by kylin on 15/10/21.
 */
public class ArrivalNoteOnTransitDataService_Driver {

    public static void main(String[] args) throws RemoteException {
        ArrivalNoteOnTransitDataService service = new ArrivalNoteOnTransitDataService_Stub();
        ArrivalNoteOnTransitDataService_Driver driver = new ArrivalNoteOnTransitDataService_Driver();
        driver.drive(service);
    }

    public void drive(ArrivalNoteOnTransitDataService service) throws RemoteException {
        Date date = new Date();
        ArrivalNoteOnTransitPO po1 = new ArrivalNoteOnTransitPO(date,"025100","025100201510200000001","北京","完整");
        ArrivalNoteOnTransitPO po2 = new ArrivalNoteOnTransitPO(date,"025100","025100201510200000002","上海","完整");
        service.insert(po1);
        service.insert(po2);
        service.show();
        service.findByName("北京");
        service.findByName("上海");
        service.findByName("完整");
        service.delete(po1);
        service.show();
        po2= new ArrivalNoteOnTransitPO(date,"025100","025100201510200000002","上海","损失");
        service.update(po2);
        service.show();
        service.findByName("损失");
    }

}
>>>>>>> parent of 2d8eb69... 10.22这个世界没有锟斤拷版本:Project/LogisticSystem/src/dataservice/logisticdataservice/ArrivalNoteOnTransitDataService_Driver.java
