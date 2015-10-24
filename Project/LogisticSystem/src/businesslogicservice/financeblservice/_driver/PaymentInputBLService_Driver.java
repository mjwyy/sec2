package businesslogicservice.financeblservice._driver;

import businesslogicservice.financeblservice.PaymentInputBLService;
import vo.PaymentRecordVO;

public class PaymentInputBLService_Driver {

	public void drive(PaymentInputBLService service){
		service.addPaymentRecord(new PaymentRecordVO(null, null, null, null, null));
	}

}
