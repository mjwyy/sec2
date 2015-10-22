package dataservice.statisticdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import dataservice.util.exception.ElementNotFoundException;
import po.OrderVO;

public interface OrderInquiryDataService extends Remote {

	/**
	 * ǰ��������Barcode�Ѿ����ʽ���
	 * ����������Data����ж������Ҳ�������Ϣ
	 * @param barcode
	 * @return
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 */
	public OrderVO findOrder(String barcode)
		throws RemoteException, ElementNotFoundException;
	
}
