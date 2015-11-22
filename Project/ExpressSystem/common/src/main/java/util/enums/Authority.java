package util.enums;

/**
 * Created by kylin on 15/11/21.
 */
public enum Authority {
    MANAGER(1),
    ACCOUNTANT_HIGH(2),
    ACCOUNTANT_LOW (3),
    WAREHOUSE_MANAGER (4),
    DELIVERY_MAN(6),
    SYSTEM_MANAGER(7);

    private int Authority;

    Authority(int authority) {
        this.Authority = authority;
    }

    public int getAuthority() {
        return Authority;
    }
}
