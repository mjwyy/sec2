package businesslogic.statistic;

import businesslogicservice.statisticblservice.BusinessDataModificationBLService;
import connection.RemoteObjectGetter;
import dataservice.exception.ElementNotFoundException;
import dataservice.statisticdataservice.BusinessDataModificationDataService;
import po.DistancePO;
import util.ResultMsg;
import util.enums.PriceType;
import vo.DistanceVO;
import vo.PriceVO;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

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
    public ArrayList<PriceVO> getAllPrices() {
        ArrayList<PriceVO> priceVOs = new ArrayList<>();
        try {
            for(PriceType priceType : PriceType.values()){
                double price = this.dataService.getPrice(priceType);
                PriceVO priceVO = new PriceVO(priceType,price);
                priceVOs.add(priceVO);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
        return priceVOs;
    }

    @Override
    public ResultMsg inputPrice(PriceType type, double price) {
        if(price < 0)
            return new ResultMsg(false,"价格不能是负数!");
        return new ResultMsg(true);
    }

    @Override
    public ResultMsg inputCityDistance(String city1, String city2, double distance) {
        if(distance < 0)
            return new ResultMsg(false,"城市距离不能是负数!");
        return new ResultMsg(true);
    }

    @Override
    public ResultMsg submitPrice(PriceType type, double price) {
        try {
            dataService.setPrice(type,price);
            return new ResultMsg(true,"价格常量修改成功!");
        } catch (RemoteException e) {
            e.printStackTrace();
            return new ResultMsg(false,"无法修改价格常量!");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
            return new ResultMsg(false,"无法修改价格常量!");
        }
    }

    @Override
    public ArrayList<DistanceVO> getAllDistanceInfo() {
        ArrayList<DistanceVO> results = new ArrayList<>();
        try {
            ArrayList<String> cities = this.dataService.getAllCities();
            String city1,city2;
            int size = cities.size();
            if(size < 1)
                return results;
            String[] cityArray = new String[size];
            for(int i = 0; i < size; i++){
                cityArray[i] = cities.get(i);
            }
            for(int i = 0; i < size; i++){
                city1 = cityArray[i];
                for(int j = i+1; j < size; j++){
                    city2 = cityArray[j];
                    double distance = this.dataService.getDistance(city1,city2);
                    DistanceVO distanceVO = new DistanceVO(city1,city2,distance);
                    results.add(distanceVO);
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
        return results;
    }

    @Override
    public ResultMsg submitCityDistance(String city1, String city2, double distance) {
        this.distancePO = new DistancePO(city1,city2,distance);
        try {
            dataService.setDistance(this.distancePO);
            return new ResultMsg(true,"城市距离修改成功!");
        } catch (RemoteException e) {
            e.printStackTrace();
            return new ResultMsg(false,"无法修改价格常量!");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
            return new ResultMsg(false,e.getMessage());
        }
    }

}
