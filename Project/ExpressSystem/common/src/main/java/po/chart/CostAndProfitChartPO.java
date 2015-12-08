package po.chart;

import po.ChartPO;
import util.enums.ChartType;
import vo.CostAndProfitChartVO;
import util.chart.CostAndProfitContent;

import java.util.ArrayList;

public class CostAndProfitChartPO extends ChartPO {

	private static final long serialVersionUID = 7891756031310926806L;

    private ArrayList<CostAndProfitContent> contents;

    public CostAndProfitChartPO(String starttime, String endtime){
        super(ChartType.PROFIT_CHART,starttime,endtime);
    }

    public CostAndProfitChartPO(ChartType type, String startTime, String endTime, ArrayList<CostAndProfitContent> contents) {
        super(type, startTime, endTime);
        this.contents = contents;
    }

    public ArrayList<CostAndProfitContent> getContents() {
        return contents;
    }


    public CostAndProfitChartVO toVO() {
        return new CostAndProfitChartVO(ChartType.PROFIT_CHART,this.getStartTime(),this.getEndTime(),this.contents);
    }

    public void setContents(ArrayList<CostAndProfitContent> contents) {
        this.contents = contents;
    }
}
