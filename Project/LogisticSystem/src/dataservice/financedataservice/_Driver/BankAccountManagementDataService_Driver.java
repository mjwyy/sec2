package dataservice.financedataservice._Driver;
/**
 * @author wwz
 * @data 2015-10-22
 */
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.financedataservice.BankAccountManagementDataService;
import dataservice.financedataservice._Stub.BankAccountManagementDataService_Stub;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import po.BankAccountPO;

public class BankAccountManagementDataService_Driver {
	private BankAccountPO bankAccountPO;
	private BankAccountPO bankAccountPO1;
	
	public BankAccountManagementDataService_Driver() {
		BigDecimal b = new BigDecimal(2000);
		bankAccountPO = new BankAccountPO("金三胖","12344567890",b);
		bankAccountPO1 = new BankAccountPO("金二胖","12344567890",b);
	}
	
	public void drive(BankAccountManagementDataService bankAccountManagementDataService)
	throws RemoteException, InterruptWithExistedElementException, ElementNotFoundException{
		bankAccountManagementDataService.addBankAccount(bankAccountPO);
		bankAccountManagementDataService.removeBankAccount(bankAccountPO);
		bankAccountManagementDataService.findBankAccount(new BankAccountPO("Mark", null, null));
		bankAccountManagementDataService.modifyBankAccount(bankAccountPO,bankAccountPO1 );
		bankAccountManagementDataService.getAllAccounts();
	}
	
	public static void main(String[] args) throws RemoteException, InterruptWithExistedElementException, ElementNotFoundException{
		 BankAccountManagementDataService_Stub bankAccountManagementDataService_Stub = new BankAccountManagementDataService_Stub();
         BankAccountManagementDataService_Driver  bankAccountManagementDataService_Driver = new BankAccountManagementDataService_Driver();
	     
         bankAccountManagementDataService_Driver.drive(bankAccountManagementDataService_Stub);
	}

}
