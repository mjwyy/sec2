package vo;

import java.util.ArrayList;

public class OrderVO {


	/**
	 * 条形码用字符串表示
	 */
	String barcode = null;
	
	/**
	 * 当前运送状态：“已收货”，“正在送货”，“已签收”
	 */
	String stateOfTransport = null;
	
	/**
	 * 保存了所有历史记录的字符串数组
	 */
	ArrayList<String> history;

	public OrderVO(String barcode, String stateOfTransport, ArrayList<String> history) {
		super();
		this.barcode = barcode;
		this.stateOfTransport = stateOfTransport;
		this.history = history;
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
