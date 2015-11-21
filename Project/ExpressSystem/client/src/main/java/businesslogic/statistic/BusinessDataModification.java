package businesslogic.statistic;

import businesslogicservice.statisticblservice.BusinessDataModificationBLService;
import dataservice.statisticdataservice.BusinessDataModificationDataService;
import util.ResultMsg;
import util.enums.PriceType;

/**
 * Created by kylin on 15/11/17.
 */
public class BusinessDataModification implements BusinessDataModificationBLService {

    private BusinessDataModificationDataService dataService;

    @Override
    public ResultMsg inputPrice(PriceType type, double price) {
        if(price < 0)
            return new ResultMsg(false,"价格格式错误");
        return new ResultMsg(true,"价格格式正确");
    }

    @Override
    public ResultMsg inputCityDistance(String city1, String city2, double distance) {

        return null;
    }

    @Override
    public ResultMsg submitPriceChange(PriceType type, double price) {
        return null;
    }

    @Override
    public ResultMsg submitCityDistance(String city1, String city2, double distance) {

        return null;
    }

}
