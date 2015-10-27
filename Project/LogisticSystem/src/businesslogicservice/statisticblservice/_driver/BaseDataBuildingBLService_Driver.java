package businesslogicservice.statisticblservice._driver;

import businesslogicservice.statisticblservice.BaseDataBuildingBLService;

public class BaseDataBuildingBLService_Driver {
	
	public void drive(BaseDataBuildingBLService service){
		service.restartWithoutBasis();
		service.addCommodityInfo(null);
		service.addFinanceInfo(null);
		service.addInstitutionInfo(null);
		service.restartWithBasis();
		service.changeCommodityInfo(null);
		service.changeFinanceInfo(null);
		service.changeInstitutionInfo(null);
	}
}
