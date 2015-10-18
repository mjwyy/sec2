package businesslogicservice.logisticblservice;

import businesslogic.logisticbl.ResultMsg;
import vo.ReceingNoteVO;

/**
 * 输入收件单逻辑接口
 * 
 * @author kylin
 *
 */
public interface ReceivingNoteInputBLService {
	
	/**
	 * 前置条件：快递员要求输入收件单
	 * 后置条件：系统检查单据信息的格式，反馈检查结果
	 * 
	 * @param receiveDocVO 收件单VO
	 * @return 单据信息格式检查结果
	 */
	public ResultMsg addReceiveDoc(ReceingNoteVO receiveDocVO);
	
	/**
	 * 前置条件：快递员核对信息后要求提交单据
	 * 后置条件：系统提示单据信息录入成功，并提交单据给总经理审批
	 * 
	 * @param receiveDocVO 收件单VO
	 * @return 寄件报价、预计到达日期信息
	 */
	public ResultMsg submitSecdDoc(ReceingNoteVO receiveDocVO);
	
}
