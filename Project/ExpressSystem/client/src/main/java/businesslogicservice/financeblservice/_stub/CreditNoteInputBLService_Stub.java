package businesslogicservice.financeblservice._stub;

import dataservice.exception.ElementNotFoundException;
import vo.CreditNoteVO;
import businesslogicservice.financeblservice.CreditNoteInputBLService;
import util.ResultMsg;

public class CreditNoteInputBLService_Stub implements
		CreditNoteInputBLService {

	public CreditNoteInputBLService_Stub() {
		
	}

	public ResultMsg addReceipeDoc(CreditNoteVO vo) {
		return null;
	}

	public ResultMsg submitReceipeDoc(CreditNoteVO vo) {
		return null;
	}

	@Override
	public double getOrderMoney(String barcode) throws ElementNotFoundException {
		return 0;
	}

}
