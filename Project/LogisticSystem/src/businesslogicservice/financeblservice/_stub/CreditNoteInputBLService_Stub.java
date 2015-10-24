package businesslogicservice.financeblservice._stub;

import java.util.ArrayList;

import vo.ReceipeVO;
import businesslogic.util.ResultMsg;
import businesslogicservice.financeblservice.CreditNoteInputBLService;

public class CreditNoteInputBLService_Stub implements
		CreditNoteInputBLService {

	public CreditNoteInputBLService_Stub() {
		
	}


	@Override
	public ResultMsg addReceipeDoc(ReceipeVO vo) {
		System.out.println("added doc");
		return new ResultMsg(true, null);
	}

	@Override
	public ResultMsg submitReceipeDoc(ReceipeVO vo) {
		System.out.println("submitted");
		return new ResultMsg(true, null);
	}
	
	

}
