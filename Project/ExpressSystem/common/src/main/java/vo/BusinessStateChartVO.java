package vo;

import util.enums.ChartType;

<<<<<<< HEAD
=======
import java.util.ArrayList;

>>>>>>> master
/**
 * Created by kylin on 15/11/21.
 */
public class BusinessStateChartVO extends ChartVO{

<<<<<<< HEAD
    //TODO 内容丰富一天一条
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
=======
    private ArrayList<Double> profix;
    private ArrayList<Double> growthRate;

    public BusinessStateChartVO(String starttime, String endtime, ArrayList<Double> profix,
                                ArrayList<Double> growthRate) {
        super(ChartType.BUSINESS_STAT_CHART,starttime,endtime);
        this.profix = profix;
        this.growthRate = growthRate;
    }

    public BusinessStateChartVO(String starttime, String endtime){
        super(ChartType.BUSINESS_STAT_CHART,starttime,endtime);
    }

    public ArrayList<Double> getProfix() {
        return profix;
    }

    public ArrayList<Double> getGrowthRate() {
>>>>>>> master
        return growthRate;
    }

}
