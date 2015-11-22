package businesslogicservice.financeblservice._stub;

import vo.CreditNoteVO;
import businesslogicservice.financeblservice.CreditNoteInputBLService;
import util.ResultMsg;

public class CreditNoteInputBLService_Stub implements
		CreditNoteInputBLService {

	public CreditNoteInputBLService_Stub() {
		
	}

	public ResultMsg addReceipeDoc(CreditNoteVO vo) {
		// TODO Auto-generated method stub
		
		return new ResultMsg(true,"lala");
	}

	public ResultMsg submitReceipeDoc(CreditNoteVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
