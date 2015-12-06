package businesslogicservice.logisticblservice._Driver;

import businesslogic.logistic.ArrivalNoteOnService;
import businesslogicservice.logisticblservice.ArrivalNoteOnServiceBLService;
import connection.RMIHelper;
import dataservice.logisticdataservice.ArrivalNoteOnServiceDataService;
import po.ArrivalNoteOnServicePO;
import po.LoadNoteOnServicePO;
import util.BarcodeAndState;
import util.ResultMsg;
import util.enums.GoodsState;
import vo.ArrivalNoteOnServiceVO;
import vo.DeliverNoteOnServiceVO;
import vo.LoadNoteOnServiceVO;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/11/10.
 */
public class ArrivalNoteOnServiceBLService_Driver {

    public void driver(ArrivalNoteOnServiceBLService service) throws RemoteException, NotBoundException {

        ArrayList<BarcodeAndState> barcodes = new ArrayList<>();
        barcodes.add(new BarcodeAndState("0000000001", GoodsState.COMPLETE));
        barcodes.add(new BarcodeAndState("0000000002", GoodsState.COMPLETE));
        barcodes.add(new BarcodeAndState("0000000003", GoodsState.COMPLETE));
        barcodes.add(new BarcodeAndState("0000000004", GoodsState.COMPLETE));
        ArrivalNoteOnServiceVO mock1 = new ArrivalNoteOnServiceVO("2015-11-11", false,
                "02510012015101300001", "北京", barcodes);
        mock1.setUserName("tom");
        mock1.setOrganization("南京鼓楼营业厅");
        ResultMsg resultMsg = service.inputHallArrivalDoc(mock1);
        System.out.println(resultMsg.getMessage());
        if(resultMsg.isPass()){
            ResultMsg resultMsg1 = service.submitHallArrivalDoc(mock1);
            System.out.println(resultMsg1.isPass());
            System.out.println(resultMsg1.getMessage());
        }


    }

    public static void main(String[] args) throws RemoteException, NotBoundException {
        RMIHelper.tryConnect();
        ArrivalNoteOnServiceBLService_Driver driver = new ArrivalNoteOnServiceBLService_Driver();
        ArrivalNoteOnServiceBLService arrivalNoteOnServiceBLService = new ArrivalNoteOnService();
        driver.driver(arrivalNoteOnServiceBLService);
    }
}
