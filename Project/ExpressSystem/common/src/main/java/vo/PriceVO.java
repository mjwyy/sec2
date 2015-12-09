package vo;

import util.enums.PriceType;

/**
 * Created by kylin on 15/12/9.
 */
public class PriceVO {

    private PriceType priceType;

    private double price;

    public PriceVO(PriceType priceType, double price) {
        this.priceType = priceType;
        this.price = price;
    }

    public PriceType getPriceType() {
        return priceType;
    }

    public double getPrice() {
        return price;
    }
}
