
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

/**
 * 输入寄件单信息的数据接口
 * 职责是将格式无误的寄件单PO持久化存储
 * 并获取已经存在的寄件单信息
 *
 * @author Kylin
 */
public interface ReceivingNoteInputDataService extends Remote, Serializable {


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

}
