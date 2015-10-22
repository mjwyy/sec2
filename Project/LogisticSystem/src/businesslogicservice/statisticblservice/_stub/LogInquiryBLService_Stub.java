package businesslogicservice.statisticblservice._stub;

import java.util.ArrayList;

import businesslogic.util.ResultMsg;
import businesslogicservice.statisticblservice.LogInquiryBLService;
import vo.SystemLogVO;

public class LogInquiryBLService_Stub implements LogInquiryBLService {
	

	public ResultMsg inputKeywords(String keywords){
		System.out.println("received keywords: " + keywords);
		return new ResultMsg(true, "Success!");
	};
	

	public ArrayList<SystemLogVO> getLogInfo(String keywords){
		System.out.println("returning info");
		return new ArrayList<>();
	};
	
}
