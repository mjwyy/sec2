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

    //疑问，测试方法有无顺序，如果没有顺序，直接删除、修改报错。有顺序可否
    //在构造器内先添加几个单据可否
    
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
    	service.insert(mock);
    	int numbers = service.findAll().size();
    	assertEquals(numbers,1);
    	MockArrivalNoteOnTransit mock2 = new MockArrivalNoteOnTransit(
    			"025100201510200000002","025100","2011-11-13","北京",BarcodeAndStates);
    	service.insert(mock2);
    	numbers = service.findAll().size();
    	assertEquals(numbers,2);
    }

    @Test
    public void testDelete() throws RemoteException {
    	BarcodeAndState bar=new BarcodeAndState("0123456789",GoodsState.COMPLETE);
		ArrayList<BarcodeAndState> BarcodeAndStates=new ArrayList<BarcodeAndState> ();
		BarcodeAndStates.add(bar);
    	MockArrivalNoteOnTransit mock = new MockArrivalNoteOnTransit(
    			"025100201510200000001","025100","2011-11-11","北京",BarcodeAndStates);
    	service.delete(mock);
    	int numbers = service.findAll().size();
    	assertEquals(numbers,1);
    }

    @Test
    public void testUpdate() throws RemoteException {
    	BarcodeAndState bar=new BarcodeAndState("0123456789",GoodsState.COMPLETE);
		ArrayList<BarcodeAndState> BarcodeAndStates=new ArrayList<BarcodeAndState> ();
		BarcodeAndStates.add(bar);
    	MockArrivalNoteOnTransit mock = new MockArrivalNoteOnTransit(
    			"025100201510200000001","025100","2020-11-11","厦门",BarcodeAndStates);
    	service.update(mock);
    	// 疑问，更新的时候，怎么检查，需要调用FIND
    	ArrayList<ArrivalNoteOnTransitPO> find = service.find(new MockArrivalNoteOnTransit(
    			"025100201510200000001", null, null, null, null));
    	MockArrivalNoteOnTransit findMock = (MockArrivalNoteOnTransit) find.get(0);
    	assertEquals(find.size(),1);
    	assertEquals(findMock.getCenterNumber(),"025100");
    	assertEquals(findMock.getDeparturePlace(),"厦门");
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
    	//先增加再find是否可行
    	service.insert(mock);
    	ArrayList<ArrivalNoteOnTransitPO> find = service.find(new MockArrivalNoteOnTransit(
    			"025100201510200000001", null, null, null, null));
    	MockArrivalNoteOnTransit findMock = (MockArrivalNoteOnTransit) find.get(0);
    	assertEquals(find.size(),1);
    	assertEquals(findMock.getCenterNumber(),"025100");
    	assertEquals(findMock.getDeparturePlace(),"北京");
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
    	ArrayList<ArrivalNoteOnTransitPO> find = service.findAll();
    	assertEquals(find.size(),2);
    }
}
