package businesslogicservice.statisticblservice._stub;

import java.util.ArrayList;

import businesslogic.util.DocType;
import vo.NoteVO;

/**
 * 总经理审批单据的逻辑接口
 * 
 * @author kylin
 *
 */
public interface NoteApprovingBLService {

	/**
	 * 前置条件：�?�经理开始审批单据的操作
	 * 后置条件：返回所有未审批的单据信�?
	 * 
	 * @return
	 */
	public ArrayList<NoteVO> getAllDoc();
	
	/**
	 * 前置条件：�?�经理开始审批单据操�?
	 * 后置条件：系统显示相应类型的单据详细信息
	 * 
	 * @param type
	 * @return
	 */
	public ArrayList<NoteVO> getDocByType(DocType type);
	
	/**
	 * 前置条件：�?�经理开始审批单据操�?
	 * 后置条件：系统�?�过�?有单据的审批，提示相应业务员单据审批通过
	 * 
	 */
	public void passAllDoc();

	/**
	 * 前置条件：�?�经理从未审批单据中选取了一个单�?
	 * 后置条件：系统�?�过此单据的审批，提示相应业务员单据审批通过
	 * 
	 * @param docVO
	 */
	public void passDoc(NoteVO docVO);
	
	/**
	 * 前置条件：�?�经理从未审批单据中选取了一个单�?
	 * 后置条件：系统不通过相应的单据审批，要求总经理输入审批意�?
	 * 
	 * @param docVO
	 */
	public void failDoc(NoteVO docVO);
	
	/**
	 * 前置条件：�?�经理不通过相应的单据审�?
	 * 后置条件：系统提示相关业务员单据审批未�?�过，将单据返回，要求业务员重新输入
	 * 
	 * @param advice
	 */
	public void inputAdvice(NoteVO docVO,String advice);
	
}
