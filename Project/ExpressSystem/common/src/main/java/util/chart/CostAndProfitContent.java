package util.chart;

import java.io.Serializable;

/**
 * Created by kylin on 15/12/4.
 */
public class CostAndProfitContent implements Serializable {

    private String date;

    private double income;

    private double cost;

    private double profit;

    public CostAndProfitContent(String date,double income, double cost) {
        this.date = date;
        this.income = income;
        this.cost = cost;
        this.profit = income-cost;
    }

    public double getIncome() {
        return income;
    }

    public double getCost() {
        return cost;
    }

    public double getProfit() {
        return profit;
    }

    public String getDate() {
        return date;
    }
}
