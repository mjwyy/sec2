<<<<<<< HEAD
/**
 * 处理中转中心到达件数据接口
 * @author wqy
 * @date 2015/10/17
 */
package dataservice.logisticdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.ArrivalNoteOnTransitPO;

public interface ArrivalNoteOnTransitDataService {
	/**
	 * 在数据库中增加一个po记录
	 */
	public void insert(ArrivalNoteOnTransitPO po) throws RemoteException;
	/**
	 * 在数据库中删除一个po记录
	 */
	public void delete(ArrivalNoteOnTransitPO po) throws RemoteException;
	/**
	 * 在数据库中更新一个po记录
	 */
	public void update(ArrivalNoteOnTransitPO po) throws RemoteException;
	/**
	 * 按关键字进行查找返回相应的ArrivalNoteOnTransitPO结果
	 */
	public ArrayList<ArrivalNoteOnTransitPO> find(String name) throws RemoteException;
	
	
	/**
	 * 返回所有的中转中心到达单PO
	 */
	public ArrayList<ArrivalNoteOnTransitPO> findAll() throws RemoteException;
=======
/**
 * 处理中转中心到达件数据接口
 * @author wqy
 * @date 2015/10/17
 */
package dataservice.logisticdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.ArrivalNoteOnTransitPO;

public interface ArrivalNoteOnTransitDataService {
	/**
	 * 前置条件：同样ID的po在Mapper中不存在
	 * 后置条件：在数据库中增加一个po记录
	 * @param po 库存po
	 */
	public void insert(ArrivalNoteOnTransitPO po) throws RemoteException;
	/**
	 * 前置条件：同样ID的po在Mapper中存在
	 * 后置条件：在数据库中删除一个po记录
	 * @param po 库存po
	 */
	public void delete(ArrivalNoteOnTransitPO po) throws RemoteException;
	/**
	 * 前置条件：同样ID的po在Mapper中存在
	 * 后置条件：在数据库中更新一个po记录
	 * @param po 库存po
	 */
	public void update(ArrivalNoteOnTransitPO po) throws RemoteException;
	/**
	 * 前置条件：无
	 * 后置条件：按名字进行查找返回相应的ArrivalNoteOnTransitPO结果
	 * @param name 库存名字
	 * @return ArrivalNoteOnTransitPO 库存PO
	 */
	public ArrivalNoteOnTransitPO findByName(String name) throws RemoteException;

	/**
	 * 前置条件：无
	 * 后置条件：返回所有的库存PO
	 * @return ArrivalNoteOnTransitPO 库存PO
	 */
	public ArrayList<ArrivalNoteOnTransitPO> show() throws RemoteException;
>>>>>>> parent of 2d8eb69... 10.22这个世界没有锟斤拷版本
}