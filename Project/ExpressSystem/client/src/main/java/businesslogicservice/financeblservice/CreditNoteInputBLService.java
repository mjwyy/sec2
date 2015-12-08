/**
 * 记录快递收款单
 * @author wwz
 * @date 2015/10/17
 */
package businesslogicservice.financeblservice;

import dataservice.exception.ElementNotFoundException;
import util.ResultMsg;
import vo.CreditNoteVO;

public interface CreditNoteInputBLService {
	
	/**
	 * 新增快递收款单
	 * @param vo
	 * @return
	 */
	public ResultMsg addReceipeDoc(CreditNoteVO vo);
	
	/**
	 * 提交收款单
	 * @param vo
	 * @return
	 */
   public ResultMsg submitReceipeDoc(CreditNoteVO vo);
   
   /**
    * 获取单件快件的金额
    * 
    * @param barcode
    * @return
    * @throws ElementNotFoundException
    */
   public double getOrderMoney(String barcode) throws ElementNotFoundException;
   
}
