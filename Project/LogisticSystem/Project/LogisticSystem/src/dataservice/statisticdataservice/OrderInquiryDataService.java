package dataservice.statisticdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import dataservice.util.exception.ElementNotFoundException;
import po.OrderPO;

public interface OrderInquiryDataService extends Remote {

	/**
	 * 前锟斤拷锟斤拷锟斤拷锟斤拷Barcode锟窖撅拷锟斤拷锟绞斤拷锟斤拷
	 * 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷Data锟斤拷锟斤拷卸锟斤拷锟斤拷锟斤拷也锟斤拷锟斤拷锟斤拷锟较�
	 * @param barcode
	 * @return
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 */
	public OrderPO findOrder(String barcode)
		throws RemoteException, ElementNotFoundException;
	
}
