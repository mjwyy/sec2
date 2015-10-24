/**
 * 管理银行账户
 * @author wwz
 * date 2015/10/17
 */
package businesslogicservice.financeblservice;

import java.util.ArrayList;

import businesslogic.util.ResultMsg;
import vo.AccountVO;


public interface BankAccountManagementBLService {
	
	/**
	 * 根据账户名称模糊查找账户
	 * @param name
	 * @return
	 */
	public ArrayList<AccountVO> find(AccountVO vo);
	
	/**
	 * 增加账户
	 * @param vo
	 * @return
	 */
	public ResultMsg add(AccountVO vo);
	
	/**
	 * 删除账户
	 * @param vo
	 * @return
	 */
	public ResultMsg delete(AccountVO vo);
	
	/**
	 * 更新账户
	 * @param vo
	 * @return
	 */
	public ResultMsg update(AccountVO vo);
	
	/**
	 * 显示所有账户信息
	 * @return
	 */
	public ArrayList<AccountVO> show();

}
