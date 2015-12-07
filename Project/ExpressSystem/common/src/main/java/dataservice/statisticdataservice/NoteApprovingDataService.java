package dataservice.statisticdataservice;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import dataservice.exception.ElementNotFoundException;
import po.*;
import util.ApproveNote;
import util.ResultMsg;

/**
 * 单据审批DataService
 * @author River
 *
 */
public interface NoteApprovingDataService extends Remote, Serializable {
	
	/**
     * 获取所有待审批单据
     * @return 待审批的所有单据信息
     */
    public ArrayList<ApproveNote> getNotes();
    
    /**
     * 搭配getNotes使用的接受审批结果的接口，将会登记审批结果
     * @param results 应为之前getNotes获得的单据信息，各个单据应为“通过”或“不通过并填写了审批意见”
     * @return 审批操作反馈，一般为true，若为false则出现了错误，需要用其message提醒操作者
     * @throws RemoteException 将会在这里封装错误信息，注意处理
     */
    public ResultMsg pushResults(ArrayList<ApproveNote> results) throws RemoteException;
}
