/**
 * 库存盘点
 * @author wwz
 * @data  2015/10/17
 */
package businesslogicservice.commodityblservice;

import java.util.ArrayList;

import businesslogic.util.ResultMsg;
import vo.InventoryVO;

public interface StorageInquiryAllBLService {
	
	/**
	 * 设置第一个时间点
	 * 前置条件；本次盘点为第一次盘点
	 * 后置条件：系统检查时间格式是否正确，逻辑是否正确
	 * @param firstTime
	 * @return
	 */
	public ResultMsg inputFirst(String firstTime);
	
	
	

}
