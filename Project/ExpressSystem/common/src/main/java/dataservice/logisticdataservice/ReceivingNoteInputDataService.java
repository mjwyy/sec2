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

import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import po.ReceivingNotePO;
import util.ResultMsg;

public interface ReceivingNoteInputDataService extends Remote,Serializable {


    /**
     * 在数据库中加入一条收件单信息
     *
     * @param po 收件单PO
     * @return 业务员提交单据结果
     * @throws RemoteException 网络异常
     * @throws ElementNotFoundException 收件单对应的条形码不存在
     * @throws InterruptWithExistedElementException 收件单据已存在异常
     */
    ResultMsg insert(ReceivingNotePO po)
            throws RemoteException, ElementNotFoundException, InterruptWithExistedElementException;

    /**
     * 查询返回数据库中所有的收件单
     *
     * @return 所有的收件单PO
     * @throws RemoteException 网络异常
     */
    ArrayList<ReceivingNotePO> getReceivingNote() throws RemoteException;
}
