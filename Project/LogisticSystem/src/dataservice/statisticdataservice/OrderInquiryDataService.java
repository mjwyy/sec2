package dataservice.statisticdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import dataservice.util.exception.ElementNotFoundException;
import po.OrderVO;

public interface OrderInquiryDataService extends Remote {

	/**
<<<<<<< HEAD
	 * Data返回对应单据的OrderVO
	 *
=======
	 * ǰ��������Barcode�Ѿ����ʽ���
	 * ����������Data����ж������Ҳ�������Ϣ
>>>>>>> master
	 * @param barcode
	 * @return
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 */
	public OrderVO findOrder(String barcode)
		throws RemoteException, ElementNotFoundException;
	
}
