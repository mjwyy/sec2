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
	 * @param putInStorageVo
	 * @return
	 */
	public ResultMsg addReceipeDoc(ReceipeVO vo);
	
	/**
	 * 提交收款单
	 * @param putInStorageVo
	 * @return
	 */
   public ResultMsg submitReceipeDoc(ReceipeVO vo);
   
}
