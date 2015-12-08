package util.chart;

import java.io.Serializable;

/**
 * Created by kylin on 15/12/3.
 */
public class IncomeContent extends BusinessStateContent implements Serializable{

    /**
     * 收款机构
     */
    private String receiveOrg;

    /**
     * 收款人员
     */
    private String receiveStaff;

    public IncomeContent(String date, String id, double money, String account, String payer,
                         String receiveOrg, String receiveStaff) {
        super(date, id, money, account, payer);
        this.receiveOrg = receiveOrg;
        this.receiveStaff = receiveStaff;
        this.type = 0;
    }

    public String getReceiveOrg() {
        return receiveOrg;
    }

    public String getReceiveStaff() {
        return receiveStaff;
    }
}
