/**
 * 管理银行账户
 * @author wwz
 * date 2015/10/17
 */
package businesslogicservice.financeblservice;

import java.util.ArrayList;

import state.ResultMsg;
import vo.AccountVO;


public interface AdminBankAccount15BLService {
	
	/**
	 * 根据账户名称模糊查找账户
	 * 后置条件：系统显示查找到的信息，系统日志记录操作
	 * @param name
	 * @return
	 */
	public ArrayList<AccountVO> find(String name);
	
	/**
	 * 增加账户
	 * 后置条件：系统反馈新增结果，系统日志记录
	 * @param vo
	 * @return
	 */
	public ResultMsg add(AccountVO vo);
	
	/**
	 * 删除账户
	 * 后置条件：系统反馈删除结果，系统日志记录
	 * @param vo
	 * @return
	 */
	public ResultMsg delete(AccountVO vo);
	
	/**
	 * 更新账户
	 * 后置条件：系统反馈修改结果，系统日志记录
	 * @param vo
	 * @return
	 */
	public ResultMsg update(AccountVO vo);
	
	/**
	 * 显示所有账户信息
	 * 后置条件：系统日志记录
	 * @return
	 */
	public ArrayList<AccountVO> show();

}
