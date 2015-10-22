package dataservice.statisticdataservice;
/**
 * @author wwz
 * @data 2015/10/22
 *
 */
import java.rmi.RemoteException;

import po.OrderVO;
import dataservice.util.exception.ElementNotFoundException;

public class OrderInquiryDataService_Stub implements OrderInquiryDataService {

	@Override
	public OrderVO findOrder(String barcode) throws RemoteException,
			ElementNotFoundException {
		System.out.println("find order success");
		return null;
	}

}
