package businesslogicservice.financeblservice._stub;

import vo.PaymentRecordVO;
import businesslogic.util.ResultMsg;
import businesslogicservice.financeblservice.PaymentInputBLService;

public class PaymentInputBLService_Stub implements PaymentInputBLService {

	@Override
	public ResultMsg addPaymentRecord(PaymentRecordVO vo) {
		// TODO Auto-generated method stub
		System.out.println("Payment added!");
		return new ResultMsg(true, "Success!");
	}

	@Override
	public ResultMsg submitPaymentRecord(PaymentRecordVO vo) {
		// TODO Auto-generated method stub
		System.out.println("Submitted payment");
		return new ResultMsg(true, "Success!");
	}

}
