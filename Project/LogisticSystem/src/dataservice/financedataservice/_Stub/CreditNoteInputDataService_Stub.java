package dataservice.financedataservice._Stub;
/**
 * @author wwz
 * @data 2015-10-22
 */
import java.math.BigDecimal;
import java.rmi.RemoteException;

import dataservice.financedataservice.CreditNoteInputDataService;
import dataservice.util.exception.FailToPassApprovingException;
import po.CreditNotePO;

public class CreditNoteInputDataService_Stub implements CreditNoteInputDataService {
	private CreditNotePO creditNotePO;
	
	@Override
	public boolean addCreditNote(CreditNotePO note) throws RemoteException,FailToPassApprovingException { 
		System.out.println("add credit note success");
		return true;
	}

}
