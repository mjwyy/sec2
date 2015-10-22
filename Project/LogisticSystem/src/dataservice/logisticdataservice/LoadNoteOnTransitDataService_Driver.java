package dataservice.logisticdataservice;

import po.DeliveryNoteInputPO;
import po.LoadNoteOnTransitPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/10/21.
 */
public class LoadNoteOnTransitDataService_Driver {

    public static void main(String[] args) throws RemoteException {
        LoadNoteOnTransitDataService service = new LoadNoteOnTransitDataService_Stub();
        LoadNoteOnTransitDataService_Driver driver = new LoadNoteOnTransitDataService_Driver();
        driver.drive(service);
    }

    public void drive(LoadNoteOnTransitDataService service) throws RemoteException {
        ArrayList<String> codes = new ArrayList<String>();
        codes.add("0000000004");
        codes.add("0000000005");
        ArrayList<String> codes2 = new ArrayList<String>();
        codes2.add("0000000006");
        codes2.add("0000000019");
        codes2.add("0000000020");
        codes2.add("0000000030");
        LoadNoteOnTransitPO po1 = new LoadNoteOnTransitPO("2015-10-23","025100120151023000001","北京","苏A 00001",
                "朱梦晴","武昌昊",codes);
        LoadNoteOnTransitPO po2 = new LoadNoteOnTransitPO("2015-10-23","025100120151023000001","北京","苏A 00001",
                "李沪东","吴大爷",codes2);
        service.insert(po1);
        service.insert(po2);
        service.findAll();
        service.find("武昌昊");
        service.find("李沪东");
        service.find("北京");
        service.find("苏A 00001");
        service.delete(po1);
        service.findAll();
        po2 = new LoadNoteOnTransitPO("2015-10-23","025100120151023000003","西藏","苏B 00001",
                "李沪东","吴大爷",codes2);
        service.update(po2);
        service.findAll();
    }

}
