package data.statisticdata;

import java.rmi.RemoteException;

import po.OrderPO;
import dataservice.exception.ElementNotFoundException;
import dataservice.statisticdataservice.OrderInquiryDataService;

/** 
 * @author wwz
 *@date 2015/11/14
 */
public class OrderInquiryData implements OrderInquiryDataService{

	@Override
	public OrderPO findOrder(String barcode) throws RemoteException,
			ElementNotFoundException {
		return null;
	}
	

}
