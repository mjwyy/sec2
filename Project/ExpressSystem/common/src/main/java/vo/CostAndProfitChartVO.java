package vo;

import util.enums.ChartType;

/**
 * Created by kylin on 15/11/21.
 */
public class CostAndProfitChartVO extends ChartVO {

    private double cost;
    private double profit;

    public CostAndProfitChartVO(String starttime, String endtime, double cost,
                                double profit) {
        super(ChartType.PROFIT_CHART,starttime,endtime);
        this.cost = cost;
        this.profit = profit;
    }

    public double getCost() {
        return cost;
    }

    public double getProfit() {
        return profit;
    }

    public CostAndProfitChartVO(String starttime, String endtime){
        super(ChartType.BUSINESS_STAT_CHART,starttime,endtime);
    }
}
