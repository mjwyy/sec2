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
	
	/**
	 * 请求进行库存盘点
	 * 前置条件：库存管理人员请求进行库存盘点
	 * 后置条件：系统检查是否为本次第一次盘点，返回检查结果，若已经进行了盘点，则拒绝再次盘点
	 * @return
	 */
	public ResultMsg request();
	
	/**
	 * 系统要求确认进行盘点
	 * 前置条件：系统允许进行本日盘点
	 * 后置条件：若确认盘点，则系统在当前时间生成新的盘点时间点，统计这一时间段的库存信息并显示
	 * @return
	 */
	public ArrayList<InventoryVO> show();
	
	
	

}
