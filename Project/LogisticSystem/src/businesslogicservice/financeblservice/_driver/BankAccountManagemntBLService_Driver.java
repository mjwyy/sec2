package businesslogicservice.financeblservice._driver;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import po.BankAccountPO;
import dataservice.financedataservice.BankAccountManagementDataService;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import vo.AccountVO;
import businesslogic.util.ResultMsg;
import businesslogicservice.financeblservice.BankAccountManagementBLService;

public class BankAccountManagemntBLService_Driver  {

	public void drive(BankAccountManagementBLService service){
		service.add(new AccountVO("sd", "1234567", 1.50));
		service.delete(new AccountVO("sd", "1234567", 1.50));
		service.find("sd");
		service.show();
		service.update(new AccountVO("sd", "1234567", 1.50));
	}
	
}
