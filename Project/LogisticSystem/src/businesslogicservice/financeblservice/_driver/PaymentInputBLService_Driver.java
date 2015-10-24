package businesslogicservice.financeblservice._driver;

import vo.GoodsVO;
import vo.StorageInVO;
import businesslogicservice.financeblservice.PaymentInputBLService;

import java.util.ArrayList;
import java.util.Date;

public class PaymentInputBLService_Driver {

	public void drive(PaymentInputBLService service){
		service.addPaymentRecord(new StorageInVO("2015-10-22",new ArrayList<GoodsVO>() ));
	}

}
