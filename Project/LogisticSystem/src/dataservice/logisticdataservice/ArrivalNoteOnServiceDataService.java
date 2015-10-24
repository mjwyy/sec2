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
