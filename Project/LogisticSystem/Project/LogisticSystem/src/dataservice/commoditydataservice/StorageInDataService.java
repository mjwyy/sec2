/**
 * 入库处理数据接口
 * @author wqy
 * @date 2015/10/17
 */



package dataservice.commoditydataservice;

import java.rmi.RemoteException;

import po.StorageInPO;

public interface StorageInDataService {
	/**
	 * 前置条件：同样ID的po在Mapper中不存在
	 * 后置条件：在数据库中增加一个po记录
	 * @param po 库存po
	 */
	public void insert(StorageInPO po) throws RemoteException;
	/**
	 * 前置条件：同样ID的po在Mapper中存在
	 * 后置条件：在数据库中删除一个po记录
	 * @param po 库存po
	 */
	public void delete(StorageInPO po) throws RemoteException;
	/**
	 * 前置条件：同样ID的po在Mapper中存在
	 * 后置条件：在数据库中更新一个po记录
	 * @param po 库存po
	 */
	public void update(StorageInPO po) throws RemoteException;
	/**
	 * 前置条件：无
	 * 后置条件：查找返回相应的StorageInPOPO结果
	 * @param name 库存
	 * @return StorageInPOPO 库存PO
	 */
	public StorageInPO find(String name) throws RemoteException;
	
	

}