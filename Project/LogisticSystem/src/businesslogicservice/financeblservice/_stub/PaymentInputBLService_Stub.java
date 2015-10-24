package businesslogicservice.financeblservice._stub;

import vo.StorageInVO;
import businesslogic.util.ResultMsg;
import businesslogicservice.financeblservice.PaymentInputBLService;

public class PaymentInputBLService_Stub implements PaymentInputBLService {

	@Override
	public ResultMsg addPaymentRecord(StorageInVO vo) {
		System.out.println("Payment added!");
		return new ResultMsg(true, "Success!");
	}


}
