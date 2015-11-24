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

    public LogInMsg(boolean pass, Authority authority) {
        this.pass = pass;
        this.authority = authority;
    }

    public boolean isPass() {
        return pass;
    }

    public Authority getAuthority() {
        return authority;
    }
}
