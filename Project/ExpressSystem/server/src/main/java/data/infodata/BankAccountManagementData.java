package data.infodata;

import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import dataservice.infodataservice.BankAccountManagementDataService;
import po.BankAccountPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/11/16.
 */
public class BankAccountManagementData implements BankAccountManagementDataService{
    @Override
    public boolean addBankAccount(BankAccountPO account) throws RemoteException, InterruptWithExistedElementException {
        return false;
    }

    @Override
    public boolean removeBankAccount(BankAccountPO account) throws RemoteException, ElementNotFoundException {
        return false;
    }


    @Override
    public ArrayList<BankAccountPO> findBankAccount(BankAccountPO accountInfo) throws RemoteException, ElementNotFoundException {
        return null;
    }

    @Override
    public ArrayList<BankAccountPO> getAllAccounts() throws RemoteException {
        return null;
    }

	@Override
	public boolean modifyBankAccount(BankAccountPO account)
			throws RemoteException, ElementNotFoundException,
			InterruptWithExistedElementException {
		return false;
	}
}
