package po;

import util.enums.GoodsState;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 用于传递订单历史记录（轨迹）的PO
 * @author River
 *
 */
public class OrderPO implements Serializable {


	private static final long serialVersionUID = -164650701484223427L;
	
	/**
	 * 条形码用字符串表示
	 */
	String barcode = null;
	
	/**
     * 当前货物状态
     */
    GoodsState goodsState = null;

    private ArrayList<String> history;

    public OrderPO(String barcode, GoodsState goodsState, ArrayList<String> history) {
        this.barcode = barcode;
        this.goodsState = goodsState;
        this.history = history;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getBarcode() {
        return barcode;
    }

    public GoodsState getGoodsState() {
        return goodsState;
    }

    public ArrayList<String> getHistory() {
        return history;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public void setGoodsState(GoodsState goodsState) {
        this.goodsState = goodsState;
    }

    public void setHistory(ArrayList<String> history) {
        this.history = history;
    }
}
