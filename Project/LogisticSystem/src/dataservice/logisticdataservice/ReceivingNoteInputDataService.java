<<<<<<< HEAD
/**
 * 输入寄件单信息数据接口
 * @author wqy
 * @date 2015/10/17
 */
package dataservice.logisticdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.ReceivingNoteInputPO;

public interface ReceivingNoteInputDataService {
	/**
	 * 在数据库中增加一个po记录
	 */
	public void insert(ReceivingNoteInputPO po) throws RemoteException;
	/**
	 * 在数据库中删除一个po记录
	 */
	public void delete(ReceivingNoteInputPO po) throws RemoteException;
	/**
	 * 在数据库中更新一个po记录
	 */
	public void update(ReceivingNoteInputPO po) throws RemoteException;
	/**
	 * 查找返回相应的ReceivingNoteInputPO结果
	 */
	public ArrayList<ReceivingNoteInputPO> find(String name) throws RemoteException;
	
	
	/**
	 * 返回所有的ReceivingNoteInputPO
	 */
	public ArrayList<ReceivingNoteInputPO> findAll() throws RemoteException;
=======
/**
 * 输入寄件单信息数据接口
 * @author wqy
 * @date 2015/10/17
 */
package dataservice.logisticdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.ReceivingNoteInputPO;

public interface ReceivingNoteInputDataService {
	/**
	 * 前置条件：同样ID的po在Mapper中不存在
	 * 后置条件：在数据库中增加一个po记录
	 * @param po 库存po
	 */
	public void insert(ReceivingNoteInputPO po) throws RemoteException;
	/**
	 * 前置条件：同样ID的po在Mapper中存在
	 * 后置条件：在数据库中删除一个po记录
	 * @param po 库存po
	 */
	public void delete(ReceivingNoteInputPO po) throws RemoteException;
	/**
	 * 前置条件：同样ID的po在Mapper中存在
	 * 后置条件：在数据库中更新一个po记录
	 * @param po 库存po
	 */
	public void update(ReceivingNoteInputPO po) throws RemoteException;
	/**
	 * 前置条件：无
	 * 后置条件：按名字进行查找返回相应的ReceivingNoteInputPO结果
	 * @param name 库存名字
	 * @return NotePO 库存PO
	 */
	public ReceivingNoteInputPO findByName(String name) throws RemoteException;

	/**
	 * 前置条件：无
	 * 后置条件：返回所有的库存PO
	 * @return ReceivingNoteInputPO 库存PO
	 */
	public ArrayList<ReceivingNoteInputPO> show() throws RemoteException;
>>>>>>> parent of 2d8eb69... 10.22这个世界没有锟斤拷版本
}