package dataservice.financedataservice;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

import dataservice.exception.FailToPassApprovingException;
import po.CreditNotePO;

/**
* @author River
*/
public interface CreditNoteInputDataService extends Remote, Serializable {

	/**
	 * Data向数据库中添加记录
	 * @param staffID TODO
	 *
	 * @return true for successful add operation
	 * @throws RemoteException
	 */
	public boolean addCreditNote(CreditNotePO note, String staffID)
			throws RemoteException,FailToPassApprovingException;
	
	/**
	 * 获取单件快件的金额
	 * 
	 * @param barcode
	 * @return
	 * @throws RemoteException
	 */
	public double getOrderMoney(String barcode) throws RemoteException;
}
