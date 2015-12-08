package vo;

import util.chart.BusinessStateContent;
import util.enums.ChartType;

import java.util.ArrayList;

/**
 * Created by kylin on 15/11/21.
 */
public class BusinessStateChartVO extends ChartVO{

    private ArrayList<BusinessStateContent> contents;

    public BusinessStateChartVO(String starttime, String endtime,ArrayList<BusinessStateContent> contents) {
        super(ChartType.BUSINESS_STAT_CHART,starttime,endtime);
        this.contents = contents;
    }

    public BusinessStateChartVO(String starttime, String endtime){
        super(ChartType.BUSINESS_STAT_CHART,starttime,endtime);
    }

    public ArrayList<BusinessStateContent> getContents() {
        return contents;
    }
}
