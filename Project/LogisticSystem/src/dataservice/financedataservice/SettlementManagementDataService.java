package dataservice.financedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.IncomeNotePO;

public interface SettlementManagementDataService extends Remote {
	/**
	 * ǰ��������IncomeNotePO�Ѿ�������飬��ʽ����
	 * ����������Data�������տ��¼���޸Ķ�Ӧ�˻���Ϣ
	 * @return
	 * @throws RemoteException
	 */
	public boolean addIncomeNote(IncomeNotePO note) 
			throws RemoteException;
}
