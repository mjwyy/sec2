package data.financedata;

import java.rmi.RemoteException;

import po.IncomeNotePO;
import dataservice.financedataservice.SettlementManagementDataService;

public class SettlementManagementData implements SettlementManagementDataService{

	@Override
	public boolean addIncomeNote(IncomeNotePO note) throws RemoteException {
		return false;
	}

}
