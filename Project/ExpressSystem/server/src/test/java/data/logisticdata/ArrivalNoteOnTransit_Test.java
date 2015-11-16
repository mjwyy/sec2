package data.logisticdata;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Test;

import data.logisticdata.MockObject.MockArrivalNoteOnTransit;
import dataservice.logisticdataservice.ArrivalNoteOnTransitDataService;
import po.ArrivalNoteOnTransitPO;
import util.BarcodeAndState;
import util.enums.GoodsState;

/**
 * Created by kylin on 15/11/10.
 */
public class ArrivalNoteOnTransit_Test {

    private ArrivalNoteOnTransitDataService service = new ArrivalNoteOnTransitData();

    @Test
    public void testInsert() throws RemoteException {
    	BarcodeAndState bar=new BarcodeAndState("0123456789",GoodsState.COMPLETE);
    	BarcodeAndState bar2=new BarcodeAndState("0123456790",GoodsState.COMPLETE);
    	BarcodeAndState bar3=new BarcodeAndState("0123456790",GoodsState.COMPLETE);
		ArrayList<BarcodeAndState> BarcodeAndStates=new ArrayList<BarcodeAndState> ();
		BarcodeAndStates.add(bar);
		BarcodeAndStates.add(bar2);
		BarcodeAndStates.add(bar3);
    	MockArrivalNoteOnTransit mock = new MockArrivalNoteOnTransit(
    			"025100201510200000001","025100","2011-11-11","北京",BarcodeAndStates);
		//assertEquals(true,service.insert(mock));
    	MockArrivalNoteOnTransit mock2 = new MockArrivalNoteOnTransit(
    			"025100201510200000002","025100","2011-11-12","北京",BarcodeAndStates);
		////assertEquals(true,service.insert(mock2));
    }

    @Test
    public void testDelete() throws RemoteException {
    	BarcodeAndState bar=new BarcodeAndState("0123456789",GoodsState.COMPLETE);
		ArrayList<BarcodeAndState> BarcodeAndStates=new ArrayList<BarcodeAndState> ();
		BarcodeAndStates.add(bar);
    	MockArrivalNoteOnTransit mock = new MockArrivalNoteOnTransit(
    			"025100201510200000003","025100","2011-11-11","北京",BarcodeAndStates);
    	//assertEquals(true,service.delete(mock));
        //assertEquals(false,service.delete(mock));
    }

    @Test
    public void testUpdate() throws RemoteException {
    	BarcodeAndState bar=new BarcodeAndState("0123456789",GoodsState.COMPLETE);
		ArrayList<BarcodeAndState> BarcodeAndStates=new ArrayList<BarcodeAndState> ();
		BarcodeAndStates.add(bar);
    	MockArrivalNoteOnTransit mock = new MockArrivalNoteOnTransit(
    			"025100201510200000004","025100","2020-11-11","厦门",BarcodeAndStates);
		//assertEquals(true,service.update(mock));
    }

    @Test
    public void testFind() throws RemoteException {
    	BarcodeAndState bar=new BarcodeAndState("0123456789",GoodsState.COMPLETE);
    	BarcodeAndState bar2=new BarcodeAndState("0123456790",GoodsState.COMPLETE);
    	BarcodeAndState bar3=new BarcodeAndState("0123456790",GoodsState.COMPLETE);
		ArrayList<BarcodeAndState> BarcodeAndStates=new ArrayList<BarcodeAndState> ();
		BarcodeAndStates.add(bar);
		BarcodeAndStates.add(bar2);
		BarcodeAndStates.add(bar3);
    	MockArrivalNoteOnTransit mock = new MockArrivalNoteOnTransit(
    			"025100201510200000001","025100","2011-11-11","北京",BarcodeAndStates);
    	service.insert(mock);
    	ArrayList<ArrivalNoteOnTransitPO> find = service.find(new MockArrivalNoteOnTransit(
    			"025100201510200000001", null, null, null, null));
        ArrivalNoteOnTransitPO findMock = find.get(0);
    	//assertEquals(find.size(),1);
    	//assertEquals(findMock.getCenterNumber(),"025100");
    	//assertEquals(findMock.getDeparturePlace(),"北京");
    }

    @Test
    public void testFindAll() throws RemoteException {
    	BarcodeAndState bar=new BarcodeAndState("0123456790",GoodsState.COMPLETE);
		ArrayList<BarcodeAndState> BarcodeAndStates=new ArrayList<BarcodeAndState> ();
		BarcodeAndStates.add(bar);
    	MockArrivalNoteOnTransit mock = new MockArrivalNoteOnTransit(
    			"025100201510200000001","025100","2011-11-11","北京",BarcodeAndStates);
    	MockArrivalNoteOnTransit mock2 = new MockArrivalNoteOnTransit(
    			"025100201510200000002","025100","2011-12-2","北京",BarcodeAndStates);
    	service.insert(mock);
    	service.insert(mock2);
    	//assertEquals(true,service.findAll().size()>=2);
    }
}
