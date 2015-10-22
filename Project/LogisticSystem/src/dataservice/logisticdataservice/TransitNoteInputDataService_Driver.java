<<<<<<< HEAD
package dataservice.logisticdataservice;

import po.TransitNoteInputPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/10/21.
 */
public class TransitNoteInputDataService_Driver {

    public static void main(String[] args) throws RemoteException {
        TransitNoteInputDataService service = new TransitNoteInputDataService_Stub();
        TransitNoteInputDataService_Driver driver = new TransitNoteInputDataService_Driver();
        driver.drive(service);
    }

    public void drive(TransitNoteInputDataService service) throws RemoteException {
        ArrayList<String> list = new ArrayList<String>();
        list.add("0000111110");
        list.add("0000111111");
        list.add("0000111112");
        list.add("0000111113");
        ArrayList<String> list2 = new ArrayList<String>();
        list.add("2000111110");
        list.add("2000111111");
        list.add("3000111112");
        list.add("4000111113");
        TransitNoteInputPO po1 = new TransitNoteInputPO("2015-10-23","025100201510200000012","CA1206","南京",
                "西安","0120","王小二",list);
        TransitNoteInputPO po2 = new TransitNoteInputPO("2015-10-24","025100201510200000013","CZ3151","南京",
                "深圳","0122","西北狼",list2);
        service.insert(po1);
        service.insert(po2);
        service.findAll();
        service.find("西安");
        service.find("王小二");
        service.find("CA1206");
        service.find("3000111112");
        service.delete(po1);
        service.delete(po2);
        service.findAll();
    }

}
=======
package dataservice.logisticdataservice;

import po.TransitNoteInputPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/10/21.
 */
public class TransitNoteInputDataService_Driver {

    public static void main(String[] args) throws RemoteException {
        TransitNoteInputDataService service = new TransitNoteInputDataService_Stub();
        TransitNoteInputDataService_Driver driver = new TransitNoteInputDataService_Driver();
        driver.drive(service);
    }

    public void drive(TransitNoteInputDataService service) throws RemoteException {
        ArrayList<String> list = new ArrayList<String>();
        list.add("0000111110");
        list.add("0000111111");
        list.add("0000111112");
        list.add("0000111113");
        ArrayList<String> list2 = new ArrayList<String>();
        list.add("2000111110");
        list.add("2000111111");
        list.add("3000111112");
        list.add("4000111113");
        TransitNoteInputPO po1 = new TransitNoteInputPO("2015-10-23","025100201510200000012","CA1206","南京",
                "西安","0120","王小二",list);
        TransitNoteInputPO po2 = new TransitNoteInputPO("2015-10-24","025100201510200000013","CZ3151","南京",
                "深圳","0122","西北狼",list2);
        service.insert(po1);
        service.insert(po2);
        service.show();
        service.findByName("西安");
        service.findByName("王小二");
        service.findByName("CA1206");
        service.findByName("3000111112");
        service.delete(po1);
        service.delete(po2);
        service.show();
    }

}
>>>>>>> master
