package businesslogicservice.financeblservice._driver;

import java.util.ArrayList;

import vo.ReceiveRecordVO;
import businesslogic.util.ResultMsg;
import businesslogicservice.financeblservice.SettlementManagementBLService;

public class SettlementManagementBLService_Driver {

	public void drive(SettlementManagementBLService service){
		service.addReceiveRecord(new ReceiveRecordVO("110", "2013-05-12", null, null, null, null));
		service.findbydate("2013-05-12");
		service.findbyService("ser");
		service.submitReceiveRecord(new ReceiveRecordVO("110", "2013-05-12", null, null, null, null));
	}
}
