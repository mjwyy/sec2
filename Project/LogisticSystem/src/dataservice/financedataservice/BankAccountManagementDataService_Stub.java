package dataservice.financedataservice;
/**
 * @author wwz
 * @data 2015/10/21
 */
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.BankAccountPO;
import dataservice.util.exception.ElementNotFoundException;
import dataservice.util.exception.InterruptWithExistedElementException;

public class BankAccountManagementDataService_Stub implements BankAccountManagementDataService{
    private BankAccountPO bankAccountPO;

	@Override
	public boolean addBankAccount(BankAccountPO account)
			throws RemoteException, InterruptWithExistedElementException {
		System.out.println("add  bankAccount success");
		return true;
	}

	@Override
	public boolean removeBankAccount(BankAccountPO account)
			throws RemoteException, ElementNotFoundException {
		System.out.println("remove bankAccount success");
		return true;
	}

	@Override
	public boolean modifyBankAccount(BankAccountPO originalAccount,
			BankAccountPO modifiedAccount) throws RemoteException,
			ElementNotFoundException, InterruptWithExistedElementException {
		System.out.println("modify bankAccount success");
		return true;
	}

	@Override
	public BankAccountPO findBankAccount(String number)
			throws RemoteException, ElementNotFoundException {
		System.out.println("find bankAccount success");
		BigDecimal c = new BigDecimal(2000);
		BankAccountPO po = new BankAccountPO("金三胖","1234567890",c);
		return po;
	}

	@Override
	public ArrayList<BankAccountPO> getAllAccounts() throws RemoteException {
		System.out.println("show success");
		ArrayList<BankAccountPO> list = new ArrayList<BankAccountPO>();
		BigDecimal c =new BigDecimal(2000);
		
		list.add(new BankAccountPO("金三胖","1234567890",c));		
		return list;
	}
	

}
