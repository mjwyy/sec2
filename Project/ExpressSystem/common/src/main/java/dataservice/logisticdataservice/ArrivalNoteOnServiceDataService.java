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
import dataservice.exception.InterruptWithExistedElementException;
import po.ArrivalNoteOnServicePO;
import po.DeliverNoteOnServicePO;
import util.ResultMsg;


public interface ArrivalNoteOnServiceDataService extends Remote, Serializable {

    /**
     * 在数据库中插入单一持久化对象
     */
    ResultMsg insertArrivalNote(ArrivalNoteOnServicePO po)
            throws RemoteException, ElementNotFoundException ,InterruptWithExistedElementException;

    /**
     * 在数据库中插入单一持久化对象
     */
    ResultMsg insertDeliverNote(DeliverNoteOnServicePO po)
            throws RemoteException, ElementNotFoundException,InterruptWithExistedElementException;

}
