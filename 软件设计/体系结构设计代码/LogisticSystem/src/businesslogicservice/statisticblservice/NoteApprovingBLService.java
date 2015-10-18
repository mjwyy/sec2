package businesslogicservice.statisticblservice;

import java.util.ArrayList;

import businesslogic.logisticbl.DocType;
import vo.DocVO;

/**
 * 总经理审批单据的逻辑接口
 * 
 * @author kylin
 *
 */
public interface NoteApprovingBLService {

	/**
	 * 前置条件：总经理开始审批单据的操作
	 * 后置条件：返回所有未审批的单据信息
	 * 
	 * @return
	 */
	public ArrayList<DocVO> getAllDoc();
	
	/**
	 * 前置条件：总经理开始审批单据操作
	 * 后置条件：系统显示相应类型的单据详细信息
	 * 
	 * @param type
	 * @return
	 */
	public ArrayList<DocVO> getDocByType(DocType type);
	
	/**
	 * 前置条件：总经理开始审批单据操作
	 * 后置条件：系统通过所有单据的审批，提示相应业务员单据审批通过
	 * 
	 */
	public void passAllDoc();

	/**
	 * 前置条件：总经理从未审批单据中选取了一个单据
	 * 后置条件：系统通过此单据的审批，提示相应业务员单据审批通过
	 * 
	 * @param docVO
	 */
	public void passDoc(DocVO docVO);
	
	/**
	 * 前置条件：总经理从未审批单据中选取了一个单据
	 * 后置条件：系统不通过相应的单据审批，要求总经理输入审批意见
	 * 
	 * @param docVO
	 */
	public void failDoc(DocVO docVO);
	
	/**
	 * 前置条件：总经理不通过相应的单据审批
	 * 后置条件：系统提示相关业务员单据审批未通过，将单据返回，要求业务员重新输入
	 * 
	 * @param advice
	 */
	public void inputAdvice(String advice);
	
}
