package businesslogicservice.financeblservice._stub;

import vo.CreditNoteVO;
import businesslogicservice.financeblservice.CreditNoteInputBLService;
import util.ResultMsg;

public class CreditNoteInputBLService_Stub implements
		CreditNoteInputBLService {

	public CreditNoteInputBLService_Stub() {
		
	}

	public ResultMsg addReceipeDoc(CreditNoteVO vo) {
		ResultMsg msg = vo.checkFormat();
        return msg;
	}

	public ResultMsg submitReceipeDoc(CreditNoteVO vo) {
		return null;
	}

}
