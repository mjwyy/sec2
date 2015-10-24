package businesslogicservice.statisticblservice._driver;

import businesslogicservice.statisticblservice.LogInquiryBLService;
import vo.SystemLogVO;

public class LogInquiryBLService_Driver {
	

	public void drive(LogInquiryBLService service){
		service.inputKeywords(new SystemLogVO("2015-02-12",null));
		service.getLogInfo(new SystemLogVO("2015-02-12",null));
	}
	
}
