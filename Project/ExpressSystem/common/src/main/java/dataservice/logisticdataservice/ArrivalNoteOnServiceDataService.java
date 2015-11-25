/**
 * 处理营业厅到达件数据接口
 * @author wqy
 * @date 2015/10/17
 */
package dataservice.logisticdataservice;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import dataservice.exception.ElementNotFoundException;
import po.ArrivalNoteOnServicePO;
import po.DeliverNoteOnServicePO;


public interface ArrivalNoteOnServiceDataService extends Remote, Serializable {

    /**
     * 在数据库中插入单一持久化对象
     */
    public boolean insertArrivalNote(ArrivalNoteOnServicePO po) throws RemoteException, SQLException, ElementNotFoundException;

    /**
     * 按关键字进行查找返回相应的ArrivalNoteOnServicePO结果
     */
    public ArrayList<ArrivalNoteOnServicePO> findArrivalNote(ArrivalNoteOnServicePO po) throws RemoteException;

    /**
     * 返回所有的营业厅到达单PO
     */
    public ArrayList<ArrivalNoteOnServicePO> findAllArrivalNote() throws RemoteException;

    /**
     * 在数据库中插入单一持久化对象
     */
    public boolean insertDeliverNote(DeliverNoteOnServicePO po) throws RemoteException;

    /**
     * 按关键字进行查找返回相应的ArrivalNoteOnServicePO结果
     */
    public ArrayList<DeliverNoteOnServicePO> findDeliverNote(DeliverNoteOnServicePO po) throws RemoteException;

    /**
     * 返回所有的ArrivalNoteOnServiceP
     */
    public ArrayList<DeliverNoteOnServicePO> findAllDeliverNote() throws RemoteException;
}
