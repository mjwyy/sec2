<<<<<<< HEAD
/**
 * 录入中转中心装车单数据接口
 * @author wqy
 * @date 2015/10/17
 */
package dataservice.logisticdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.LoadNoteOnTransitPO;

public interface LoadNoteOnTransitDataService {
	/**
	 * 在数据库中增加一个po记录
	 */
	public void insert(LoadNoteOnTransitPO po) throws RemoteException;
	/**
	 * 在数据库中删除一个po记录
	 */
	public void delete(LoadNoteOnTransitPO po) throws RemoteException;
	/**
	 * 在数据库中更新一个po记录
	 */
	public void update(LoadNoteOnTransitPO po) throws RemoteException;
	/**
	 * 查找返回相应的LoadNoteOnTransitPO结果
	 */
	public ArrayList<LoadNoteOnTransitPO> find(String name) throws RemoteException;
	
	
	/**
	 * 返回所有的LoadNoteOnServicePO
	 */
	public ArrayList<LoadNoteOnTransitPO> findAll() throws RemoteException;
}
=======
/**
 * 录入中转中心装车单数据接口
 * @author wqy
 * @date 2015/10/17
 */
package dataservice.logisticdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.LoadNoteOnTransitPO;

public interface LoadNoteOnTransitDataService {
	/**
	 * 前置条件：同样ID的po在Mapper中不存在
	 * 后置条件：在数据库中增加一个po记录
	 * @param po 库存po
	 */
	public void insert(LoadNoteOnTransitPO po) throws RemoteException;
	/**
	 * 前置条件：同样ID的po在Mapper中存在
	 * 后置条件：在数据库中删除一个po记录
	 * @param po 库存po
	 */
	public void delete(LoadNoteOnTransitPO po) throws RemoteException;
	/**
	 * 前置条件：同样ID的po在Mapper中存在
	 * 后置条件：在数据库中更新一个po记录
	 * @param po 库存po
	 */
	public void update(LoadNoteOnTransitPO po) throws RemoteException;
	/**
	 * 前置条件：无
	 * 后置条件：按名字进行查找返回相应的LoadNoteOnTransitPO结果
	 * @param name 库存名字
	 * @return LoadNoteOnTransitPO 库存PO
	 */
	public LoadNoteOnTransitPO findByName(String name) throws RemoteException;

	/**
	 * 前置条件：无
	 * 后置条件：返回所有的库存PO
	 * @return LoadNoteOnTransitPO 库存PO
	 */
	public ArrayList<LoadNoteOnTransitPO> show() throws RemoteException;
}
>>>>>>> parent of 2d8eb69... 10.22这个世界没有锟斤拷版本
