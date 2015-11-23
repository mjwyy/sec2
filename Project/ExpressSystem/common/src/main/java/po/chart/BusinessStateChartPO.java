package po.chart;
/**
 * @author wwz
 * @time 2015/11/15
 */
import po.ChartPO;
import util.enums.ChartType;
<<<<<<< HEAD
=======

import java.util.ArrayList;
>>>>>>> master

public class BusinessStateChartPO extends ChartPO {

	private static final long serialVersionUID = -1229391901851695868L;
<<<<<<< HEAD
	private double profix;
	private double growthRate;
	
	public BusinessStateChartPO(String starttime, String endtime, double profix,
			double growthRate) {
        super(ChartType.BUSINESS_STAT_CHART,starttime,endtime);
		this.profix = profix;
		this.growthRate = growthRate;
		
	}
=======
    private ArrayList<Double> profix;
    private ArrayList<Double> growthRate;

    public BusinessStateChartPO(String starttime, String endtime, ArrayList<Double> profix,
                                ArrayList<Double> growthRate) {
        super(ChartType.BUSINESS_STAT_CHART,starttime,endtime);
        this.profix = profix;
        this.growthRate = growthRate;
    }
>>>>>>> master

    public BusinessStateChartPO(String starttime, String endtime){
        super(ChartType.BUSINESS_STAT_CHART,starttime,endtime);
    }

<<<<<<< HEAD
	public double getProfix() {
		return profix;
	}

	public double getGrowthRate() {
		return growthRate;
	}
=======
    public ArrayList<Double> getProfix() {
        return profix;
    }

    public ArrayList<Double> getGrowthRate() {
        return growthRate;
    }
>>>>>>> master

}
