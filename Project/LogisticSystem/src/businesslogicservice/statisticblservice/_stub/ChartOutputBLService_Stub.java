package businesslogicservice.statisticblservice._stub;

import businesslogic.util.ChartType;
import businesslogic.util.ResultMsg;
import businesslogicservice.statisticblservice.ChartOutputBLService;
import vo.ChartVO;

public class ChartOutputBLService_Stub implements ChartOutputBLService {

	
	public ResultMsg enquiryChart(ChartType chartType,String time1,String time2){
		System.out.println("enquirying chart:" );
		return new ResultMsg(true, "Success!");
	}

	@Override
	public ChartVO getChartVO(ChartType chartType, String time1, String time2) {
		System.out.println("getChartVO!");
		return new ChartVO(ChartType.BUSINESS_STAT_CHART,"2015-10-22","2015-11-1");
	}



	public ResultMsg exportChart(String path){
		System.out.println("Exported!");
		return new ResultMsg(true, "Success!");
	};
}
