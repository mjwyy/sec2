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
	 * 前置条件：经验证的用户要求查询账户
	 * 后置条件：系统显示查找到的信息，系统日志记录操作
	 * @param name
	 * @return
	 */
	public ArrayList<AccountVO> find(String name);
	
	/**
	 * 增加账户
	 * 前置条件：经验证的用户新增查询账户
	 * 后置条件：系统反馈新增结果，系统日志记录
	 * @param vo
	 * @return
	 */
	public ResultMsg add(AccountVO vo);
	
	/**
	 * 删除账户
	 * 前置条件：经验证的用户删除查询账户
	 * 后置条件：系统反馈删除结果，系统日志记录
	 * @param vo
	 * @return
	 */
	public ResultMsg delete(AccountVO vo);
	
	/**
	 * 更新账户
	 * 前置条件：经验证的用户修改查询账户
	 * 后置条件：系统反馈修改结果，系统日志记录
	 * @param vo
	 * @return
	 */
	public ResultMsg update(AccountVO vo);
	
	/**
	 * 显示所有账户信息
	 * 前置条件：经验证的用户查看所有查询账户
	 * 后置条件：系统日志记录
	 * @return
	 */
	public ArrayList<AccountVO> show();

}
