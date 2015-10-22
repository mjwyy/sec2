package businesslogicservice.logisticblservice;

import businesslogic.util.ResultMsg;
import vo.LoadNoteOnServiceVO;

public interface LoadNoteOnServiceBLService extends NoteInputBLService {

	/**
<<<<<<< HEAD
	 * 营业厅业务员输入营业厅装车单信息
	 *
=======
	 * 前置条件：营业厅业务员要求输入营业厅装车单
	 * 后置条件：系统检查单据信息的格式，反馈检查结果
	 * 
>>>>>>> master
	 * @param hallLoadDocVO 营业厅装车单VO
	 * @return 单据信息格式检查结果
	 */
	public ResultMsg inputHallLoadDoc(LoadNoteOnServiceVO hallLoadDocVO);
	
	/**
<<<<<<< HEAD
	 * 营业厅业务员核对信息后要求提交单据
=======
	 * 前置条件：营业厅业务员核对信息后要求提交单据
	 * 后置条件：系统提示单据信息录入成功，并提交单据给总经理审批
>>>>>>> master
	 * 
	 * @param hallLoadDocVO 营业厅装车单VO
	 * @return 
	 */
	public ResultMsg submitHallLoadDoc(LoadNoteOnServiceVO hallLoadDocVO);
	
}
