package dataservice.financedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.PaymentPO;
import dataservice.data_service_exception.FailToPassApprovingException;

public interface PaymentInputDataService extends Remote {
	
	/**
	 * ǰ��������PaymentPO��ʽ�Ѿ�����飬ȷ������
	 * ����������Data�������ݼ�¼Payment��Ϣ�����޸Ķ�Ӧ�����˻���Ϣ
	 * @return true for successful add operation
	 * @throws RemoteException
	 * @throws FailToPassApprovingException
	 */
	public boolean addPayment(PaymentPO payment)
			throws RemoteException, FailToPassApprovingException;
}
