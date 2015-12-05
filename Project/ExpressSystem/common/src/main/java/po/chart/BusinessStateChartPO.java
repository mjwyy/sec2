package po.chart;
/**
 * @author wwz
 * @time 2015/11/15
 */
import po.ChartPO;
import util.chart.BusinessStateContent;
import util.enums.ChartType;
import vo.BusinessStateChartVO;

import java.util.ArrayList;

public class BusinessStateChartPO extends ChartPO {

	private static final long serialVersionUID = -1229391901851695868L;

    private ArrayList<BusinessStateContent> contents;

    public BusinessStateChartPO(String starttime, String endtime){
        super(ChartType.BUSINESS_STAT_CHART,starttime,endtime);
    }

    public BusinessStateChartPO(ChartType type, String startTime, String endTime, ArrayList<BusinessStateContent> contents) {
        super(type, startTime, endTime);
        this.contents = contents;
    }

    public BusinessStateChartVO toVO() {
        return new BusinessStateChartVO(this.getStartTime(),this.getEndTime(),this.getContents());
    }

    public ArrayList<BusinessStateContent> getContents() {
        return contents;
    }

    public void setContents(ArrayList<BusinessStateContent> contents) {
        this.contents = contents;
    }

}
