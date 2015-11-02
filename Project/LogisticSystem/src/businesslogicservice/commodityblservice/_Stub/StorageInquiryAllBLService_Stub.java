package businesslogicservice.commodityblservice._Stub;

import java.util.ArrayList;

import businesslogic.util.ResultMsg;
import businesslogicservice.commodityblservice.StorageInquiryAllBLService;
import vo.InventoryVO;

public class StorageInquiryAllBLService_Stub implements StorageInquiryAllBLService {

	@Override
	public ResultMsg inputFirst(String firstTime) {
		if(firstTime.equals("2011-11-11"))
			return new ResultMsg(true,"success");
		else
			return new ResultMsg(false,"failure");
	}

	@Override
	public ArrayList<InventoryVO> request() {
		return null;
	}
}
