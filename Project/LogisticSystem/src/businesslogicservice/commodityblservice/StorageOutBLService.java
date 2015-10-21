package businesslogicservice.commodityblservice;

import java.util.ArrayList;

import businesslogic.util.ResultMsg;
import vo.StorageInVO;
import vo.StorageOutVO;

public interface StorageOutBLService {
	
	/**
	 * 显示出库单信息
	 * 前置条件：库存关系人员要求显示出库单信息
	 * 后置条件；无
	 * @param storageOutVo
	 * @return
	 */
	public ArrayList<StorageOutVO> show(StorageOutVO storageOutVo);
	
	/**
	 * 输入出库单信息
	 * 前置条件：库存管理人员要求生成出库单
	 * 后置条件：系统检查输入信息格式，并给出反馈
	 * @param putInStorageVo
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
