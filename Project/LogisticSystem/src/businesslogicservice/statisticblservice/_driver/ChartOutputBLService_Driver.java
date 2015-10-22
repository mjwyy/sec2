package businesslogicservice.statisticblservice._driver;

import java.sql.Driver;

import businesslogic.util.ChartType;
import businesslogic.util.ResultMsg;
import businesslogicservice.statisticblservice.ChartOutputBLService;
import vo.ChartVO;

public class ChartOutputBLService_Driver {

	
	public void drive(ChartOutputBLService service){
		service.enquiryChart(null, null, null);
		service.getChartVO();
		service.exportChart("C:/");

	}
}
