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
	 * @param po DeliveryNoteInputpo
	 */
	public void insert(DeliveryNoteInputPO po) throws RemoteException;
	/**
	 * 前置条件：同样ID的po在Mapper中存在
	 * 后置条件：在数据库中删除一个po记录
	 * @param po DeliveryNoteInputpo
	 */
	public void delete(DeliveryNoteInputPO po) throws RemoteException;
	/**
	 * 前置条件：同样ID的po在Mapper中存在
	 * 后置条件：在数据库中更新一个po记录
	 * @param po DeliveryNoteInputpo
	 */
	public void update(DeliveryNoteInputPO po) throws RemoteException;
	/**
	 * 前置条件：无
	 * 后置条件：查找返回相应的DeliveryNoteInputPO结果
	 * @param name 关键字
	 * @return DeliveryNoteInputPO 
	 */
	public ArrayList<DeliveryNoteInputPO> find(String name) throws RemoteException;
	
	
	/**
	 * 前置条件：无
	 * 后置条件：返回所有的DeliveryNoteInputPO
	 * @return DeliveryNoteInputPO 
	 */
	public ArrayList<DeliveryNoteInputPO> findAll() throws RemoteException;
}
