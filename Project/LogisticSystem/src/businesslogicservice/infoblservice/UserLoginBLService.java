package businesslogicservice.infoblservice;

import businesslogic.util.ResultMsg;

/**
 * 系统用户登录登出操作的逻辑接口
 * 
 * @author kylin
 *
 */
public interface UserLoginBLService {
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
	
	/**
	 * 用户登出系统操作接口
	 * 前置条件：用户要求退出系统
	 * 后置条件：系统提示退出成功
	 * 
	 * @param userID
	 * @return
	 */
	public ResultMsg logout(String userID);
	
}
