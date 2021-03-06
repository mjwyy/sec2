package util.enums;

/**
 * Created by kylin on 15/11/21.
 */
public enum Authority {
    //总经理
    MANAGER(1),
    //财务人员
    ACCOUNTANT(2),
    //财务人员
    ACCOUNTANT_HIGH(3),
    //库存管理人员
    WAREHOUSE_MANAGER(4),
    //中转中心业务员
    TRANSIT_CENTER_PERSONNEL(5),
    //营业厅业务员
    SERVICE_HALL_PERSONNEL(6),
    //快递员
    DELIVERY_MAN(7),
    //系统管理员
    SYSTEM_MANAGER(8);

    private int intAuthority;

    Authority(int authority) {
        this.intAuthority = authority;
    }

    public int getIntAuthority() {
        return intAuthority;
    }

    /**
     *
     * @param i
     * @return null if the integer is beyond enum range
     */
    public static Authority getAuthObject(int i) {
        for(Authority a:values()) {
            if(a.intAuthority ==i) return a;
        }
        return null;
    }
}
