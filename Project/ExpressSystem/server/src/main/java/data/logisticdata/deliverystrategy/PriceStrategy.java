package data.logisticdata.deliverystrategy;

import data.database.DatabaseFactoryMysqlImpl;
import data.statisticdata.BusinessDataModificationData;
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
public class PriceStrategy {

    private BusinessDataModificationDataService businessDataModificationData;

    public PriceStrategy(BusinessDataModificationDataService businessDataModificationData)
            throws RemoteException {
        this.businessDataModificationData = businessDataModificationData;
    }

    public double getPrice(DeliveryInfo deliveryInfo) throws ElementNotFoundException, RemoteException, SQLException {
        //获取需要的寄件单信息
        DeliverCategory category = deliveryInfo.getCategory();
        double distance = deliveryInfo.getDistance();
        double weight = deliveryInfo.getWeight();
        double volume = deliveryInfo.getVolume();
        PackageType packageType = deliveryInfo.getPackageType();

        double price;

        //获取数据库中价格常量
        double pricePerKG = businessDataModificationData.getPrice(PriceType.PricePerKg);
        PriceType packagePricrType = PriceType.getPriceType(packageType.toString());
        double packagePrice = businessDataModificationData.getPrice(packagePricrType);

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
