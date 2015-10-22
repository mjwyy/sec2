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
	 * @param po ReceivingNoteInputpo
	 */
	public void insert(ReceivingNoteInputPO po) throws RemoteException;
	/**
	 * 前置条件：同样ID的po在Mapper中存在
	 * 后置条件：在数据库中删除一个po记录
	 * @param po ReceivingNoteInputpo
	 */
	public void delete(ReceivingNoteInputPO po) throws RemoteException;
	/**
	 * 前置条件：同样ID的po在Mapper中存在
	 * 后置条件：在数据库中更新一个po记录
	 * @param po ReceivingNoteInputpo
	 */
	public void update(ReceivingNoteInputPO po) throws RemoteException;
	/**
	 * 前置条件：无
	 * 后置条件：查找返回相应的ReceivingNoteInputPO结果
	 * @param name 关键字
	 * @return ReceivingNoteInputPO 
	 */
	public ArrayList<ReceivingNoteInputPO> find(String name) throws RemoteException;
	
	
	/**
	 * 前置条件：无
	 * 后置条件：返回所有的ReceivingNoteInputPO
	 * @return ReceivingNoteInputPO 
	 */
	public ArrayList<ReceivingNoteInputPO> findAll() throws RemoteException;
}