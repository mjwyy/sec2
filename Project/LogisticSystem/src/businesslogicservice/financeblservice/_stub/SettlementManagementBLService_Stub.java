package businesslogicservice.financeblservice._stub;

import java.util.ArrayList;

import vo.IncomeNoteVO;
import businesslogic.util.ResultMsg;
import businesslogicservice.financeblservice.SettlementManagementBLService;

public class SettlementManagementBLService_Stub implements
		SettlementManagementBLService {

	@Override
	public ResultMsg addReceiveRecord(IncomeNoteVO vo) {
		System.out.println("ReceiveRecord added!");
		return new ResultMsg(true, "Success!");
	}


	@Override
	public ArrayList<IncomeNoteVO> find(IncomeNoteVO vo) {
		
		System.out.println("found ");
		return new ArrayList<>();
	}


}
