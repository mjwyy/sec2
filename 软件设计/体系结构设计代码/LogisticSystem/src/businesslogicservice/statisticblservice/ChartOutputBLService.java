package businesslogicservice.statisticblservice;

import businesslogic.logisticbl.ChartType;
import businesslogic.logisticbl.ResultMsg;
import vo.ChartVO;

/**
 * 财务人员或者总经理（以下简称用户）获取统计报表逻辑接口
 * 
 * @author kylin
 *
 */
public interface ChartOutputBLService {

	/**
	 * 前置条件：用户发起查看报表操作
	 * 后置条件：系统请求用户输入统计数据的起止时间
	 * 
	 * @param chartType
	 */
	public void selectChart(ChartType chartType);
	
	/**
	 * 前置条件：用户已经选择报表类型
	 * 后置条件：系统检查用户输入时间的格式与逻辑正确性，如果错误给出反馈
	 * 
	 * @param time1
	 * @param time2
	 */
	public ResultMsg inputTime(String time1,String time2);
	
	/**
	 * 前置条件：用户输入了正确的起止时间
	 * 后置条件：系统显示起止时间内的相应类型的报表信息
	 * 
	 * @return
	 */
	public ChartVO submitInput();
	
	/**
	 * 前置条件：用户发起导出报表操作请求
	 * 后置条件：系统向指定的位置导出相应报表
	 * 
	 * @param path
	 */
	public ResultMsg exportChart(String path);
	
}
