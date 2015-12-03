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

    public double getPrice(String city1, String city2, double weight, double volume,
                           DeliverCategory category, PackageType packageType) throws ElementNotFoundException, RemoteException, SQLException {
        double price;
        double distance = businessDataModificationData.getDistance(city1, city2);
        double pricePerKG = businessDataModificationData.getPrice(PriceType.PricePerKg);
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

        //获取包装费用
        PriceType packagePricrType = PriceType.getPriceType(packageType.toString());
        double packagePrice = businessDataModificationData.getPrice(packagePricrType);
        price = weightPrice + packagePrice;
        return price;
    }
}
