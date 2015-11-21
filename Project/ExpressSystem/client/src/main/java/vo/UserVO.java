package vo;

import businesslogic.util.FormatCheck;
import po.UserPO;
import util.ResultMsg;

/**
 * 系统用户
 * 
 * 问题： FormatCheck缺少两个检查方法，实际上文档没有对相关问题作出规定
 */
public class UserVO {
	/**
	 * 账号
	 */
	private String userNum;
	
	/**
	 * 密码
	 */
	private String initialPassword;
	
	/**
	 * 权限
	 */
	private Authority authority;
	
	/**
	 * 构造方法
	 * @param userNum
	 * @param initialPassword
	 * @param authority
	 */
	public UserVO(String userNum,String initialPassword,String authority){
		this.userNum = userNum;
		this.initialPassword = initialPassword;
		this.authority = authority;
	}

    public String getUserNum() {
        return userNum;
    }

    public String getInitialPassword() {
        return initialPassword;
    }

    public String getAuthority() {
        return authority;
    }
    
    public ResultMsg checkFormat() {
    	ResultMsg[] msg = new ResultMsg[3];
    	
    	//TO DO : add methods into FormatCheck
    	msg[0] = FormatCheck.isUserAccount();
    	msg[1] = FormatCheck.isPassword(initialPassword);
    	msg[2] = FormatCheck.isAuthority();
    	
    	for(int i=0;i<msg.length;i++) {
    		if(!msg[i].isPass()) return msg[i];
    	}
    	
    	return new ResultMsg(true);
    }
    
    public Object toPO(){
    	UserPO po = new UserPO(userNum, initialPassword, authority);
    	return po;
    }
}
