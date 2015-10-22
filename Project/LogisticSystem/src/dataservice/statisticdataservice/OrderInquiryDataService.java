package dataservice.statisticdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import dataservice.util.exception.ElementNotFoundException;
import po.OrderVO;

public interface OrderInquiryDataService extends Remote {

	/**
	 * Data返回对应单据的OrderVO
	 *
	 * @param barcode
	 * @return
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 */
	public OrderVO findOrder(String barcode)
		throws RemoteException, ElementNotFoundException;
	
}
