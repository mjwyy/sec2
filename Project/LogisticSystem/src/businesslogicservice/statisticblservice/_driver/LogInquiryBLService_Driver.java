package businesslogicservice.statisticblservice._driver;

import java.util.ArrayList;

import businesslogic.util.ResultMsg;
import businesslogicservice.statisticblservice.LogInquiryBLService;
import vo.SystemLogVO;

public class LogInquiryBLService_Driver {
	

	public void drive(LogInquiryBLService service){
		service.inputKeywords("2015-02-12");
		service.getLogInfo("2015-02-12");
	}
	
}
