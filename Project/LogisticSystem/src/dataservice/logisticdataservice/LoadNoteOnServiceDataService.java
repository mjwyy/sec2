<<<<<<< HEAD
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
=======
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
	 * @param po 库存po
	 */
	public void insert(LoadNoteOnServicePO po) throws RemoteException;
	/**
	 * 前置条件：同样ID的po在Mapper中存在
	 * 后置条件：在数据库中删除一个po记录
	 * @param po 库存po
	 */
	public void delete(LoadNoteOnServicePO po) throws RemoteException;
	/**
	 * 前置条件：同样ID的po在Mapper中存在
	 * 后置条件：在数据库中更新一个po记录
	 * @param po 库存po
	 */
	public void update(LoadNoteOnServicePO po) throws RemoteException;
	/**
	 * 前置条件：无
	 * 后置条件：按名字进行查找返回相应的LoadNoteOnServicePO结果
	 * @param name 库存名字
	 * @return LoadNoteOnServicePO 库存PO
	 */
	public LoadNoteOnServicePO findByName(String name) throws RemoteException;

	/**
	 * 前置条件：无
	 * 后置条件：返回所有的库存PO
	 * @return LoadNoteOnServicePO 库存PO
	 */
	public ArrayList<LoadNoteOnServicePO> show() throws RemoteException;
>>>>>>> parent of 2d8eb69... 10.22这个世界没有锟斤拷版本
}