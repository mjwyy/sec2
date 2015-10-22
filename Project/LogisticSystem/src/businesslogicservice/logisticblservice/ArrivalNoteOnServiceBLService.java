package businesslogicservice.logisticblservice;

import vo.DeliverNoteOnServiceVO;
import businesslogic.util.ResultMsg;
import vo.ArrivalNoteOnServiceVO;

/**
 * 处理营业厅到达件，录入到达单与派件单的逻辑接口
 * 
 * @author kylin
 *
 */
public interface ArrivalNoteOnServiceBLService extends NoteInputBLService {
	/**
	 * 前置条件：营业厅业务员要求输入到达单
	 * 后置条件：系统检查单据信息的格式，反馈检查结果
	 * 
	 * @param arrialDocVO 到达单VO
	 * @return 单据信息格式检查结果
	 */
	public ResultMsg inputHallArrivalDoc(ArrivalNoteOnServiceVO arrialDocVO);
	
	/**
	 * 前置条件：营业厅业务员核对信息后要求提交单据
	 * 后置条件：系统提示单据信息录入成功，并提交单据给总经理审批
	 * 
	 * @param arrialDocVO 到达单VO
	 * @return 
	 */
	public ResultMsg submitHallArrivalDoc(ArrivalNoteOnServiceVO arrialDocVO);
	
	/**
	 * 前置条件：营业厅业务员要求输入派件
	 * 后置条件：系统检查单据信息的格式，反馈检查结果
	 * 
	 * @param deliverDocVO 派件单VO
	 * @return 单据信息格式检查结果
	 */
	public ResultMsg inputHallDeliverDoc(DeliverNoteOnServiceVO deliverDocVO);
	
	/**
	 * 前置条件：营业厅业务员核对信息后要求提交单据
	 * 后置条件：系统提示单据信息录入成功，并提交单据给总经理审批
	 * 
	 * @param deliverDocVO 派件单VO
	 * @return 
	 */
	public ResultMsg submitHallDeliverDoc(DeliverNoteOnServiceVO deliverDocVO);
	
}
