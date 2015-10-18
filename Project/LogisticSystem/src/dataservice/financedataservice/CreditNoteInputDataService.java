package dataservice.financedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.CreditNotePO;
import dataservice.data_service_exception.FailToPassApprovingException;

public interface CreditNoteInputDataService extends Remote {

	/**
	 * 前置条件：CreditNotePO对象的内容经过了格式检查，确认无误
	 * 后置条件：Data层记录对象数据，并修改对应的银行账户信息
	 * @return true for successful add operation
	 * @throws RemoteException
	 */
	public boolean addCreditNote(CreditNotePO note)
			throws RemoteException,FailToPassApprovingException;
	
}
