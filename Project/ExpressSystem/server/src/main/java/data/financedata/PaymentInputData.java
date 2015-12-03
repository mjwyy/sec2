package data.financedata;

import dataservice.exception.FailToPassApprovingException;
import dataservice.financedataservice.PaymentInputDataService;
import po.PaymentPO;

import java.rmi.RemoteException;
import java.sql.Connection;

/**
 * Created by kylin on 15/11/16.
 */
public class PaymentInputData implements PaymentInputDataService {
	
private Connection connection;
	
	public PaymentInputData() {
		super();
	}
	
    @Override
    public boolean addPayment(PaymentPO payment, String staffID) throws RemoteException, FailToPassApprovingException {
    	//注意首先检查余额，余额不够直接回去
    	//注意审批、修改银行账户余额
        return false;
    }
}
