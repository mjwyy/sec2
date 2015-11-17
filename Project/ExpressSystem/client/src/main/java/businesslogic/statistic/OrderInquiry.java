package businesslogic.statistic;

import businesslogicservice.statisticblservice.OrderInquiryBLService;
import util.ResultMsg;
import vo.OrderVO;

/**
 * Created by kylin on 15/11/17.
 */
public class OrderInquiry implements OrderInquiryBLService {
    @Override
    public ResultMsg inputBarcode(String inputBarcode) {
        return null;
    }

    @Override
    public OrderVO submitBarcode(String inputBarcode) {
        return null;
    }
}
