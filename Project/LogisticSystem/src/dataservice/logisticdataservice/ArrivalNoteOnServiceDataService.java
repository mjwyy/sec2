<<<<<<< HEAD
/**
 * 处理营业厅到达件数据接口
 * @author wqy
 * @date 2015/10/17
 */
package dataservice.logisticdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.ArrivalNoteOnServicePO;


public interface ArrivalNoteOnServiceDataService {
	/**
	 * 在数据库中插入单一持久化对象
	 */
	public void insert(ArrivalNoteOnServicePO po) throws RemoteException;
	/**
	 * 在数据库中删除单一持久化对象
	 */
	public void delete(ArrivalNoteOnServicePO po) throws RemoteException;
	/**
	 * 在数据库中更新单一持久化对象
	 */
	public void update(ArrivalNoteOnServicePO po) throws RemoteException;
	/**
	 * 按关键字进行查找返回相应的ArrivalNoteOnServicePO结果
	 */
	public ArrayList<ArrivalNoteOnServicePO> find(String name) throws RemoteException;

	
	/**
	 * 返回所有的营业厅到达单PO
	 */
	public ArrayList<ArrivalNoteOnServicePO> findAll() throws RemoteException;
}
=======
/**
 * 处理营业厅到达件数据接口
 * @author wqy
 * @date 2015/10/17
 */
package dataservice.logisticdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.ArrivalNoteOnServicePO;


public interface ArrivalNoteOnServiceDataService {
	/**
	 * 前置条件：同样ID的po在Mapper中不存在
	 * 后置条件：在数据库中增加一个po记录
	 * @param po 库存po
	 */
	public void insert(ArrivalNoteOnServicePO po) throws RemoteException;
	/**
	 * 前置条件：同样ID的po在Mapper中存在
	 * 后置条件：在数据库中删除一个po记录
	 * @param po 库存po
	 */
	public void delete(ArrivalNoteOnServicePO po) throws RemoteException;
	/**
	 * 前置条件：同样ID的po在Mapper中存在
	 * 后置条件：在数据库中更新一个po记录
	 * @param po 库存po
	 */
	public void update(ArrivalNoteOnServicePO po) throws RemoteException;
	/**
	 * 前置条件：无
	 * 后置条件：按名字进行查找返回相应的NotePO结果
	 * @param name 库存名字
	 * @return NotePO 库存PO
	 */
	public ArrivalNoteOnServicePO findByName(String name) throws RemoteException;

	/**
	 * 前置条件：无
	 * 后置条件：返回所有的库存PO
	 * @return NotePO 库存PO
	 */
	public ArrayList<ArrivalNoteOnServicePO> show() throws RemoteException;
}
>>>>>>> parent of 2d8eb69... 10.22这个世界没有锟斤拷版本
