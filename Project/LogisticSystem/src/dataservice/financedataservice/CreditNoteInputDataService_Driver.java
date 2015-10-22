package dataservice.financedataservice;
/**
 * @author wwz 
 * @data 2015/10/21
 */
import java.math.BigDecimal;
import java.rmi.RemoteException;

import dataservice.util.exception.FailToPassApprovingException;
import po.CreditNotePO;

public class CreditNoteInputDataService_Driver {
	
	private CreditNotePO creditNotePO;
	
	public CreditNoteInputDataService_Driver() {
		BigDecimal b = new BigDecimal(2000.50);
		creditNotePO = new CreditNotePO("2015-10-10",b,"王小二");
	}
	
	public void drive(CreditNoteInputDataService creditNoteInputDataService) throws RemoteException, FailToPassApprovingException {
		creditNoteInputDataService.addCreditNote(creditNotePO);
		//System.out.println("success");
	}
	
	public static void main(String[] args) throws RemoteException,FailToPassApprovingException {
		CreditNoteInputDataService_Stub creditNoteDataService_Stub = new CreditNoteInputDataService_Stub();
		
		CreditNoteInputDataService_Driver driver = new CreditNoteInputDataService_Driver();
		driver.drive(creditNoteDataService_Stub);
	
	}

}
