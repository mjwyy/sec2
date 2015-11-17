package businesslogic.statistic;

import businesslogicservice.statisticblservice.ChartOutputBLService;
import util.ResultMsg;
import util.enums.ChartType;
import vo.ChartVO;

/**
 * Created by kylin on 15/11/17.
 */
public class ChartOutput implements ChartOutputBLService {
    @Override
    public ResultMsg enquiryChart(ChartType chartType, String time1, String time2) {
        return null;
    }

    @Override
    public ChartVO getChartVO(ChartType chartType, String time1, String time2) {
        return null;
    }

    @Override
    public ResultMsg exportChart(String path) {
        return null;
    }
}
