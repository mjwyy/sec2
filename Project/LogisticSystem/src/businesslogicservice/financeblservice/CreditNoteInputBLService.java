/**
 * 记录快递收款单
 * @author wwz
 * @date 2015/10/17
 */
package businesslogicservice.financeblservice;

import java.util.ArrayList;

import businesslogic.util.ResultMsg;
import vo.StorageInVO;
import vo.ReceipeVO;

public interface CreditNoteInputBLService {
	
	/**
	 * 显示快递收款单
	 * @return 信息列表
	 */
	public ArrayList<ReceipeVO> show();
	
	/**
	 * 新增快递收款单
	 * 前置条件：业务员选择新增收款单的功能
	 * 后置条件：系统检查收款单信息
	 * @param putInStorageVo
	 * @return
	 */
	public ResultMsg addReceipeDoc(ReceipeVO vo);
	
	/**
	 * 提交收款单
	 * 前置条件：收款单格式检查无误
	 * 后置条件：系统反馈提交结果
	 * @param putInStorageVo
	 * @return
	 */
   public ResultMsg submitReceipeDoc(ReceipeVO vo);
   

	

}
