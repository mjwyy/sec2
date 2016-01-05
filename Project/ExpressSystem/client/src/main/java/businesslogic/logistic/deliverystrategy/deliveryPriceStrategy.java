package businesslogic.logistic.deliverystrategy;

import dataservice.exception.ElementNotFoundException;
import dataservice.statisticdataservice.BusinessDataModificationDataService;
import util.enums.DeliverCategory;
import util.enums.PackageType;
import util.enums.PriceType;

import java.rmi.RemoteException;
import java.sql.SQLException;

/**
 * Created by kylin on 15/11/30.
 */
public class DeliveryPriceStrategy implements PriceStrategy {

    public double getPrice(DeliveryInfo deliveryInfo,PriceInfo priceInfo)
            throws ElementNotFoundException, RemoteException, SQLException {
        //获取需要的寄件单信息
        DeliverCategory category = deliveryInfo.getCategory();
        double distance = deliveryInfo.getDistance();
        double weight = deliveryInfo.getWeight();
        double volume = deliveryInfo.getVolume();
        double price;

        //计算总价
        double pricePerKG = priceInfo.pricePerKG;
        double packagePrice = priceInfo.packagePrice;
        double pricePerKGKM = distance / 1000 * pricePerKG;
        double weightPrice = pricePerKGKM * weight;

        //体积大重量小的物体
        if (weight / volume < 0.01) {
            double volumeWeight = volume / 5000;
            double volumePrice = pricePerKGKM * volumeWeight;
            weightPrice = volumePrice > weightPrice ? volumePrice : weightPrice;
        }

        //根据快递种类定价
        if (category == DeliverCategory.ECNOMIC)
            weightPrice = weightPrice * 18 / 23;
        else if (category == DeliverCategory.EXPRESS)
            weightPrice = weightPrice * 25 / 23;

        price = weightPrice + packagePrice;
        return price;
    }
}
