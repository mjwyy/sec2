package businesslogic.statistic;

import businesslogicservice.statisticblservice.BusinessDataModificationBLService;
import util.ResultMsg;
import util.enums.PriceType;

/**
 * Created by kylin on 15/11/17.
 */
public class BusinessDataModification implements BusinessDataModificationBLService {
    @Override
    public ResultMsg inputPrice(PriceType type, double price) {
        return null;
    }

    @Override
    public ResultMsg inputCityDistance(String city1, String city2, double distance) {
        return null;
    }

    @Override
    public void submitChange() {

    }
}
