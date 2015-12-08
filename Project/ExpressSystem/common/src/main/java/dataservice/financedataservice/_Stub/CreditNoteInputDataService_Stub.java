package dataservice.financedataservice._Stub;
/**
 * @author wwz
 * @data 2015-10-22
 */
import java.rmi.RemoteException;

import dataservice.financedataservice.CreditNoteInputDataService;
import dataservice.exception.FailToPassApprovingException;
import po.CreditNotePO;

public class CreditNoteInputDataService_Stub implements CreditNoteInputDataService {
	
	public boolean addCreditNote(CreditNotePO note, String staffID) throws RemoteException,FailToPassApprovingException { 
		System.out.println("add credit note success");
		return true;
	}

	@Override
	public double getOrderMoney(String barcodes) throws RemoteException {
		return 0;
	}

}
