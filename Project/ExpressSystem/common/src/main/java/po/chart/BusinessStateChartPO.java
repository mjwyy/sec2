package po.chart;
/**
 * @author wwz
 * @time 2015/11/15
 */
import po.ChartPO;
import util.enums.ChartType;

public class BusinessStateChartPO extends ChartPO {

	private static final long serialVersionUID = -1229391901851695868L;
	private double profix;
	private double growthRate;
	
	public BusinessStateChartPO(String starttime, String endtime, double profix,
			double growthRate) {
        super(ChartType.BUSINESS_STAT_CHART,starttime,endtime);
		this.profix = profix;
		this.growthRate = growthRate;
		
	}

    public BusinessStateChartPO(String starttime, String endtime){
        super(ChartType.BUSINESS_STAT_CHART,starttime,endtime);
    }

	public double getProfix() {
		return profix;
	}

	public double getGrowthRate() {
		return growthRate;
	}

}
