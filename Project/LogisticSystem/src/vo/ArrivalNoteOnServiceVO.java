package vo;

import java.util.ArrayList;

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
	 * 货物的条形码与对应状态
	 */
	private ArrayList<BarcodeAndStateVO> BarcodeAndState;

	public ArrivalNoteOnServiceVO(String date, String transferNumber, String from,
			ArrayList<BarcodeAndStateVO> barcodeAndState) {
		super();
		this.date = date;
		TransferNumber = transferNumber;
		this.from = from;
		BarcodeAndState = barcodeAndState;
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

	public ArrayList<BarcodeAndStateVO> getBarcodeAndState() {
		return BarcodeAndState;
	}
	
}
