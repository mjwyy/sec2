package businesslogicservice.financeblservice._stub;

import java.util.ArrayList;

import vo.AccountVO;
import businesslogic.util.ResultMsg;
import businesslogicservice.financeblservice.BankAccountManagementBLService;

public class CreditNoteInputBLService_Stub implements
		BankAccountManagementBLService {

	public CreditNoteInputBLService_Stub() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public ArrayList<AccountVO> find(String name) {
		// TODO Auto-generated method stub
		System.out.println("≤È’“¡À...");
		return new ArrayList<AccountVO>();
	}

	@Override
	public ResultMsg add(AccountVO vo) {
		// TODO Auto-generated method stub
		System.out.println("added!");
		return new ResultMsg(true, "Success!");
	}

	@Override
	public ResultMsg delete(AccountVO vo) {
		// TODO Auto-generated method stub
		System.out.println("deleted account");
		return new ResultMsg(true, "Success!");
	}

	@Override
	public ResultMsg update(AccountVO vo) {
		// TODO Auto-generated method stub
		System.out.println("updated data");
		return new ResultMsg(true, "Success!");
	}

	@Override
	public ArrayList<AccountVO> show() {
		// TODO Auto-generated method stub
		System.out.println("get data");
		return new ArrayList<AccountVO>();
	}

}
