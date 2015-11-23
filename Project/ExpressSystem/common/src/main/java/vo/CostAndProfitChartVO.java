package vo;

import util.enums.ChartType;

<<<<<<< HEAD
=======
import java.util.ArrayList;

>>>>>>> master
/**
 * Created by kylin on 15/11/21.
 */
public class CostAndProfitChartVO extends ChartVO {

<<<<<<< HEAD
    private double cost;
    private double profit;

    public CostAndProfitChartVO(String starttime, String endtime, double cost,
                                double profit) {
=======
    private ArrayList<Double> cost;
    private ArrayList<Double> profit;

    public CostAndProfitChartVO(String starttime, String endtime, ArrayList<Double> cost,
                                ArrayList<Double> profit) {
>>>>>>> master
        super(ChartType.PROFIT_CHART,starttime,endtime);
        this.cost = cost;
        this.profit = profit;
    }

<<<<<<< HEAD
    public double getCost() {
        return cost;
    }

    public double getProfit() {
=======
    public ArrayList<Double> getCost() {
        return cost;
    }

    public ArrayList<Double> getProfit() {
>>>>>>> master
        return profit;
    }

    public CostAndProfitChartVO(String starttime, String endtime){
<<<<<<< HEAD
        super(ChartType.BUSINESS_STAT_CHART,starttime,endtime);
=======
        super(ChartType.PROFIT_CHART,starttime,endtime);
>>>>>>> master
    }
}
