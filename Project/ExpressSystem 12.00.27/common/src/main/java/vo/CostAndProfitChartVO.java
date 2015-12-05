package vo;

import util.chart.CostAndProfitContent;
import util.enums.ChartType;

import java.util.ArrayList;

/**
 * Created by kylin on 15/11/21.
 */
public class CostAndProfitChartVO extends ChartVO {

    private ArrayList<CostAndProfitContent> costAndProfitContents;

    public CostAndProfitChartVO(ChartType type, String time1, String time2,
                                ArrayList<CostAndProfitContent> costAndProfitContents) {
        super(type, time1, time2);
        this.costAndProfitContents = costAndProfitContents;
    }

    public CostAndProfitChartVO(String starttime, String endtime){
        super(ChartType.PROFIT_CHART,starttime,endtime);
    }

    public ArrayList<CostAndProfitContent> getCostAndProfitContents() {
        return costAndProfitContents;
    }
}
