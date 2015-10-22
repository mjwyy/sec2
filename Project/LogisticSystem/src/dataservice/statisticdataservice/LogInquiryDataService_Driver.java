package dataservice.statisticdataservice;
/**
 * @author wwz
 * @data 2015-10-22
 */
import java.rmi.RemoteException;
import java.util.ArrayList;

public class LogInquiryDataService_Driver {
	
	public void drive(LogInquiryDataService logInquiryDataService) throws RemoteException {
		ArrayList<String> keyword = new ArrayList<String>();
		keyword.add("获取统计报表");
		logInquiryDataService.findLogEntries("2015-09-09", keyword);	
	}
	
	public static void main(String[] args) throws RemoteException {
		LogInquiryDataService_Stub stub = new LogInquiryDataService_Stub();
		LogInquiryDataService_Driver driver = new LogInquiryDataService_Driver();
		driver.drive(stub);
	}

}
