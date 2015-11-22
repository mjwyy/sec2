/**
 * 输入寄件单信息数据接口
 * @author wqy
 * @date 2015/10/17
 */
package dataservice.logisticdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.DeliveryNotePO;
import util.sendDocMsg;

public interface DeliveryNoteInputDataService {
	/**
	 * 在数据库中增加一个po记录
	 */
	public sendDocMsg insert(DeliveryNotePO po) throws RemoteException;
	/**
	 * 在数据库中删除一个po记录
	 */
	public boolean delete(DeliveryNotePO po) throws RemoteException;
	/**
	 * 在数据库中更新一个po记录
	 */
	public boolean update(DeliveryNotePO po) throws RemoteException;
	/**
	 * 查找返回相应的DeliveryNoteInputPO结果
	 */
	public ArrayList<DeliveryNotePO> find(DeliveryNotePO po) throws RemoteException;
	
	/**
	 * 返回所有的DeliveryNoteInputPO
	 */
	public ArrayList<DeliveryNotePO> findAll() throws RemoteException;
}
