package dataservice.financedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.IncomeNotePO;

public interface SettlementManagementDataService extends Remote {
	/**
<<<<<<< HEAD
	 * Data层增加收款单记录，修改对应账户信息
	 *
=======
	 * ǰ��������IncomeNotePO�Ѿ�������飬��ʽ����
	 * ����������Data�������տ��¼���޸Ķ�Ӧ�˻���Ϣ
>>>>>>> master
	 * @return
	 * @throws RemoteException
	 */
	public boolean addIncomeNote(IncomeNotePO note) 
			throws RemoteException;
}
