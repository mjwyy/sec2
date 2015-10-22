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
