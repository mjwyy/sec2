package businesslogicservice.financeblservice._stub;

import po.CreditNotePO;
import vo.CreditNoteVO;
import businesslogicservice.financeblservice.CreditNoteInputBLService;
import util.ResultMsg;

public class CreditNoteInputBLService_Stub implements
		CreditNoteInputBLService {

	public CreditNoteInputBLService_Stub() {
		
	}

	public ResultMsg addReceipeDoc(CreditNoteVO vo) {
		 ResultMsg msg = vo.checkFormat();
	        if(!msg.isPass()) return msg;
	        else return submitReceipeDoc(vo);	
	        }

	public ResultMsg submitReceipeDoc(CreditNoteVO vo) {

    	
        return new ResultMsg(true);
	}

}
