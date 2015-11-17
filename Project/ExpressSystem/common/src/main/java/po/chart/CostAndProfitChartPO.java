package po.chart;

import po.ChartPO;
import util.enums.ChartType;

public class CostAndProfitChartPO extends ChartPO {

	private static final long serialVersionUID = 7891756031310926806L;
	private ChartType PROFIT_CHART;
	private String starttime;
	private String endtime;
	private double cost;
	private double profit;
	
	public CostAndProfitChartPO(String starttime, String endtime, double cost,
			double profit) {
		super();
		this.starttime = starttime;
		this.endtime = endtime;
		this.cost = cost;
		this.profit = profit;
		//this.type = PROFIT_CHART;
	}

	

	public ChartType getType() {
		return PROFIT_CHART;
	}

	public String getStarttime() {
		return starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public double getCost() {
		return cost;
	}

	public double getProfit() {
		return profit;
	}


	
	

}
