/**
 * 发送中转单数据接口
 * @author wqy
 * @date 2015/10/17
 */
package dataservice.logisticdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.TransitNoteInputPO;

public interface TransitNoteInputDataService {
	/**
	 * 在数据库中增加一个po记录
	 */
	public void insert(TransitNoteInputPO po) throws RemoteException;
	/**
	 * 在数据库中删除一个po记录
	 */
	public void delete(TransitNoteInputPO po) throws RemoteException;
	/**
	 * 在数据库中更新一个po记录
	 */
	public void update(TransitNoteInputPO po) throws RemoteException;
	/**
	 * 查找返回相应的TransitNoteInputPO结果
	 */
	public ArrayList<TransitNoteInputPO> find(String name) throws RemoteException;
	
	
	/**
	 * 返回所有的TransitNoteInputPO
	 */
	public ArrayList<TransitNoteInputPO> findAll() throws RemoteException;
}