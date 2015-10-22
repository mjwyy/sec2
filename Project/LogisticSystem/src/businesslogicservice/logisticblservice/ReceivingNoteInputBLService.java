package businesslogicservice.logisticblservice;

import businesslogic.util.ResultMsg;
import vo.ReceingNoteVO;

/**
 * 输入收件单逻辑接口
 * 
 * @author kylin
 *
 */
public interface ReceivingNoteInputBLService extends NoteInputBLService {
	
	/**
<<<<<<< HEAD
	 * 快递员输入收件单信息
	 *
=======
	 * 前置条件：快递员要求输入收件单
	 * 后置条件：系统检查单据信息的格式，反馈检查结果
	 * 
>>>>>>> master
	 * @param receiveDocVO 收件单VO
	 * @return 单据信息格式检查结果
	 */
	public ResultMsg inputReceiveDoc(ReceingNoteVO receiveDocVO);
	
	/**
<<<<<<< HEAD
	 * 快递员核对信息后要求提交单据
=======
	 * 前置条件：快递员核对信息后要求提交单据
	 * 后置条件：系统提示单据信息录入成功，并提交单据给总经理审批
>>>>>>> master
	 * 
	 * @param receiveDocVO 收件单VO
	 * @return 寄件报价、预计到达日期信息
	 */
	public ResultMsg submitSecdDoc(ReceingNoteVO receiveDocVO);
	
}
