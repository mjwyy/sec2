package businesslogicservice.statisticblservice._stub;

import businesslogicservice.statisticblservice.BusinessDataModificationBLService;
import util.ResultMsg;
import util.enums.PriceType;
import vo.DistanceVO;
import vo.PriceVO;


public class BusinessDataModificationBLService_Stub implements BusinessDataModificationBLService {

	public ResultMsg inputCityDistance(String city1,String city2,double distance){
		System.out.println("inputed distance");
		return new ResultMsg(true,"Success!");
	}

    @Override
    public ResultMsg submitPrice(PriceType type, double price) {
        return null;
    }

    @Override
    public DistanceVO getAllDistanceInfo() {
        return null;
    }

    @Override
    public ResultMsg submitCityDistance(String city1, String city2, double distance) {
        return null;
    }

    @Override
    public PriceVO getAllPrices() {
        return null;
    }

    public ResultMsg inputPrice(PriceType type, double price) {
        System.out.println("inputPrice succeed");
		return new ResultMsg(true,"Success!");
	}
}
