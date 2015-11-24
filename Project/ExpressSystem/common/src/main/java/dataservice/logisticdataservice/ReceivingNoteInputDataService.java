/**
 * 输入寄件单信息数据接口
 * @author wqy
 * @date 2015/10/17
 */
package dataservice.logisticdataservice;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.ReceivingNotePO;

public interface ReceivingNoteInputDataService extends Remote, Serializable {
	/**
	 * 在数据库中增加一个po记录
	 */
	public boolean insert(ReceivingNotePO po) throws RemoteException;

	/**
	 * 查找返回相应的ReceivingNoteInputPO结果
	 */
	public ArrayList<ReceivingNotePO> find(ReceivingNotePO po) throws RemoteException;
	
	
	/**
	 * 返回所有的ReceivingNoteInputPO
	 */
	public ArrayList<ReceivingNotePO> findAll() throws RemoteException;
}