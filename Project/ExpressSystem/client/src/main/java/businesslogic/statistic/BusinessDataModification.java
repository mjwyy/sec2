package businesslogic.statistic;

import businesslogicservice.statisticblservice.BusinessDataModificationBLService;
import connection.RemoteObjectGetter;
import dataservice.exception.ElementNotFoundException;
import dataservice.statisticdataservice.BusinessDataModificationDataService;
import po.DistancePO;
import util.ResultMsg;
import util.enums.PriceType;

import java.rmi.RemoteException;
import java.sql.SQLException;

/**
 * Created by kylin on 15/11/17.
 */
public class BusinessDataModification implements BusinessDataModificationBLService {

    private BusinessDataModificationDataService dataService;

    private DistancePO distancePO;

    public BusinessDataModification() {
        RemoteObjectGetter getter = new RemoteObjectGetter();
        this.dataService =
                (BusinessDataModificationDataService)getter.getObjectByName("BusinessDataModificationDataService");
    }

    @Override
    public ResultMsg inputPrice(PriceType type, double price) {
        if(price < 0)
            return new ResultMsg(false,"价格不能是负数!");
        this.submitPrice(type,price);
        return new ResultMsg(true);
    }

    @Override
    public ResultMsg inputCityDistance(String city1, String city2, double distance) {
        if(distance < 0)
            return new ResultMsg(false,"城市距离不能是负数!");
        this.submitCityDistance(city1,city2,distance);
        return new ResultMsg(true);
    }

    @Override
    public ResultMsg submitPrice(PriceType type, double price) {
        try {
            dataService.setPrice(type,price);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
            return new ResultMsg(false,e.getMessage());
        } catch (SQLException e) {
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
            return new ResultMsg(false,e.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ResultMsg(true,"城市距离修改成功!");
    }

}
