
/**
 * 营业厅到达单PO
 * @author wqy
 * @date 2015/10/17
 */
package po;

import java.io.Serializable;
import java.util.ArrayList;

import util.BarcodeAndState;

public class ArrivalNoteOnServicePO extends NotePO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7187002330817151504L;

	/**
	 * 到达日期
	 */
	private String date;

	/**
	 * 中转单编号（装车单编号）
	 */
	private String TransferNumber;
	
	/**
	 * 出发地
	 */
	private String from;
	
	
	/**
	 * 条形码与货物状态
	 */
	private ArrayList<BarcodeAndState> BarcodeAndStates;

	public ArrivalNoteOnServicePO(String date, String transferNumber,
			String from, ArrayList<BarcodeAndState> barcodeAndStates) {
		super();
		this.date = date;
		TransferNumber = transferNumber;
		this.from = from;
		BarcodeAndStates = barcodeAndStates;
	}

	public ArrayList<BarcodeAndState> getBarcodeAndStates() {
		return BarcodeAndStates;
	}

	public String getDate() {
		return date;
	}

	public String getTransferNumber() {
		return TransferNumber;
	}

	public String getFrom() {
		return from;
	}


}