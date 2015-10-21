package dataservice.financedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.IncomeNotePO;

public interface SettlementManagementDataService extends Remote {
	/**
	 * 前置条件：IncomeNotePO已经经过检查，格式无误
	 * 后置条件：Data层增加收款单记录，修改对应账户信息
	 * @return
	 * @throws RemoteException
	 */
	public boolean addIncomeNote(IncomeNotePO note) 
			throws RemoteException;
}
