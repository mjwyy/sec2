package dataservice.financedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.PaymentPO;
import dataservice.data_service_exception.FailToPassApprovingException;

public interface PaymentInputDataService extends Remote {
	
	/**
	 * 前置条件：PaymentPO格式已经过检查，确认无误
	 * 后置条件：Data层向数据记录Payment信息，并修改对应银行账户信息
	 * @return true for successful add operation
	 * @throws RemoteException
	 * @throws FailToPassApprovingException
	 */
	public boolean addPayment(PaymentPO payment)
			throws RemoteException, FailToPassApprovingException;
}
