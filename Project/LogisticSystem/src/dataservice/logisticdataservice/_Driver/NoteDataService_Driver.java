<<<<<<< HEAD:Project/LogisticSystem/src/dataservice/logisticdataservice/_Driver/NoteDataService_Driver.java
package dataservice.logisticdataservice._Driver;

import dataservice.logisticdataservice.NoteDataService;
import dataservice.logisticdataservice._Stub.NoteDataService_Stub;
import po.NotePO;

import java.rmi.RemoteException;

/**
 * Created by kylin on 15/10/21.
 */
public class NoteDataService_Driver {

    public static void main(String[] args) throws RemoteException {
        NoteDataService service = new NoteDataService_Stub();
        NoteDataService_Driver driver = new NoteDataService_Driver();
        driver.drive(service);
    }

    public void drive(NoteDataService service) throws RemoteException {
        NotePO po1 = new NotePO();
        NotePO po2 = new NotePO();
        service.init();
        service.insert(po1);
        service.insert(po2);
        service.findAll();
        service.find("寄件单");
        service.find("中转单");
        service.delete(po1);
        service.delete(po2);
        service.findAll();
        service.finish();
    }

}
=======
package dataservice.logisticdataservice;

import po.NotePO;

import java.rmi.RemoteException;

/**
 * Created by kylin on 15/10/21.
 */
public class NoteDataService_Driver {

    public static void main(String[] args) throws RemoteException {
        NoteDataService service = new NoteDataService_Stub();
        NoteDataService_Driver driver = new NoteDataService_Driver();
        driver.drive(service);
    }

    public void drive(NoteDataService service) throws RemoteException {
        NotePO po1 = new NotePO();
        NotePO po2 = new NotePO();
        service.init();
        service.insert(po1);
        service.insert(po2);
        service.show();
        service.findByName("寄件单");
        service.findByName("中转单");
        service.delete(po1);
        service.delete(po2);
        service.show();
        service.finish();
    }

}
>>>>>>> parent of 2d8eb69... 10.22这个世界没有锟斤拷版本:Project/LogisticSystem/src/dataservice/logisticdataservice/NoteDataService_Driver.java
