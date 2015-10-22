package businesslogicservice.commodityblservice;

import java.util.ArrayList;

import businesslogic.util.ResultMsg;
import vo.StorageInVO;
import vo.StorageOutVO;

public interface StorageOutBLService {
	
	/**
	 * 显示出库单信息
	 * @param storageOutVo
	 * @return
	 */
	public ArrayList<StorageOutVO> show(StorageOutVO storageOutVo);
	
	/**
	 * 输入出库单信息
	 * @param putInStorageVo
	 * @return
	 */
	public ResultMsg addStorageOutDoc(StorageOutVO storageOutVo);
	
	/**
	 * 提交出库单
	 * @param storageOutVo
	 * @return
	 */
	public ResultMsg submitStorageOutDoc(StorageOutVO storageOutVo);
	
}
