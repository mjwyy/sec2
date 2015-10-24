<<<<<<< HEAD
/**
 * 输入寄件单信息数据接口
 * @author wqy
 * @date 2015/10/17
 */
package dataservice.logisticdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.DeliveryNoteInputPO;

public interface DeliveryNoteInputDataService {
	/**
	 * 在数据库中增加一个po记录
	 */
	public void insert(DeliveryNoteInputPO po) throws RemoteException;
	/**
	 * 在数据库中删除一个po记录
	 */
	public void delete(DeliveryNoteInputPO po) throws RemoteException;
	/**
	 * 在数据库中更新一个po记录
	 */
	public void update(DeliveryNoteInputPO po) throws RemoteException;
	/**
	 * 查找返回相应的DeliveryNoteInputPO结果
	 */
	public ArrayList<DeliveryNoteInputPO> find(String name) throws RemoteException;
	
	
	/**
	 * 返回所有的DeliveryNoteInputPO
	 */
	public ArrayList<DeliveryNoteInputPO> findAll() throws RemoteException;
}
=======
/**
 * 输入寄件单信息数据接口
 * @author wqy
 * @date 2015/10/17
 */
package dataservice.logisticdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.DeliveryNoteInputPO;

public interface DeliveryNoteInputDataService {
	/**
	 * 前置条件：同样ID的po在Mapper中不存在
	 * 后置条件：在数据库中增加一个po记录
	 * @param po 库存po
	 */
	public void insert(DeliveryNoteInputPO po) throws RemoteException;
	/**
	 * 前置条件：同样ID的po在Mapper中存在
	 * 后置条件：在数据库中删除一个po记录
	 * @param po 库存po
	 */
	public void delete(DeliveryNoteInputPO po) throws RemoteException;
	/**
	 * 前置条件：同样ID的po在Mapper中存在
	 * 后置条件：在数据库中更新一个po记录
	 * @param po 库存po
	 */
	public void update(DeliveryNoteInputPO po) throws RemoteException;
	/**
	 * 前置条件：无
	 * 后置条件：按名字进行查找返回相应的DeliveryNoteInputPO结果
	 * @param name 库存名字
	 * @return DeliveryNoteInputPO 库存PO
	 */
	public DeliveryNoteInputPO findByName(String name) throws RemoteException;

	/**
	 * 前置条件：无
	 * 后置条件：返回所有的库存PO
	 * @return DeliveryNoteInputPO 库存PO
	 */
	public ArrayList<DeliveryNoteInputPO> show() throws RemoteException;
}
>>>>>>> parent of 2d8eb69... 10.22这个世界没有锟斤拷版本
