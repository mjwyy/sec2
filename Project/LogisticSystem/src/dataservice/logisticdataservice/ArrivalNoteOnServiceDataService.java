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
	 * @param po ArrivalNoteOnServicepo
	 */
	public void insert(ArrivalNoteOnServicePO po) throws RemoteException;
	/**
	 * 前置条件：同样ID的po在Mapper中存在
	 * 后置条件：在数据库中删除一个po记录
	 * @param po ArrivalNoteOnServicepo
	 */
	public void delete(ArrivalNoteOnServicePO po) throws RemoteException;
	/**
	 * 前置条件：同样ID的po在Mapper中存在
	 * 后置条件：在数据库中更新一个po记录
	 * @param po ArrivalNoteOnServicepo
	 */
	public void update(ArrivalNoteOnServicePO po) throws RemoteException;
	/**
	 * 前置条件：无
	 * 后置条件：查找返回相应的ArrivalNoteOnServicePO结果
	 * @param name 关键字
	 * @return ArrivalNoteOnServicePO ArrivalNoteOnServicePO
	 */
	public ArrayList<ArrivalNoteOnServicePO> find(String name) throws RemoteException;

	
	/**
	 * 前置条件：无
	 * 后置条件：返回所有的ArrivalNoteOnServicePO
	 * @return PO ArrivalNoteOnServicePO
	 */
	public ArrayList<ArrivalNoteOnServicePO> findAll() throws RemoteException;
}
