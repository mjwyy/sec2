package businesslogic.logistic.deliverystrategy;

/**
 * Created by kylin on 15/12/8.
 */
public class PriceInfo {
    double pricePerKG;
    double packagePrice;

    public PriceInfo(double pricePerKG, double packagePrice) {
        this.pricePerKG = pricePerKG;
        this.packagePrice = packagePrice;
    }

    public double getPricePerKG() {
        return pricePerKG;
    }

    public double getPackagePrice() {
        return packagePrice;
    }
}
