package businesslogicservice.logisticblservice;

import businesslogic.logisticbl.ResultMsg;
import businesslogic.logisticbl.sendDocMsg;
import vo.SendDocVO;

/**
 * 输入寄件单逻辑接口
 * 
 * @author kylin
 *
 */
public interface SendDocInput02BLService {

	/**
	 * 前置条件：快递员要求输入寄件单
	 * 后置条件：系统检查单据信息的格式，反馈检查结果
	 * 
	 * @param sendDocVO 寄件单VO
	 * @return 单据信息格式检查结果
	 */
	public ResultMsg addSendDoc(SendDocVO sendDocVO);
	
	/**
	 * 前置条件：快递员核对信息后要求提交单据
	 * 后置条件：系统提示单据信息录入成功，显示寄件报价、预计到达日期,并􏰁交由总经理审批
	 * 
	 * @param sendDocVO 寄件单VO
	 * @return 寄件报价、预计到达日期信息
	 */
	public sendDocMsg submitSecdDoc(SendDocVO sendDocVO);
	
}
