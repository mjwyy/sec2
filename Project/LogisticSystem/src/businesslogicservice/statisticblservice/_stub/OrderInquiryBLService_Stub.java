package businesslogicservice.statisticblservice._stub;

import businesslogic.util.ResultMsg;
import businesslogicservice.statisticblservice.OrderInquiryBLService;
import vo.OrderVO;

public class OrderInquiryBLService_Stub implements OrderInquiryBLService {

	@Override
	public ResultMsg inputBarcode(String inputBarcode) {
		System.out.println("inputBarcode succeed");
		return new ResultMsg(true,null);
	}

	@Override
	public OrderVO submitBarcode(String inputBarcode) {
		System.out.println("submitBarcode succeed");
		return new OrderVO(null,null, null);
	}

}
