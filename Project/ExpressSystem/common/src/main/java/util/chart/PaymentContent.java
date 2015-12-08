package util.chart;

import java.io.Serializable;

/**
 * Created by kylin on 15/12/3.
 */
public class PaymentContent extends BusinessStateContent implements Serializable {

    /**
     * 支出类型
     */
    private String payType;

    /**
     * 备注
     */
    private String comment;

    public PaymentContent(String date, String id, double money, String account, String payer,
                          String type, String comment) {
        super(date, id, money, account, payer);
        this.payType = type;
        this.comment = comment;
        this.type = 1;
    }

    public String getPayType() {
        return payType;
    }

    public String getComment() {
        return comment;
    }
}
