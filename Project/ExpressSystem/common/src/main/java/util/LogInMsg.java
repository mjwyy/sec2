package util;

import java.io.Serializable;

import util.enums.Authority;

/**
 * Created by kylin on 15/11/22.
 */
public class LogInMsg implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -255983416629710460L;

	/**
     * 是否通过该阶段的检查
     */
    private boolean pass;

    private Authority authority;

    private String message;

    // 创建这个单据的业务员信息
    private String userName;

    // 创建这个单据的业务员所在的机构名称
    private String organization;

    private String organization_id;
    
    public LogInMsg(boolean pass, Authority authority,String message) {
        this.pass = pass;
        this.authority = authority;
        this.message = message;
    }

    public LogInMsg(boolean pass, Authority authority, String message,
                    String userName, String organization, String organization_id) {
        this.pass = pass;
        this.authority = authority;
        this.message = message;
        this.userName = userName;
        this.organization = organization;
        this.organization_id = organization_id;
    }

    public boolean isPass() {
        return pass;
    }

    public Authority getAuthority() {
        return authority;
    }

    public String getMessage() {
        return message;
    }

    public String getUserName() {
        return userName;
    }

    public String getOrganization() {
        return organization;
    }

    public String getOrganization_id() {
        return organization_id;
    }
}
