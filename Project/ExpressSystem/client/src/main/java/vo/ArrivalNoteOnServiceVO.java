package vo;

import java.util.ArrayList;

import util.BarcodeAndState;

/**
 * 营业厅到达单VO
 * 
 * @author kylin
 *
 */
public class ArrivalNoteOnServiceVO extends NoteVO{
	
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

	public ArrivalNoteOnServiceVO(String date, String transferNumber, String from,
			ArrayList<BarcodeAndState> barcodeAndStates) {
		super();
		this.date = date;
		TransferNumber = transferNumber;
		this.from = from;
		BarcodeAndStates = barcodeAndStates;
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

	public ArrayList<BarcodeAndState> getBarcodeAndStates() {
		return BarcodeAndStates;
	}
	
}
