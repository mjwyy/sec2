package businesslogicservice.statisticblservice;

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
<<<<<<< HEAD
	 * 总经理获得所有未审批单据的操作
	 *
=======
	 * 前置条件：总经理开始审批单据的操作
	 * 后置条件：返回所有未审批的单据信息
	 * 
>>>>>>> master
	 * @return
	 */
	public ArrayList<NoteVO> getAllDoc();
	
	/**
<<<<<<< HEAD
	 * 根据类型获取单据
	 *
=======
	 * 前置条件：总经理开始审批单据操作
	 * 后置条件：系统显示相应类型的单据详细信息
	 * 
>>>>>>> master
	 * @param type
	 * @return
	 */
	public ArrayList<NoteVO> getDocByType(DocType type);
	
	/**
<<<<<<< HEAD
	 * 通过所有单据的审批
=======
	 * 前置条件：总经理开始审批单据操作
	 * 后置条件：系统通过所有单据的审批，提示相应业务员单据审批通过
	 * 
>>>>>>> master
	 */
	public void passAllDoc();

	/**
<<<<<<< HEAD
	 * 通过一个单据的审批
	 *
=======
	 * 前置条件：总经理从未审批单据中选取了一个单据
	 * 后置条件：系统通过此单据的审批，提示相应业务员单据审批通过
	 * 
>>>>>>> master
	 * @param docVO
	 */
	public void passDoc(NoteVO docVO);
	
	/**
<<<<<<< HEAD
	 * 否决一个单据
	 *
=======
	 * 前置条件：总经理从未审批单据中选取了一个单据
	 * 后置条件：系统不通过相应的单据审批，要求总经理输入审批意见
	 * 
>>>>>>> master
	 * @param docVO
	 */
	public void failDoc(NoteVO docVO);
	
	/**
<<<<<<< HEAD
	 * 对否决对单据输入审批意见
	 *
=======
	 * 前置条件：总经理不通过相应的单据审批
	 * 后置条件：系统提示相关业务员单据审批未通过，将单据返回，要求业务员重新输入
	 * 
>>>>>>> master
	 * @param advice
	 */
	public void inputAdvice(NoteVO docVO,String advice);
	
}
