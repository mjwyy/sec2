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
<<<<<<< HEAD
	 * @param po ArrivalNoteOnTransitpo
=======
	 * @param po 库存po
>>>>>>> master
	 */
	public void insert(ArrivalNoteOnTransitPO po) throws RemoteException;
	/**
	 * 前置条件：同样ID的po在Mapper中存在
	 * 后置条件：在数据库中删除一个po记录
<<<<<<< HEAD
	 * @param po ArrivalNoteOnTransitpo
=======
	 * @param po 库存po
>>>>>>> master
	 */
	public void delete(ArrivalNoteOnTransitPO po) throws RemoteException;
	/**
	 * 前置条件：同样ID的po在Mapper中存在
	 * 后置条件：在数据库中更新一个po记录
<<<<<<< HEAD
	 * @param po 库ArrivalNoteOnTransitpo
=======
	 * @param po 库存po
>>>>>>> master
	 */
	public void update(ArrivalNoteOnTransitPO po) throws RemoteException;
	/**
	 * 前置条件：无
<<<<<<< HEAD
	 * 后置条件：查找返回相应的ArrivalNoteOnTransitPO结果
	 * @param name 关键字
	 * @return ArrivalNoteOnTransitPO 
	 */
	public ArrayList<ArrivalNoteOnTransitPO> find(String name) throws RemoteException;
	
	
	/**
	 * 前置条件：无
	 * 后置条件：返回所有的ArrivalNoteOnTransitPO
	 * @return ArrivalNoteOnTransitPO 
	 */
	public ArrayList<ArrivalNoteOnTransitPO> findAll() throws RemoteException;
=======
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
>>>>>>> master
}