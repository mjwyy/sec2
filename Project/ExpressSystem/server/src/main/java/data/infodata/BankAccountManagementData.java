package data.infodata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.BankAccountPO;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import dataservice.infodataservice.BankAccountManagementDataService;

public class BankAccountManagementData implements BankAccountManagementDataService{

	@Override
	public boolean addBankAccount(BankAccountPO account)
			throws RemoteException, InterruptWithExistedElementException {
		
		
		return false;
	}

	@Override
	public boolean removeBankAccount(BankAccountPO account)
			throws RemoteException, ElementNotFoundException {
		return false;
	}

	@Override
	public boolean modifyBankAccount(BankAccountPO originalAccount,
			BankAccountPO modifiedAccount) throws RemoteException,
			ElementNotFoundException, InterruptWithExistedElementException {
		return false;
	}

	@Override
	public ArrayList<BankAccountPO> findBankAccount(BankAccountPO accountInfo)
			throws RemoteException, ElementNotFoundException {
		return null;
	}

	@Override
	public ArrayList<BankAccountPO> getAllAccounts() throws RemoteException {
		return null;
	}

}
