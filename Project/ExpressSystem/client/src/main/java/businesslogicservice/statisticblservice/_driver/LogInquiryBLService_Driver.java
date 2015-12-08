package businesslogicservice.statisticblservice._driver;

import businesslogic.statistic.LogInquiry;
import businesslogicservice.statisticblservice.LogInquiryBLService;
import connection.RMIHelper;
import vo.SystemLogVO;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class LogInquiryBLService_Driver {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        RMIHelper.tryConnect();
        LogInquiryBLService_Driver driver = new LogInquiryBLService_Driver();
        LogInquiry logInquiry = new LogInquiry();
        driver.drive(logInquiry);
    }

	public void drive(LogInquiryBLService service){
		
		if(service.inputKeywords(new SystemLogVO("2015-02-12",null)).isPass()){
			System.out.println("Passed");
		}else{
			System.out.println("Failed");
		}
		
	}
	
}
