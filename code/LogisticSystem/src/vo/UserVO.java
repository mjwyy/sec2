package vo;

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
	private String authority;
	
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

}
