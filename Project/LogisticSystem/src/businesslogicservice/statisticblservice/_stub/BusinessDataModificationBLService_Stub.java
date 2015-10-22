package businesslogicservice.statisticblservice._stub;

import businesslogic.util.ConstantType;
import businesslogic.util.ResultMsg;
import businesslogicservice.statisticblservice.BusinessDataModificationBLService;


public class BusinessDataModificationBLService_Stub implements BusinessDataModificationBLService {
	
	
	public void selectConstantType(ConstantType type){
		System.out.println("seleted type");
	};
	
	
	public ResultMsg inputPrice(double price){
		System.out.println("inputed price");
		return new ResultMsg(true,"Success!");
	};
	
	
	public ResultMsg inputCityDistance(String city1,String city2,double distance){
		System.out.println("inputed distance");
		return new ResultMsg(true,"Success!");
	};
	
	
	public void submitChange(){
		System.out.println("submitted changes");
	};
}
