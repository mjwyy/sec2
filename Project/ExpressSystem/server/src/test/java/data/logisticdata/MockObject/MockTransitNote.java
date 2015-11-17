package data.logisticdata.MockObject;

import po.TransitNotePO;

import java.util.ArrayList;

/**
 * Created by kylin on 15/11/12.
 */
public class MockTransitNote extends TransitNotePO {

    public MockTransitNote(String date, String transitDocNumber,
                           String flightNumber, String departurePlace,
                           String desitination, String containerNumber,
                           String supercargoMan, ArrayList<String> barcodes) {
        super(date, transitDocNumber, flightNumber, departurePlace,
                desitination, containerNumber, supercargoMan, barcodes);
    }

    public MockTransitNote(String transitDocNumber,String flightNumber,String desitination){
        super(null, transitDocNumber, flightNumber, null, desitination, null, null, null);
    }

}
