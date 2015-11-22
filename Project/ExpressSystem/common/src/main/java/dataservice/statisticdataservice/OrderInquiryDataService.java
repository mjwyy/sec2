package dataservice.statisticdataservice;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

import dataservice.exception.ElementNotFoundException;
import po.OrderPO;

/**
* @author River
*/
public interface OrderInquiryDataService extends Remote, Serializable {

	/**
	 * Data返回对应单据的OrderPO
	 *
	 * @param barcode
	 * @return
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 */
	public OrderPO findOrder(String barcode)
		throws RemoteException, ElementNotFoundException;
	
}
