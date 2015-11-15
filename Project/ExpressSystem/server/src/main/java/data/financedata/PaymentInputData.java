package data.financedata;

import java.rmi.RemoteException;

import po.PaymentPO;
import dataservice.exception.FailToPassApprovingException;
import dataservice.financedataservice.PaymentInputDataService;

public class PaymentInputData implements PaymentInputDataService{

	@Override
	public boolean addPayment(PaymentPO payment) throws RemoteException,
			FailToPassApprovingException {
		return false;
	}

}
