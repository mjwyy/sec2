package data.statisticdata.MockObject;

import java.util.ArrayList;

import po.OrderPO;

public class MockOrderInquiry extends OrderPO{
    
	private static final long serialVersionUID = 1L;
	
	private String barcode;

	public MockOrderInquiry(String barcode, String stateOfTransport,
			ArrayList<String> history) {
		super(barcode,stateOfTransport,history);
	}
	
	public String getBarcode(){
		return barcode;
	}

}
