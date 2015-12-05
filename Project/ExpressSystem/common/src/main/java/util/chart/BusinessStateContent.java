package util.chart;

/**
 * Created by kylin on 15/12/3.
 */
public class BusinessStateContent {

    /**
     * 收款日期
     */
    private String date;

    /**
     * 收款流水
     */
    private String id;

    /**
     * 收入
     */
    private double money;

    /**
     * 账户
     */
    private String account;

    /**
     * 付款人
     */
    private String payer;

    /**
     * 区分付款单信息(0)与收款单信息(1)
     */
    protected int type;

    public BusinessStateContent(String date, String id, double money,
                                String account, String payer) {
        this.date = date;
        this.id = id;
        this.money = money;
        this.account = account;
        this.payer = payer;
    }

    public String getDate() {
        return date;
    }

    public String getId() {
        return id;
    }

    public double getMoney() {
        return money;
    }

    public String getAccount() {
        return account;
    }

    public String getPayer() {
        return payer;
    }

    public int getType() {
        return type;
    }
}
