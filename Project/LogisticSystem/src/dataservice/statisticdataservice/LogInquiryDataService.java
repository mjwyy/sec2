package dataservice.statisticdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.LogEntryPO;

public interface LogInquiryDataService extends Remote {

	/**
	 * ǰ����������
	 * ����������Data�����ʱ�䡢�ؼ��ʲ�ѯLog�����������Ŀ
	 * @param time
	 * @param keyword
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<LogEntryPO> findLogEntries(String time,ArrayList<String> keyword)
		throws RemoteException;
	
}
