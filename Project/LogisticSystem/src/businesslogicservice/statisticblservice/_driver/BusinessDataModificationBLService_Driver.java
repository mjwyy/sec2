package businesslogicservice.statisticblservice._driver;

import businesslogic.util.ConstantType;
import businesslogic.util.PriceType;
import businesslogic.util.ResultMsg;
import businesslogicservice.statisticblservice.BusinessDataModificationBLService;


public class BusinessDataModificationBLService_Driver {
	
	public void drive(BusinessDataModificationBLService service){
		service.inputCityDistance("c1", "c2", 23);
		service.selectConstantType(null);
		service.inputPrice(PriceType.PricePerKm,1.0);
		service.submitChange();
	}
}
