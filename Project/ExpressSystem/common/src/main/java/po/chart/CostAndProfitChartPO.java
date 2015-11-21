package po.chart;

import po.ChartPO;
import util.enums.ChartType;

public class CostAndProfitChartPO extends ChartPO {

	private static final long serialVersionUID = 7891756031310926806L;
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
    }
	
}
