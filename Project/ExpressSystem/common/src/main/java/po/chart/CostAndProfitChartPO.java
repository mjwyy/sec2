package po.chart;

import po.ChartPO;
import util.chart.BusinessStateContent;
import util.enums.ChartType;

import java.util.ArrayList;

public class CostAndProfitChartPO extends ChartPO {

	private static final long serialVersionUID = 7891756031310926806L;

    private ArrayList<BusinessStateContent> contents;

    public CostAndProfitChartPO(String starttime, String endtime){
        super(ChartType.PROFIT_CHART,starttime,endtime);
    }

    public ArrayList<BusinessStateContent> getContents() {
        return contents;
    }


}
