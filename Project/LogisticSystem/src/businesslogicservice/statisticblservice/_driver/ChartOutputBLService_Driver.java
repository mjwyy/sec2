package businesslogicservice.statisticblservice._driver;

import businesslogicservice.statisticblservice.ChartOutputBLService;

public class ChartOutputBLService_Driver {

	
	public void drive(ChartOutputBLService service){
		service.enquiryChart(null, null, null);
		service.getChartVO();
		service.exportChart("C:/");
	}
}
