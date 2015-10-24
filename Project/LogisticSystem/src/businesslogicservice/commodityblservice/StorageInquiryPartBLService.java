/**
 * 库存查看
 * @author wwz
 * @data  2015/10/17
 */

package businesslogicservice.commodityblservice;

import java.util.ArrayList;

import businesslogic.util.ResultMsg;
import vo.InventoryVO;

public interface StorageInquiryPartBLService {
	
	/**
	 * 输入查看时间段
	 * 前置条件：库存管理人员要求进行库存查看
	 * 后置条件：系统在库存管理人员输入时间选择提交后，对结果进行格式检查
	 * @param time1
	 * @param time2
	 * @return
	 */
  public ResultMsg inputTime(String time1,String time2);
 
  /**
   * 显示该时间段的信息
   * 前置条件：时间格式无误，逻辑无误
   * 后置条件；系统显示信息，系统日志记录
   * @param time1
   * @param time2
   * @return
   */
  public ArrayList<InventoryVO> show(String time1,String time2);
  


}
