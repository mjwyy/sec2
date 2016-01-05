package businesslogicservice.statisticblservice._stub;

import businesslogicservice.statisticblservice.BusinessDataModificationBLService;
import util.ResultMsg;
import util.enums.PriceType;
import vo.DistanceVO;
import vo.PriceVO;

import java.util.ArrayList;


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
    public ArrayList<DistanceVO> getAllDistanceInfo() {
        return null;
    }

    @Override
    public ResultMsg submitCityDistance(String city1, String city2, double distance) {
        return null;
    }

    @Override
    public ResultMsg addCity(String name) {
        return null;
    }

    @Override
    public ArrayList<PriceVO> getAllPrices() {
        return null;
    }

    public ResultMsg inputPrice(PriceType type, double price) {
        System.out.println("inputPrice succeed");
		return new ResultMsg(true,"Success!");
	}

	@Override
	public ResultMsg addCity(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}
