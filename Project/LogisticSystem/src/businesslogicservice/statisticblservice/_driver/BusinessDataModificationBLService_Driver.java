package businesslogicservice.statisticblservice._driver;

import businesslogic.util.PriceType;
import businesslogicservice.statisticblservice.BusinessDataModificationBLService;


public class BusinessDataModificationBLService_Driver {
	
	public void drive(BusinessDataModificationBLService service){
		service.inputCityDistance("c1", "c2", 23);
		service.inputPrice(PriceType.PricePerKg,1.0);
		service.submitChange();
	}
}
