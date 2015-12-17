package data.logisticdata.MockObject;

import po.TransitNotePO;
import util.BarcodesAndLocation;
import util.enums.TransitType;

import java.util.ArrayList;

/**
 * Created by kylin on 15/11/12.
 */
public class MockTransitNote extends TransitNotePO {

    public MockTransitNote(String date, String transitDocNumber, String flightNumber, TransitType transitType, String departurePlace, String desitination, String supercargoMan, ArrayList<String> barcodes) {
        super(date, transitDocNumber, flightNumber, transitType, departurePlace, desitination, supercargoMan, barcodes);
    }
}
