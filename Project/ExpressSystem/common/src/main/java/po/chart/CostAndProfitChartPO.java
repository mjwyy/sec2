package po.chart;

import po.ChartPO;
import util.enums.ChartType;
<<<<<<< HEAD
=======

import java.util.ArrayList;
>>>>>>> master

public class CostAndProfitChartPO extends ChartPO {

	private static final long serialVersionUID = 7891756031310926806L;
<<<<<<< HEAD
	private double cost;
	private double profit;
	
	public CostAndProfitChartPO(String starttime, String endtime, double cost,
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

    public CostAndProfitChartPO(String starttime, String endtime){
        super(ChartType.BUSINESS_STAT_CHART,starttime,endtime);
=======
    private ArrayList<Double> cost;
    private ArrayList<Double> profit;

    public CostAndProfitChartPO(String starttime, String endtime, ArrayList<Double> cost,
                                ArrayList<Double> profit) {
        super(ChartType.PROFIT_CHART,starttime,endtime);
        this.cost = cost;
        this.profit = profit;
    }

    public ArrayList<Double> getCost() {
        return cost;
    }

    public ArrayList<Double> getProfit() {
        return profit;
    }

    public CostAndProfitChartPO(String starttime, String endtime){
        super(ChartType.PROFIT_CHART,starttime,endtime);
>>>>>>> master
    }
	
}
