/**
 * 入库处理业务逻辑接口
 * @author wwz
 * @data 2015/10/17
 */
package businesslogicservice.commodityblservice;

import java.util.ArrayList;

import businesslogic.util.InventoryStatus;
import businesslogic.util.ResultMsg;
import vo.StorageInVO;

public interface StorageInBLService {
	/**
	 * 显示入库单信息
	 * @return 信息列表
	 */
	public ArrayList<StorageInVO> show();
	
	/**
	 * 新增入库单
	 * @param putInStorageVo
	 * @return
	 */
	public ResultMsg addPutInStorgaeDoc(StorageInVO putInStorageVo);
	
	/**
	 * 提交入库单信息
	 * @param putInStorageVo
	 * @return
	 */
   public ResultMsg submitPutInStorageDoc(StorageInVO putInStorageVo);
   
   /**
    * 库存呢报警
    * @return
    */
   public InventoryStatus alarm();

      
}
