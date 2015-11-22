package data.financedata;

import dataservice.financedataservice.SettlementManagementDataService;
import po.IncomeNotePO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/11/16.
 */
public class SettlementManagementData implements SettlementManagementDataService {
    @Override
    public boolean addIncomeNote(IncomeNotePO note) throws RemoteException {
        return false;
    }

	@Override
	public ArrayList<IncomeNotePO> findAll() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
}
