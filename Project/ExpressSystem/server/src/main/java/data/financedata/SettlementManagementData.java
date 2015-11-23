package data.financedata;

import dataservice.financedataservice.SettlementManagementDataService;
import po.IncomeNotePO;

import java.rmi.RemoteException;
<<<<<<< HEAD
=======
import java.util.ArrayList;
>>>>>>> master

/**
 * Created by kylin on 15/11/16.
 */
public class SettlementManagementData implements SettlementManagementDataService {
    @Override
    public boolean addIncomeNote(IncomeNotePO note) throws RemoteException {
        return false;
    }
<<<<<<< HEAD
=======

	@Override
	public ArrayList<IncomeNotePO> findAll() throws RemoteException {
		return null;
	}
>>>>>>> master
}
