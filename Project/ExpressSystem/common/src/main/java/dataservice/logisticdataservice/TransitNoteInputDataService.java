/**
 * 发送中转单数据接口
 * @author wqy
 * @date 2015/10/17
 */
package dataservice.logisticdataservice;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.TransitNotePO;

public interface TransitNoteInputDataService extends Remote, Serializable {
	/**
	 * 在数据库中增加一个po记录
	 */
	public boolean insert(TransitNotePO po) throws RemoteException;

	/**
	 * 查找返回相应的TransitNoteInputPO结果
	 */
	public ArrayList<TransitNotePO> find(TransitNotePO po) throws RemoteException;
	
	/**
	 * 返回所有的TransitNoteInputPO
	 */
	public ArrayList<TransitNotePO> findAll() throws RemoteException;
}