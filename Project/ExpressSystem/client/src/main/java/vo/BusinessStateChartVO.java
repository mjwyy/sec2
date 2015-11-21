package vo;

import util.enums.ChartType;

/**
 * Created by kylin on 15/11/21.
 */
public class BusinessStateChartVO extends ChartVO{

    private double profix;
    private double growthRate;

    public BusinessStateChartVO(String starttime, String endtime, double profix,
                                double growthRate) {
        super(ChartType.BUSINESS_STAT_CHART,starttime,endtime);
        this.profix = profix;
        this.growthRate = growthRate;

    }

    public double getProfix() {
        return profix;
    }

    public double getGrowthRate() {
        return growthRate;
    }

}
