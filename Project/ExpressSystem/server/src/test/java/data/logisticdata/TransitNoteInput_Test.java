package data.logisticdata;

import data.database.DatabaseFactoryMysqlImpl;
import data.logisticdata.MockObject.MockTransitNote;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import dataservice.logisticdataservice.TransitNoteInputDataService;
import org.junit.Test;
import po.TransitNotePO;
import util.BarcodesAndLocation;
import util.enums.TransitType;
import vo.TransitNoteOnTransitVO;

import java.lang.reflect.Array;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by kylin on 15/11/10.
 */
public class TransitNoteInput_Test {

    private TransitNoteInputDataService service;

    public TransitNoteInput_Test() throws RemoteException {
        service = DatabaseFactoryMysqlImpl.getInstance().getTransitNoteInputDataService();
    }

//    @Test
    public void testInsert() throws RemoteException, SQLException, ElementNotFoundException, InterruptWithExistedElementException {
        ArrayList<String> bar = new ArrayList<String>();
        bar.add("1234567890");
        ArrayList<BarcodesAndLocation> list = new ArrayList<BarcodesAndLocation>();
        list.add(new BarcodesAndLocation("0123456789", 1, 2, 3, 4));
        list.add(new BarcodesAndLocation("0123456790", 1, 2, 3, 5));
        list.add(new BarcodesAndLocation("0123456791", 1, 2, 3, 6));
        list.add(new BarcodesAndLocation("0123456792", 1, 2, 3, 7));
        TransitNotePO po1 = new TransitNotePO("2011-11-11", "025000201510120000007",
                "MF8190", TransitType.Aircraft, "北京",
                "南京", "Tom", list);
        service.insert(po1);
    }

//    @Test
    public void testFind() throws SQLException, RemoteException {
        service.getTransitNotePO();
    }

    @Test
    public void testBarcodes() throws SQLException, RemoteException {
        TransitNoteInputData data = new TransitNoteInputData();
        ArrayList<BarcodesAndLocation> andLocations = data.getBarcodesAndLocation("1234567890,1,2,3,4;1234567890,1,2,3,4;");
        System.out.println(andLocations.get(0).getLine());
    }

}
