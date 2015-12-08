package businesslogic.logistic.deliverystrategy;

import util.enums.DeliverCategory;
import util.enums.PackageType;

/**
 * Created by kylin on 15/12/3.
 */
public class DeliveryInfo {

    private String city1;

    private String city2;

    private double distance;

    double weight;

    double volume;

    DeliverCategory category;

    PackageType packageType;

    public DeliveryInfo(String city1, String city2, double distance, double weight, double volume,
                        DeliverCategory category, PackageType packageType) {
        this.city1 = city1;
        this.city2 = city2;
        this.distance = distance;
        this.weight = weight;
        this.volume = volume;
        this.category = category;
        this.packageType = packageType;
    }

    public String getCity1() {
        return city1;
    }

    public String getCity2() {
        return city2;
    }

    public double getDistance() {
        return distance;
    }

    public double getWeight() {
        return weight;
    }

    public double getVolume() {
        return volume;
    }

    public DeliverCategory getCategory() {
        return category;
    }

    public PackageType getPackageType() {
        return packageType;
    }
}
