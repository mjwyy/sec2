package vo;

import util.FormatCheck;
import util.ResultMsg;
import util.enums.GoodsState;

import java.util.ArrayList;

public class OrderVO {


	/**
	 * 条形码用字符串表示
	 */
	String barcode = null;
	
	/**
	 * 当前货物状态:COMPLETE("完整"),DAMAGED("损坏"),LOST("丢失");
	 */
    GoodsState stateOfTransport = null;

    /**
	 * 保存了所有历史记录的字符串数组
	 */
	ArrayList<String> history;

    public OrderVO(String barcode, GoodsState stateOfTransport, ArrayList<String> history) {
        super();
		this.barcode = barcode;
		this.stateOfTransport = stateOfTransport;
		this.history = history;
	}

	public String getBarcode() {
		return barcode;
	}

    public GoodsState getStateOfTransport() {
        return stateOfTransport;
	}

	public ArrayList<String> getHistory() {
		return history;
	}

    public ResultMsg checkFormat(){
        return FormatCheck.isBarcode(this.barcode);
    }
	
}
