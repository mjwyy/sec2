package businesslogic.statistic;

import businesslogicservice.statisticblservice.BusinessDataModificationBLService;
import dataservice.exception.ElementNotFoundException;
import dataservice.statisticdataservice.BusinessDataModificationDataService;
import po.DistancePO;
import util.ResultMsg;
import util.enums.PriceType;

import java.rmi.RemoteException;

/**
 * Created by kylin on 15/11/17.
 */
public class BusinessDataModification implements BusinessDataModificationBLService {

    private BusinessDataModificationDataService dataService;

    private DistancePO distancePO;

    @Override
    public ResultMsg inputPrice(PriceType type, double price) {
        if(price < 0)
            return new ResultMsg(false,"价格不能是负数错误");
        return new ResultMsg(true,"价格格式正确");
    }

    @Override
    public ResultMsg inputCityDistance(String city1, String city2, double distance) {
        if(distance < 0)
            return new ResultMsg(false,"城市距离不能是负数错误");
        return new ResultMsg(true,"价格格式正确");
    }

    @Override
    public ResultMsg submitPrice(PriceType type, double price) {
        try {
            dataService.setPrice(type,price);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
        return new ResultMsg(true,"价格常量修改成功!");
    }

    @Override
    public ResultMsg submitCityDistance(String city1, String city2, double distance) {
        this.distancePO = new DistancePO(city1,city2,distance);
        try {
            dataService.setDistance(this.distancePO);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
        return new ResultMsg(true,"城市距离修改成功!");
    }

}
