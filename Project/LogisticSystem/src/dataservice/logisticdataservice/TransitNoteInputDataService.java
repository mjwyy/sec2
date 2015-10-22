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
	 * 前置条件：同样ID的po在Mapper中不存在
	 * 后置条件：在数据库中增加一个po记录
<<<<<<< HEAD
	 * @param po TransitNoteInputpo
=======
	 * @param po 库存po
>>>>>>> master
	 */
	public void insert(TransitNoteInputPO po) throws RemoteException;
	/**
	 * 前置条件：同样ID的po在Mapper中存在
	 * 后置条件：在数据库中删除一个po记录
<<<<<<< HEAD
	 * @param po TransitNoteInputpo
=======
	 * @param po 库存po
>>>>>>> master
	 */
	public void delete(TransitNoteInputPO po) throws RemoteException;
	/**
	 * 前置条件：同样ID的po在Mapper中存在
	 * 后置条件：在数据库中更新一个po记录
<<<<<<< HEAD
	 * @param po TransitNoteInputpo
=======
	 * @param po 库存po
>>>>>>> master
	 */
	public void update(TransitNoteInputPO po) throws RemoteException;
	/**
	 * 前置条件：无
<<<<<<< HEAD
	 * 后置条件：查找返回相应的NotePO结果
	 * @param name 关键字
	 * @return TransitNoteInputPO 
	 */
	public ArrayList<TransitNoteInputPO> find(String name) throws RemoteException;
	
	
	/**
	 * 前置条件：无
	 * 后置条件：返回所有的TransitNoteInputPO
	 * @return TransitNoteInputPO 
	 */
	public ArrayList<TransitNoteInputPO> findAll() throws RemoteException;
=======
	 * 后置条件：按名字进行查找返回相应的NotePO结果
	 * @param name 库存名字
	 * @return TransitNoteInputPO 库存PO
	 */
	public TransitNoteInputPO findByName(String name) throws RemoteException;

	/**
	 * 前置条件：无
	 * 后置条件：返回所有的库存PO
	 * @return TransitNoteInputPO 库存PO
	 */
	public ArrayList<TransitNoteInputPO> show() throws RemoteException;
>>>>>>> master
}