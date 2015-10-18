package businesslogicservice.statisticblservice;

import java.util.ArrayList;

import businesslogic.util.ResultMsg;
import vo.SystemLogVO;

/**
 * 查询系统日志的逻辑接口
 * 
 * @author kylin
 *
 */
public interface LogInquiryBLService {
	
	/**
	 * 前置条件：用户选择查看系统日志功能
	 * 后置条件：系统在查询者输入关键词信息后，对信息的格式进行检查，如果错误给出相应反馈
	 * 
	 * @param keywords
	 * @return
	 */
	public ResultMsg inputKeywords(String keywords);
	
	/**
	 * 前置条件：用户输入正确格式的关键字
	 * 后置条件：系统显示所有匹配日的系统志查询结果
	 * 
	 * @param keywords
	 * @return
	 */
	public ArrayList<SystemLogVO> getLogInfo(String keywords);
	
}
