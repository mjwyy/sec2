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
	 * 业务员输入单据信息
	 *
	 * @param noteVO 单据VO
	 * @return 单据信息格式检查结果
	 */
	public ResultMsg inputNote(NoteVO noteVO);
	
	/**
	 * 业务员核对信息后要求提交单据
	 * 
	 * @param noteVO 单据VO
	 * @return 
	 */
	public ResultMsg submitNote(NoteVO noteVO);
	
}
