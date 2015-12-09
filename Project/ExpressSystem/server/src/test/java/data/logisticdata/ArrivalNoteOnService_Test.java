package data.logisticdata;

import data.database.DatabaseFactoryMysqlImpl;
import data.statisticdata.LogInsHelper;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import dataservice.logisticdataservice.ArrivalNoteOnServiceDataService;
import org.junit.Test;
import po.ArrivalNoteOnServicePO;
import po.DeliverNoteOnServicePO;
import util.BarcodeAndState;
import util.ResultMsg;
import util.enums.GoodsState;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/11/10.
 */
public class ArrivalNoteOnService_Test {

    @Test
    public void testInsertArrivalNote() throws RemoteException, SQLException, ElementNotFoundException, InterruptWithExistedElementException {
        ArrivalNoteOnServiceDataService data = DatabaseFactoryMysqlImpl.getInstance().
                getArrivalNoteOnServiceDataService();
        ArrayList<BarcodeAndState> barcodes = new ArrayList<>();
        barcodes.add(new BarcodeAndState("1234567890", GoodsState.COMPLETE));
        barcodes.add(new BarcodeAndState("1234567890", GoodsState.COMPLETE));
        barcodes.add(new BarcodeAndState("1234567890", GoodsState.COMPLETE));
        barcodes.add(new BarcodeAndState("1234567890", GoodsState.COMPLETE));
        barcodes.add(new BarcodeAndState("1234567890", GoodsState.COMPLETE));
        ArrivalNoteOnServicePO mock1 = new ArrivalNoteOnServicePO("2015-11-11", false,
                "250000201510130000016", "北京", barcodes);
        mock1.setUserName("tom");
        mock1.setOrganization("南京中转中心");
        ResultMsg resultMsg = data.insertArrivalNote(mock1);
        System.out.println(resultMsg.getMessage());
    }

    @Test
    public void testInsertDeliverNote() throws RemoteException, SQLException, ElementNotFoundException {
        ArrayList<String> barcodes = new ArrayList<>();
        barcodes.add("1234567890");
        barcodes.add("1234567891");
        barcodes.add("1234567892");
        DeliverNoteOnServicePO po1 = new DeliverNoteOnServicePO("025123456", "2015-11-16", barcodes, "test3");
//        service.insertDeliverNote(po1);
    }

    @Test
    public void testFindArrival() throws RemoteException, SQLException {
        ArrivalNoteOnServiceDataService data = DatabaseFactoryMysqlImpl.getInstance().getArrivalNoteOnServiceDataService();

    }

}