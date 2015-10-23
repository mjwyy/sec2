/**
 * 库存查看盘点数据接口
 * @author wqy
 * @date 2015/10/17
 */
package dataservice.commoditydataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.InventoryPO;

public interface InventoryDataService {
	/**
	 * 前置条件：无
	 * 后置条件：按起止时间进行查找返回相应的PO结果
	 * @param sTime 开始时间
	 * @param eTime 结束时间
	 * @return InventoryPO 库存PO
	 */
	
	public ArrayList<InventoryPO> findByTime(String sTime,String eTime) throws RemoteException;
	
	
	/**
	 * 前置条件：无
	 * 后置条件：库存盘点，返回上一个盘点时间点与此次盘点时间之间各区快递的信息
	 * @return InventoryPO 库存PO
	 */
	public ArrayList<InventoryPO> findAll() throws RemoteException;

}