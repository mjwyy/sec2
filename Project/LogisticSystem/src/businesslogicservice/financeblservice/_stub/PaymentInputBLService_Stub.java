package businesslogicservice.financeblservice._stub;

import vo.PaymentVO;
import businesslogic.util.ResultMsg;
import businesslogicservice.financeblservice.PaymentInputBLService;

public class PaymentInputBLService_Stub implements PaymentInputBLService {

	@Override
	public ResultMsg addPaymentRecord(PaymentVO vo) {
		System.out.println("Payment added!");
		return new ResultMsg(true, "Success!");
	}

	@Override
	public ResultMsg submitPaymentRecord(PaymentVO vo) {
		return null;
	}

}
