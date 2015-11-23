/**
 * 输入寄件单信息数据接口
 * @author wqy
 * @date 2015/10/17
 */
package dataservice.logisticdataservice;

<<<<<<< HEAD
=======
import java.io.Serializable;
>>>>>>> master
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.ReceivingNotePO;

<<<<<<< HEAD
public interface ReceivingNoteInputDataService extends Remote {
=======
public interface ReceivingNoteInputDataService extends Remote, Serializable {
>>>>>>> master
	/**
	 * 在数据库中增加一个po记录
	 */
	public boolean insert(ReceivingNotePO po) throws RemoteException;
	/**
	 * 在数据库中删除一个po记录
	 */
	public boolean delete(ReceivingNotePO po) throws RemoteException;
	/**
	 * 在数据库中更新一个po记录
	 */
	public boolean update(ReceivingNotePO po) throws RemoteException;
	/**
	 * 查找返回相应的ReceivingNoteInputPO结果
	 */
	public ArrayList<ReceivingNotePO> find(ReceivingNotePO po) throws RemoteException;
	
	
	/**
	 * 返回所有的ReceivingNoteInputPO
	 */
	public ArrayList<ReceivingNotePO> findAll() throws RemoteException;
}