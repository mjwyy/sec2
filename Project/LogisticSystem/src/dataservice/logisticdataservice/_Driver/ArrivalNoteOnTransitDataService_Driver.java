package dataservice.logisticdataservice._Driver;

import dataservice.logisticdataservice.ArrivalNoteOnTransitDataService;
import dataservice.logisticdataservice._Stub.ArrivalNoteOnTransitDataService_Stub;
import po.ArrivalNoteOnTransitPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.util.BarcodeAndState;

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
    	ArrayList<BarcodeAndState> BarcodeAndStates=new ArrayList<BarcodeAndState> ();
    	ArrivalNoteOnTransitPO po1 = new ArrivalNoteOnTransitPO("2011-11-11","025100","025100201510200000001","上海",BarcodeAndStates);
        ArrivalNoteOnTransitPO po2 = new ArrivalNoteOnTransitPO("2011-11-11","025100","025100201510200000002","上海",BarcodeAndStates);
        if(service.insert(po1))
        	System.out.println("insert succeed");
        else
        	System.out.println("insert failed");
        if(service.insert(po2))
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
        service.findAll();
        po2= new ArrivalNoteOnTransitPO("2011-11-11","025100","025100201510200000002","上海",BarcodeAndStates);
        if(service.update(po2))
        	System.out.println("update succeed");
        else
        	System.out.println("update failed");
        service.findAll();
    }

}
