package businesslogicservice.commodityblservice._Stub;

import vo.StorageOutVO;
import businesslogicservice.commodityblservice.StorageOutBLService;
import util.ResultMsg;

public class StorageOutBLService_Stub implements StorageOutBLService{

	public ResultMsg addStorageOutDoc(StorageOutVO storageOutVo) {
		ResultMsg msg = storageOutVo.checkFormat();
    	return msg;
	}

	public ResultMsg submitStorageOutDoc(StorageOutVO storageOutVo) {
		if(storageOutVo.getDate().equals("2015-11-11"))
			return new ResultMsg(true,"提交成功");
		else
			return new ResultMsg(false,"提交失败");
	}

}
