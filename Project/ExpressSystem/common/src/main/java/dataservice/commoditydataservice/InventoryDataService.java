/**
 * 库存查看盘点数据接口
 * @author wqy
 * @date 2015/10/17
 */
package dataservice.commoditydataservice;

<<<<<<< HEAD
=======
import java.io.Serializable;
>>>>>>> master
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.InventoryPO;

<<<<<<< HEAD
public interface InventoryDataService extends Remote {
=======
public interface InventoryDataService extends Remote, Serializable {
>>>>>>> master

	/**
	 * 按起止时间进行查找返回相应的PO结果
	 */
	public ArrayList<InventoryPO> findByTime(String sTime,String eTime) throws RemoteException;
	
	
	/**
	 * 库存盘点，返回上一个盘点时间点与此次盘点时间之间各区快递的信息
	 */
	public ArrayList<InventoryPO> findAll() throws RemoteException;

}