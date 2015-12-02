/**
 * 库存查看盘点数据接口
 * @author wqy
 * @date 2015/10/17
 */
package dataservice.commoditydataservice;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

import po.InventoryPO;

public interface InventoryDataService extends Remote, Serializable {

	/**
	 * 按起止时间进行查找返回相应的PO结果
	 */
	public InventoryPO findByTime(String sTime,String eTime,String staffID) throws RemoteException;
	
	
	/**
	 * 库存盘点，返回上一个盘点时间点与此次盘点时间之间各区快递的信息
	 */
	public InventoryPO findAll(String staffID) throws RemoteException;

	/**
	 * Set the latest commodity check date
	 * @param date TODO
	 * @param staffID
	 * @return true for successful operation
	 * @throws RemoteException TODO
	 */
	public boolean setRecentTime(String date, String staffID) throws RemoteException;
}