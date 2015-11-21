package po;

import java.io.Serializable;

/**
 * 用于登录验证的系统用户PO
 * @author River
 *
 */
public class UserPO implements Serializable {

	private static final long serialVersionUID = 3758641678884304726L;

	public UserPO(){
		
	}
	public UserPO(String account, String password, String authority) {
		super();
		this.account = account;
		this.password = password;
		this.authority = authority;
	}

    @Override
    public String toString(){
        return "UserPO: 账户:"+account+" 密码:"+password+" 权限="+authority;
    }

	/**
	 * 用户账号
	 */
	String account = null;
	
	/**
	 * 用户密码
	 */
	String password = null;
	
	/**
	 * 用户请求权限
	 */
	String authority = null;

	public String getAccount() {
		return account;
	}

	public String getPassword() {
		return password;
	}

	String getAuthority() {
		return authority;
	}
	
	
}
