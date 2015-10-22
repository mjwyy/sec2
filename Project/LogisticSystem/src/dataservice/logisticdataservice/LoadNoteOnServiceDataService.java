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
	 * 前置条件：同样ID的po在Mapper中不存在
	 * 后置条件：在数据库中增加一个po记录
	 * @param po LoadNoteOnServicepo
	 */
	public void insert(LoadNoteOnServicePO po) throws RemoteException;
	/**
	 * 前置条件：同样ID的po在Mapper中存在
	 * 后置条件：在数据库中删除一个po记录
	 * @param po LoadNoteOnServicepo
	 */
	public void delete(LoadNoteOnServicePO po) throws RemoteException;
	/**
	 * 前置条件：同样ID的po在Mapper中存在
	 * 后置条件：在数据库中更新一个po记录
	 * @param po LoadNoteOnServicepo
	 */
	public void update(LoadNoteOnServicePO po) throws RemoteException;
	/**
	 * 前置条件：无
	 * 后置条件：查找返回相应的LoadNoteOnServicePO结果
	 * @param name 关键字
	 * @return LoadNoteOnServicePO
	 */
	public ArrayList<LoadNoteOnServicePO> find(String name) throws RemoteException;
	
	
	/**
	 * 前置条件：无
	 * 后置条件：返回所有的LoadNoteOnServicePO
	 * @return LoadNoteOnServicePO 
	 */
	public ArrayList<LoadNoteOnServicePO> findAll() throws RemoteException;
}