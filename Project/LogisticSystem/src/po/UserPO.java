package po;

import java.io.Serializable;

public class UserPO implements Serializable {

	private static final long serialVersionUID = 3758641678884304726L;

	String account = null;
	String password = null;
	
	//��ö����Ҫǰ��ͳһ
	String authority = null;

	public UserPO(String account, String password, String authority) {
		super();
		this.account = account;
		this.password = password;
		this.authority = authority;
	}

	public String getAccount() {
		return account;
	}

	public String getPassword() {
		return password;
	}

	public String getAuthority() {
		return authority;
	}

	
}
