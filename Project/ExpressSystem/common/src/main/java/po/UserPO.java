package po;

import util.enums.Authority;

import java.io.Serializable;

/**
 * 用于登录验证的系统用户PO
 * @author River
 *
 */
public class UserPO implements Serializable {

	private static final long serialVersionUID = 3758641678884304726L;

    /**
     * 账号
     */
    private String Account;

    /**
     * 密码
     */
    private String Password;

    /**
     * 权限
     */
    private int Authority;

    /**
     * 构造方法
     * @param Account
     * @param Password
     * @param authority
     */
    public UserPO(String Account, String Password, int authority){
        this.Account = Account;
        this.Password = Password;
        this.Authority = authority;
    }

    public UserPO(){

    }

    @Override
    public String toString(){
        return "UserPO: 账户:"+ Account +" 密码:"+ Password +" 权限="+ Authority;
    }

    public String getAccount() {
        return Account;
    }

    public String getPassword() {
        return Password;
    }

    public int getAuthority() {
        return Authority;
    }

}
