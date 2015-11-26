/**
 * 输入寄件单信息数据接口
 * @author wqy
 * @date 2015/10/17
 */
package dataservice.logisticdataservice;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import po.DeliveryNotePO;
import util.SendDocMsg;

public interface DeliveryNoteInputDataService extends Remote, Serializable {
	/**
	 * 在数据库中增加一个po记录
	 */
    public SendDocMsg insert(DeliveryNotePO po) throws RemoteException, SQLException;

	/**
	 * 查找返回相应的DeliveryNoteInputPO结果
	 */
	public ArrayList<DeliveryNotePO> find(DeliveryNotePO po) throws RemoteException;
	
	/**
	 * 返回所有的DeliveryNoteInputPO
	 */
	public ArrayList<DeliveryNotePO> findAll() throws RemoteException;
}
