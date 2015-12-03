package businesslogicservice.commodityblservice._Stub;

import java.util.ArrayList;

import vo.InventoryVO;
import businesslogicservice.commodityblservice.StorageInquiryPartBLService;
import util.FormatCheck;
import util.ResultMsg;

public class StorageInquiryPartBLService_Stub implements StorageInquiryPartBLService{

	public ResultMsg inputTime(String time1, String time2) {
		   ResultMsg[] msg = new ResultMsg[2];
	        
	        msg[0] = FormatCheck.isInventoryTime(time1);
	        msg[1] = FormatCheck.isInventoryTime(time2);
	        
	        for(int i=0;i<msg.length;i++) {
	        	if(!msg[i].isPass()) return msg[i];
	        }
	        
	        return new ResultMsg(true);
	}
	public ArrayList<InventoryVO> show(String time1, String time2) {
		return new ArrayList<InventoryVO>();
	}

}
