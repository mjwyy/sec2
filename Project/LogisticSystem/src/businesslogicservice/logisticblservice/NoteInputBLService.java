package businesslogicservice.logisticblservice;

import businesslogic.util.ResultMsg;
import vo.NoteVO;

/**
 * 所有处理单据逻辑接口的父接口，定义了一些共同的逻辑操作
 * 具体的单据逻辑接口extends此接口
 *  
 * @author kylin
 *
 */
public interface NoteInputBLService {
	
	/**
	 * 前置条件：业务员要求输入单据信息
	 * 后置条件：系统检查单据信息的格式，反馈检查结果
	 * 
	 * @param noteVO 单据VO
	 * @return 单据信息格式检查结果
	 */
	public ResultMsg inputNote(NoteVO noteVO);
	
	/**
	 * 前置条件：业务员核对单据信息后要求提交单据
	 * 后置条件：系统提示单据信息录入成功，并提交单据给总经理审批
	 * 
	 * @param noteVO 单据VO
	 * @return 
	 */
	public ResultMsg submitNote(NoteVO noteVO);
	
}
