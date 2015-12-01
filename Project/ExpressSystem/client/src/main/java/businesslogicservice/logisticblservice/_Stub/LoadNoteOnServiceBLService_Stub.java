package businesslogicservice.logisticblservice._Stub;

import java.util.ArrayList;

import vo.LoadNoteOnServiceVO;
import businesslogicservice.logisticblservice.LoadNoteOnServiceBLService;
import util.ResultMsg;

public class LoadNoteOnServiceBLService_Stub implements LoadNoteOnServiceBLService{
	public LoadNoteOnServiceBLService_Stub(){

	}
	//输入营业厅装车单界面得到对输入的装车单的反馈检查结果
	public ResultMsg inputHallLoadDoc(LoadNoteOnServiceVO hallLoadDocVO) {
		ResultMsg formatCheck = hallLoadDocVO.checkFormat();
        return formatCheck;
	}
	//输入营业厅装车单界面得到对提交的装车单的反馈结果
	public ResultMsg submitHallLoadDoc(LoadNoteOnServiceVO hallLoadDocVO) {
		ArrayList<String> bar=new ArrayList<String>();
		bar.add("1234567890");
		if(hallLoadDocVO.getBarcodes().equals(bar))
			return new ResultMsg(true,"提交成功");
		else
			return new ResultMsg(false,"提交失败");
	}


}
