/**
 * 录入营业厅装车单数据接口
 * @author wqy
 * @date 2015/10/17
 */
package dataservice.logisticdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.LoadNoteOnServicePO;

public interface LoadNoteOnServiceDataService {
	/**
	 * 在数据库中增加一个po记录
	 */
	public void insert(LoadNoteOnServicePO po) throws RemoteException;
	/**
	 * 在数据库中删除一个po记录
	 */
	public void delete(LoadNoteOnServicePO po) throws RemoteException;
	/**
	 * 在数据库中更新一个po记录
	 */
	public void update(LoadNoteOnServicePO po) throws RemoteException;
	/**
	 * 查找返回相应的LoadNoteOnServicePO结果
	 */
	public ArrayList<LoadNoteOnServicePO> find(String name) throws RemoteException;
	
	
	/**
	 * 返回所有的LoadNoteOnServicePO
	 */
	public ArrayList<LoadNoteOnServicePO> findAll() throws RemoteException;
}