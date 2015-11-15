package data.financedata;

import java.rmi.RemoteException;

import po.CreditNotePO;
import dataservice.exception.FailToPassApprovingException;
import dataservice.financedataservice.CreditNoteInputDataService;

public class CreditNoteInputData implements CreditNoteInputDataService{

	@Override
	public boolean addCreditNote(CreditNotePO note) throws RemoteException,
			FailToPassApprovingException {
		return false;
	}

}
