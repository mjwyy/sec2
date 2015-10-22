package businesslogicservice.statisticblservice._stub;

import businesslogic.util.ChartType;
import businesslogic.util.ResultMsg;
import vo.ChartVO;

/**
 * 财务人员或�?��?�经理（以下�?称用户）获取统计报表逻辑接口
 * 
 * @author kylin
 *
 */
public interface ChartOutputBLService {

	/**
	 * 前置条件：用户发起查看报表操�?
	 * 后置条件：系统请求用户输入统计数据的起止时间
	 * 
	 * 
	 * @param chartType 报表类型
	 * @param time1 起点时间
	 * @param time2 终点时间
	 * @return
	 */
	public ResultMsg enquiryChart(ChartType chartType,String time1,String time2);
	
	/**
	 * 前置条件：用户�?�择了报表类型并输入了正确的起止时间
	 * 后置条件：系统显示起止时间内的相应类型的报表信息
	 * 
	 * @return
	 */
	public ChartVO getChartVO();
	
	/**
	 * 前置条件：用户发起导出报表操作请�?
	 * 后置条件：系统向指定的位置导出相应报�?
	 * 
	 * @param path
	 */
	public ResultMsg exportChart(String path);
}
