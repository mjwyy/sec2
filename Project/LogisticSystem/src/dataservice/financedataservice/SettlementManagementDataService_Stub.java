package dataservice.financedataservice;
/**
 * @author wwz
 * @data 2015-10-22
 */
import java.rmi.RemoteException;

import po.IncomeNotePO;

public class SettlementManagementDataService_Stub implements SettlementManagementDataService {

	@Override
	public boolean addIncomeNote(IncomeNotePO note) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("add income note sucess");
		return true;
	}

}
