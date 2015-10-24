package businesslogicservice.financeblservice._stub;

import java.util.ArrayList;

import vo.ReceiveRecordVO;
import businesslogic.util.ResultMsg;
import businesslogicservice.financeblservice.SettlementManagementBLService;

public class SettlementManagementBLService_Stub implements
		SettlementManagementBLService {

	@Override
	public ResultMsg addReceiveRecord(ReceiveRecordVO vo) {
		System.out.println("ReceiveRecord added!");
		return new ResultMsg(true, "Success!");
	}


	@Override
	public ArrayList<ReceiveRecordVO> findbydate(String date) {
		
		System.out.println("found by date");
		return new ArrayList<>();
	}

	@Override
	public ArrayList<ReceiveRecordVO> findbyServic(String serive) {
		return null;
	}
}
