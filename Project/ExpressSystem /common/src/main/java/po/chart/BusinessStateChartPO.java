package po.chart;
/**
 * @author wwz
 * @time 2015/11/15
 */
import po.ChartPO;
import util.enums.ChartType;

public class BusinessStateChartPO extends ChartPO {

	private static final long serialVersionUID = -1229391901851695868L;
	private  ChartType BUSINESS_STAT_CHART;
	private String starttime;
	private String endtime;
	private double profix;
	private double growthRate;
	
	public BusinessStateChartPO(String starttime, String endtime, double profix,
			double growthRate) {
		super();
		this.starttime = starttime;
		this.endtime = endtime;
		this.profix = profix;
		this.growthRate = growthRate;
		
	}
	
	public String getStarttime() {
		return starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public double getProfix() {
		return profix;
	}

	public double getGrowthRate() {
		return growthRate;
	}
	public  ChartType getType() {
		return BUSINESS_STAT_CHART;
	}
	
	

}
