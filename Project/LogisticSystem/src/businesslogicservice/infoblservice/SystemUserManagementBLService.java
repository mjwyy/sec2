/**
 * 管理系统用户
 * @author wwz
 * @date 2015/10/17
 */
package businesslogicservice.infoblservice;

import java.util.ArrayList;

import businesslogic.util.ResultMsg;
import vo.UserVO;

public interface SystemUserManagementBLService {
	
	/**
	 * 增加用户
	 * 前置条件；选择新增用户信息功能
	 * 后置条件；系统反馈新增结果，更新用户信息，系统日志记录
	 * @param vo
	 * @return 结果消息
	 */
	public ResultMsg add(UserVO vo);
	
	/**
	 * 删除用户
	 * 前置条件；选择删除信息功能
	 * 后置条件；系统反馈删除结果，更新用户信息，系统日志记录	 * 
	 * @param vo
	 * @return 结果消息
	 */
	public ResultMsg delete(UserVO vo);	
	
	/**
	 * 更新用户信息
	 * 前置条件；选择修改用户信息功能
	 * 后置条件；系统反馈修改结果，更新用户信息，系统日志记录	 * 
	 * @param vo
	 * @return 结果消息
	 */
	public ResultMsg modify(UserVO vo);
	
	/**
	 * 通过账号查找账户信息
	 * 前置条件；输入账号无误
	 * 后置条件；系统显示查找到的信息，系统日志记录
	 * @param userNum
	 * @return
	 */
	public ArrayList<UserVO> find(String userNum);
<<<<<<< HEAD

	/**
	 * 用户登录系统操作接口
	 * 前置条件：用户要求登录系统，输入相应的用户名与密码
	 * 后置条件：系统查询相应的用户是否存在，密码是否正确，返回登录结果信息
	 *
	 * @param userID
	 * @param password
	 * @return
	 */
	public ResultMsg login(String userID,String password);
=======
		
	
>>>>>>> master
 
}
