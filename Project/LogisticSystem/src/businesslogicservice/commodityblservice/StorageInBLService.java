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
	 * 前置条件：库存管理人员要求显示入库单信息列表
	 * 后置条件：无
	 * @return 信息列表
	 */
	public ArrayList<StorageInVO> show();
	
	/**
	 * 新增入库单
	 * 前置条件：库存管理人员输入入库单信息，选择提交
	 * 后置条件：系统检查单据信息格式，反馈检查结果
	 * @param putInStorageVo
	 * @return
	 */
	public ResultMsg addPutInStorgaeDoc(StorageInVO putInStorageVo);
	
	/**
	 * 提交入库单信息
	 * 前置条件：入库单格式信息没有错误
	 * 后置条件：系统反馈提交结果
	 * @param putInStorageVo
	 * @return
	 */
   public ResultMsg submitPutInStorageDoc(StorageInVO putInStorageVo);
   
   /**
    * 库存报警
    * 前置条件：库存超过最大警戒线
    * 后置条件：系统发出提示
    * @return
    */
   public InventoryStatus alarm();

      
}
