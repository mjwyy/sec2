package businesslogicservice.financeblservice._stub;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import po.BankAccountPO;
import dataservice.financedataservice.BankAccountManagementDataService;
import dataservice.util.exception.ElementNotFoundException;
import dataservice.util.exception.InterruptWithExistedElementException;
import vo.AccountVO;
import businesslogic.util.ResultMsg;
import businesslogicservice.financeblservice.BankAccountManagementBLService;

public class BankAccountManagemntBLService_Stub implements
		BankAccountManagementBLService {

	BankAccountManagementDataService data = null;
	
	public BankAccountManagemntBLService_Stub() {
		// TODO Auto-generated constructor stub
	}
	
	public BankAccountManagemntBLService_Stub(BankAccountManagementDataService data) {
		// TODO Auto-generated constructor stub
		this();
		this.data = data;
	}
	
	
	@Override
	public ArrayList<AccountVO> find(String name) {
		// TODO Auto-generated method stub
		BankAccountPO ac = new BankAccountPO(name, null, null);
		BankAccountPO result;
		ArrayList<AccountVO> list = new ArrayList<AccountVO>();
		try {
			result = data.findBankAccount(ac);
			list.add(new AccountVO(result.getName(), result.getNumber(), result.getBalance().doubleValue()));
		} catch (ElementNotFoundException e) {
			System.out.println("账户未找到");
		} catch (RemoteException e) {
			System.out.println("未知远程错误");
		}
		
		return list;
	}

	@Override
	public ResultMsg add(AccountVO vo) {
		// TODO Auto-generated method stub
		ResultMsg result = null;
		try {
			data.addBankAccount(new BankAccountPO(vo.getName(), vo.getAccount(), new BigDecimal(vo.getBalance())));
			result = new ResultMsg(true, "添加成功");
		} catch (InterruptWithExistedElementException e) {
			result = new ResultMsg(false, "账户已存在");
		} catch (RemoteException e) {
			result = new ResultMsg(false, "发生未知错误，添加失败");
		}
		
		return result;
	}

	@Override
	public ResultMsg delete(AccountVO vo) {
		// TODO Auto-generated method stub
		return new ResultMsg(true, "Success!");
	}

	@Override
	public ResultMsg update(AccountVO vo) {
		// TODO Auto-generated method stub
		return new ResultMsg(true, "Success!");
	}

	@Override
	public ArrayList<AccountVO> show() {
		// TODO Auto-generated method stub
		ArrayList<AccountVO> list = new ArrayList<>();
		ArrayList<BankAccountPO> get = null;
		try {
			get = data.getAllAccounts();
		} catch (RemoteException e) {
			return null;
		}
		
		
		return list;
	}
	


}
