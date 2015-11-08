package dataImpl.statisticdata;

import java.rmi.RemoteException;

import po.OrderPO;
import dataservice.exception.ElementNotFoundException;
import dataservice.statisticdataservice.OrderInquiryDataService;

public class OrderInquirydata implements OrderInquiryDataService {

	@Override
	public OrderPO findOrder(String barcode) throws RemoteException,
			ElementNotFoundException {
		
		return null;
	}
	

}
