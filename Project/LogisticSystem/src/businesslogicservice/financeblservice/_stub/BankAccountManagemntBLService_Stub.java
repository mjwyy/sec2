package businesslogicservice.financeblservice._stub;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import po.BankAccountPO;
import dataservice.financedataservice.BankAccountManagementDataService;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import vo.AccountVO;
import businesslogic.util.ResultMsg;
import businesslogicservice.financeblservice.BankAccountManagementBLService;

public class BankAccountManagemntBLService_Stub implements
		BankAccountManagementBLService {

	BankAccountManagementDataService data = null;
	
	public BankAccountManagemntBLService_Stub() {
	}
	
	public BankAccountManagemntBLService_Stub(BankAccountManagementDataService data) {
		this();
		this.data = data;
	}
	
	
	@Override
	public ArrayList<AccountVO> find(String name) {
		
		BankAccountPO ac = new BankAccountPO(name, null, null);
		BankAccountPO result;
		ArrayList<AccountVO> list = new ArrayList<AccountVO>();
		
		
		return list;
	}

	@Override
	public ResultMsg add(AccountVO vo) {
		
		ResultMsg result = null;
		
		
		return result;
	}

	@Override
	public ResultMsg delete(AccountVO vo) {
		
		return new ResultMsg(true, "Success!");
	}

	@Override
	public ResultMsg update(AccountVO vo) {
		
		return new ResultMsg(true, "Success!");
	}

	@Override
	public ArrayList<AccountVO> show() {
		
		ArrayList<AccountVO> list = new ArrayList<>();
		ArrayList<BankAccountPO> get = null;
		
		
		
		return list;
	}
	


}
