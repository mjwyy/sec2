/**
 * 结算管理
 * @author wwz
 * @date 2015/10/17
 */
package businesslogicservice.financeblservice;

import java.util.ArrayList;

import businesslogic.util.ResultMsg;
import vo.ReceiveRecordVO;

public interface SettlementManagementBLService {
	
	/**
	 * 新增收款记录
	 * 前置条件：经验证的财务人员要求新增收款记录
	 * 后置条件：系统进行格式检查，并返回格式检查结果
	 * @param vo
	 * @return
	 */
	public ResultMsg addReceiveRecord(ReceiveRecordVO vo);


	/**
	 * 提交收款记录
	 * 前置条件：收款单经过格式检验，财务人员核对无误，要求提交单据
	 * 后置条件：系统提示单据信息录入成功，并提交单据给总经理审批
	 * @param vo
	 * @return
	 */
	public ResultMsg submitReceiveRecord(ReceiveRecordVO vo);
	
	/**
	 * 按日期查询收款记录
	 * 前置条件：经验证的财务人员输入的日期格式正确
	 * 后置条件；系统显示查询结果，系统日志记录
	 * @param date
	 * @return
	 */
	public ArrayList<ReceiveRecordVO> findbydate(String date);
	
	/**
	 * 按营业厅查询收款记录
	 * 前置条件；经验证的财务人员输入的营业厅正确
	 * 后置条件：系统显示查询结果，系统日志记录
	 * @param serive
	 * @return
	 */
	public ArrayList<ReceiveRecordVO> findbyService(String serivce);
	

}
