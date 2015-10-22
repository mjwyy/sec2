package dataservice.logisticdataservice._Driver;

import dataservice.logisticdataservice.ArrivalNoteOnServiceDataService;
import dataservice.logisticdataservice._Stub.ArrivalNoteOnServiceDataService_Stub;
import po.ArrivalNoteOnServicePO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by kylin on 15/10/20.
 */
public class ArrivalNoteOnServiceDataService_Driver {

    private ArrivalNoteOnServicePO arrivalNoteOnServicePO;
    private ArrivalNoteOnServicePO arrivalNoteOnServicePO2;
    private ArrivalNoteOnServicePO arrivalNoteOnServicePO3;
    private ArrayList<ArrivalNoteOnServicePO> pos;

    public ArrivalNoteOnServiceDataService_Driver() {
        pos = new ArrayList<ArrivalNoteOnServicePO>();
        Date date = new Date();
        arrivalNoteOnServicePO = new ArrivalNoteOnServicePO(date,"250000201510130000000","北京","南京");
        arrivalNoteOnServicePO2 = new ArrivalNoteOnServicePO(date,"250000201510130000001","北京","南京");
        arrivalNoteOnServicePO3 = new ArrivalNoteOnServicePO(date,"250000201510130000002","北京","南京");
        pos.add(arrivalNoteOnServicePO);
        pos.add(arrivalNoteOnServicePO2);
        pos.add(arrivalNoteOnServicePO3);
    }


    public void drive(ArrivalNoteOnServiceDataService arrivalNoteOnServiceDataService) throws RemoteException {
        arrivalNoteOnServiceDataService.insert(arrivalNoteOnServicePO);
        arrivalNoteOnServiceDataService.insert(arrivalNoteOnServicePO2);
        arrivalNoteOnServiceDataService.find("南京");
        arrivalNoteOnServiceDataService.find("北京");
        arrivalNoteOnServiceDataService.findAll();
        arrivalNoteOnServiceDataService.delete(arrivalNoteOnServicePO);
        arrivalNoteOnServiceDataService.update(arrivalNoteOnServicePO3);
    }

    public static void main(String[] args) throws RemoteException {
        ArrivalNoteOnServiceDataService stub = new ArrivalNoteOnServiceDataService_Stub();
        ArrivalNoteOnServiceDataService_Driver driver = new ArrivalNoteOnServiceDataService_Driver();
        driver.drive(stub);
    }
}
