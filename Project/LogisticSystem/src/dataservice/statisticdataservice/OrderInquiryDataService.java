package dataservice.statisticdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import dataservice.data_service_exception.ElementNotFoundException;
import po.OrderPO;

public interface OrderInquiryDataService extends Remote {

	/**
	 * ǰ��������Barcode�Ѿ����ʽ���
	 * ����������Data����ж������Ҳ�������Ϣ
	 * @param barcode
	 * @return
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 */
	public OrderPO findOrder(String barcode)
		throws RemoteException, ElementNotFoundException;
	
}
