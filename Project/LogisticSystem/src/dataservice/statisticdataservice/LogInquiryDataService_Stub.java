package dataservice.statisticdataservice;
/**
 * @author wwz
 * @data 2015-10-22
 */
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.LogEntryPO;

public class LogInquiryDataService_Stub implements LogInquiryDataService {

	@Override
	public ArrayList<LogEntryPO> findLogEntries(String time,
			ArrayList<String> keyword) throws RemoteException {
		System.out.println("success");
		return null;
	}

}
