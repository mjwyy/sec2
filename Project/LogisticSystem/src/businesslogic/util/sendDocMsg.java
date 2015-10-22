package businesslogic.util;

/**
 * 输入寄件单信息后系统返回的信息
 * 包括 1:运费 2:预计到达日期
 * 
 * @author kylin
 *
 */
<<<<<<< HEAD
public class sendDocMsg extends ResultMsg{
=======
public class sendDocMsg {
>>>>>>> master

    /**
     * 运费, 根据运费与包装费和获得
     */
    private double price;

    /**
     * 系统根据历史记录预计的到达日期
     */
    private String predectedDate;

<<<<<<< HEAD
    public sendDocMsg(boolean pass, String message, double price, String predectedDate) {
        super(pass, message);
        this.price = price;
        this.predectedDate = predectedDate;
=======
    public sendDocMsg(String predectedDate, double price) {
        this.predectedDate = predectedDate;
        this.price = price;
>>>>>>> master
    }

    public double getPrice() {
        return price;
    }

    public String getPredectedDate() {
        return predectedDate;
    }
}
