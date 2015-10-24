package businesslogicservice.commodityblservice;

import java.util.ArrayList;

import businesslogic.util.ResultMsg;
import vo.StorageOutVO;

public interface StorageOutBLService {
	
	/**
	 * 显示出库单信息
	 */
	public ArrayList<StorageOutVO> show();
	
	/**
	 * 输入出库单信息
	 * 后置条件：系统检查输入信息格式，并给出反馈
	 * @param storageOutVo
	 * @return
	 */
	public ResultMsg addStorageOutDoc(StorageOutVO storageOutVo);
	
	/**
	 * 提交出库单
	 * 前置条件：出库单信息格式无误
	 * 后置条件；返回提交结果
	 * @param storageOutVo
	 * @return
	 */
	public ResultMsg submitStorageOutDoc(StorageOutVO storageOutVo);
	
}
