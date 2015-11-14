package po;

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
	 * 当前运送状态：“已收货”，“正在送货”，“已签收”
	 */
	String stateOfTransport = null;
	
	private ArrayList<String> history;

	public OrderPO(String barcode, String stateOfTransport, ArrayList<String> history) {
		super();
		this.barcode = barcode;
		this.stateOfTransport = stateOfTransport;
		this.history = history;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getBarcode() {
		return barcode;
	}

	public String getStateOfTransport() {
		return stateOfTransport;
	}

	public ArrayList<String> getHistory() {
		return history;
	}
	
}
