package businesslogicservice.financeblservice._driver;

import java.util.ArrayList;

import vo.AccountVO;
import vo.ReceipeVO;
import businesslogic.util.ResultMsg;
import businesslogicservice.financeblservice.BankAccountManagementBLService;
import businesslogicservice.financeblservice.CreditNoteInputBLService;

public class CreditNoteInputBLService_Driver {

	public void drive(CreditNoteInputBLService service){
		service.addReceipeDoc(new ReceipeVO("2005-02-21", "32", null, null));
		service.submitReceipeDoc(new ReceipeVO("2005-02-21", "32", null, null));
	}

}
