package businesslogicservice.commodityblservice._Stub;

import java.util.ArrayList;

import vo.GoodsVO;
import vo.StorageInVO;
import businesslogic.util.InventoryStatus;
import businesslogic.util.ResultMsg;
import businesslogicservice.commodityblservice.StorageInBLService;

public class StorageInBLService_Stub implements StorageInBLService{
	String date;
	ArrayList<GoodsVO> GoodsInStorageInfo;
	public StorageInBLService_Stub(){
		date = "2015-10-22";
		GoodsInStorageInfo = new ArrayList<GoodsVO>(); 
	}
	public StorageInBLService_Stub(String date,ArrayList<GoodsVO> GoodsInStorageInfo){
		this.date = date;
		this.GoodsInStorageInfo = GoodsInStorageInfo;
	}
	//输入入库单界面显示所有入库单
	@Override
	public ArrayList<StorageInVO> show() {
		// TODO Auto-generated method stub
		ArrayList<StorageInVO> list=new ArrayList<StorageInVO>();
		list.add(new StorageInVO(date,GoodsInStorageInfo));
		return list;
	}
//新增入库单
	@Override
	public ResultMsg addPutInStorgaeDoc(StorageInVO putInStorageVo) {
		if(putInStorageVo.getDate().equals("2015-11-11"))
			return new ResultMsg(true,"输入的入库单格式正确");
		else
			return new ResultMsg(false,"输入的入库单格式不正确");
	}
//提交入库单
	@Override
	public ResultMsg submitPutInStorageDoc(StorageInVO putInStorageVo) {
		if(putInStorageVo.getDate().equals("2015-11-11"))
			return new ResultMsg(true,"提交成功");
		else
			return new ResultMsg(false,"提交失败");
	}

	@Override
	public InventoryStatus alarm() {
		GoodsInStorageInfo =new ArrayList<GoodsVO>();
		
		if(date.equals("2011-11-11"))
			return InventoryStatus.SAFE;
		
			else
		return InventoryStatus.DANGER;
	}
	
}
