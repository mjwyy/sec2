package businesslogicservice.statisticblservice._driver;

import java.util.ArrayList;

import vo.NoteVO;
import businesslogic.util.DocType;
import businesslogicservice.statisticblservice.NoteApprovingBLService;
import businesslogicservice.statisticblservice._stub.*;


public class StatisticClient {

	public static void main(String[] args) {
		
		BaseDataBuildingBLService_Driver driver1 = new BaseDataBuildingBLService_Driver();
		driver1.drive(new BaseDataBuildingBLService_Stub());
		
		BusinessDataModificationBLService_Driver driver2 = new BusinessDataModificationBLService_Driver();
		driver2.drive(new BusinessDataModificationBLService_Stub());
		
		ChartOutputBLService_Driver driver3 = new ChartOutputBLService_Driver();
		driver3.drive(new ChartOutputBLService_Stub());
		
		LogInquiryBLService_Driver driver4 = new LogInquiryBLService_Driver();
		driver4.drive(new LogInquiryBLService_Stub());
		
		NoteApprovingBLService_Driver driver5 = new NoteApprovingBLService_Driver();
		driver5.drive(new NoteApprovingBLService_Stub());
	}
	
}
