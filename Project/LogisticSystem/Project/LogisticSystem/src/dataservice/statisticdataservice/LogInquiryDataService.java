package dataservice.statisticdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.LogEntryPO;

public interface LogInquiryDataService extends Remote {

	/**
	 * 前置条件：无
	 * 后置条件：Data层根据时间、关键词查询Log，返回相关条目
	 * @param time
	 * @param keyword
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<LogEntryPO> findLogEntries(String time,ArrayList<String> keyword)
		throws RemoteException;
	
}
