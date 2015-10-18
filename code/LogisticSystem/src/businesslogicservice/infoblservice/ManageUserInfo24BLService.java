/**
 * 管理系统用户
 * @author wwz
 * @date 2015/10/17
 */
package businesslogicservice.infoblservice;

import java.util.ArrayList;

import state.ResultMsg;
import vo.UserVO;

public interface ManageUserInfo24BLService {
	
	/**
	 * 增加用户
	 * 前置条件；选择新增用户信息功能
	 * 
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
		
	
 
}
