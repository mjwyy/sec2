package util;

import util.enums.Authority;

/**
 * Created by kylin on 15/11/22.
 */
public class LogInMsg {
    /**
     * 是否通过该阶段的检查
     */
    private boolean pass;

    private Authority authority;

    private String message;
    
    public LogInMsg(boolean pass, Authority authority,String message) {
        this.pass = pass;
        this.authority = authority;
        this.message = message;
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
}
