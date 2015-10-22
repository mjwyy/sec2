package businesslogicservice.logisticblservice;

import businesslogic.util.ResultMsg;
import vo.TransitNoteOnTransitVO;

public interface TransitNoteInputBLService extends NoteInputBLService {

	/**
<<<<<<< HEAD
	 * 中转中心业务员输入中转中心中转单信息
	 *
=======
	 * 前置条件：中转中心业务员要求输入中转中心中转单
	 * 后置条件：系统检查单据信息的格式，反馈检查结果
	 * 
>>>>>>> master
	 * @param centerTransitDocVO 中转中心中转单VO
	 * @return 单据信息格式检查结果
	 */
	public ResultMsg inputCenterTransitDoc(TransitNoteOnTransitVO centerTransitDocVO);
	
	/**
<<<<<<< HEAD
	 * 中转中心业务员核对信息后要求提交单据
=======
	 * 前置条件：中转中心业务员核对信息后要求提交单据
	 * 后置条件：系统提示单据信息录入成功，并提交单据给总经理审批
>>>>>>> master
	 * 
	 * @param centerTransitDocVO 中转中心中转单VO
	 * @return 
	 */
	public ResultMsg submitCenterTransitDoc(TransitNoteOnTransitVO centerTransitDocVO);
	
}
