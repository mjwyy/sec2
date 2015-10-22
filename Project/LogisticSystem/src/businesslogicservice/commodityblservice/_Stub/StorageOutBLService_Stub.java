package businesslogicservice.commodityblservice;

import java.util.ArrayList;

import vo.StorageInVO;
import vo.StorageOutVO;
import businesslogic.util.ResultMsg;

public class StorageOutBLService_Stub implements StorageOutBLService{

	@Override
	public ArrayList<StorageOutVO> show(StorageOutVO storageOutVo) {
		ArrayList<StorageOutVO> list=new ArrayList<StorageOutVO>();
		ArrayList<String>barcode=new ArrayList<String>();
		barcode.add("1234567890");
		list.add(new StorageOutVO("2011-11-11","北京","025000201509091234567",
				"025000201510120000003","铁路",barcode));
		return list;
	}

	@Override
	public ResultMsg addStorageOutDoc(StorageOutVO storageOutVo) {
		if(storageOutVo.getDate().equals("2015-11-11"))
			return new ResultMsg(true,"输入的出库单格式正确");
		else
			return new ResultMsg(false,"输入的出库单格式不正确");
	}

	@Override
	public ResultMsg submitStorageOutDoc(StorageOutVO storageOutVo) {
		if(storageOutVo.getDate().equals("2015-11-11"))
			return new ResultMsg(true,"提交成功");
		else
			return new ResultMsg(false,"提交失败");
	}

}
