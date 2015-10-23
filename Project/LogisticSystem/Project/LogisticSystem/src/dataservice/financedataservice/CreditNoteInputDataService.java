package dataservice.financedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import dataservice.util.exception.FailToPassApprovingException;
import po.CreditNotePO;

public interface CreditNoteInputDataService extends Remote {

	/**
	 * ǰ��������CreditNotePO��������ݾ����˸�ʽ��飬ȷ������
	 * ����������Data���¼������ݣ����޸Ķ�Ӧ�������˻���Ϣ
	 * @return true for successful add operation
	 * @throws RemoteException
	 */
	public boolean addCreditNote(CreditNotePO note)
			throws RemoteException,FailToPassApprovingException;
	
}
