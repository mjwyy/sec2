
/**
 * 出库处理数据接口
 * @author wqy
 * @date 2015/10/17
 */
package dataservice.commoditydataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.StorageOutPO;

public interface StorageOutDataService {
	/**
	 * 在数据库中增加一个po记录
	 */
	public void insert(StorageOutPO po) throws RemoteException;
	/**
	 * 在数据库中删除一个po记录
	 */
	public void delete(StorageOutPO po) throws RemoteException;
	/**
	 * 在数据库中更新一个po记录
	 */
	public void update(StorageOutPO po) throws RemoteException;
	/**
	 * 查找返回相应的StorageOutPOPO结果
	 */
	public ArrayList<StorageOutPO> find(String name) throws RemoteException;
	
	
}