package businesslogicservice.logisticblservice;

import businesslogic.logisticbl.ResultMsg;
import vo.ReceiveDocVO;

/**
 * 输入收件单逻辑接口
 * 
 * @author kylin
 *
 */
public interface ReceiveDocInput03BLService {

	/**
	 * 前置条件：快递员要求输入收件单
	 * 后置条件：系统显示报价，预计到达日期等，单据信息提交审批
	 * 
	 * @param receiveDoc 收件单VO
	 * @return 
	 */
	public ResultMsg addReceiveDoc(ReceiveDocVO receiveDocVO);
	
}
