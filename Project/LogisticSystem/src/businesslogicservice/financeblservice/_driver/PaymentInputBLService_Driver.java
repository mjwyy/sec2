package businesslogicservice.financeblservice._driver;

import vo.PaymentRecordVO;
import businesslogic.util.ResultMsg;
import businesslogicservice.financeblservice.PaymentInputBLService;

public class PaymentInputBLService_Driver {

	public void drive(PaymentInputBLService service){
		service.addPaymentRecord(new PaymentRecordVO("2015-07-21", "30.4", null, null, null));
		service.submitPaymentRecord(new PaymentRecordVO("2015-07-21", "30.4", null, null, null));
	}

}
