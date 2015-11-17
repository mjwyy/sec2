package businesslogic.statistic;

import businesslogicservice.statisticblservice.LogInquiryBLService;
import util.ResultMsg;
import vo.SystemLogVO;

import java.util.ArrayList;

/**
 * Created by kylin on 15/11/17.
 */
public class LogInquiry implements LogInquiryBLService {
    @Override
    public ResultMsg inputKeywords(SystemLogVO log) {
        return null;
    }

    @Override
    public ArrayList<SystemLogVO> getLogInfo(SystemLogVO log) {
        return null;
    }
}
