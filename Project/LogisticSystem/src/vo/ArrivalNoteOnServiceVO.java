package vo;

import java.util.ArrayList;

import businesslogic.util.GoodsState;

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
	 * 到达状态
	 */
	private GoodsState state;

	/**
	 * 货物托运条形码
	 */
	private ArrayList<String> barCodes;

	/**
	 * 中转单编号（装车单编号）
	 */
	private String TransferNumber;
	
	public ArrivalNoteOnServiceVO(String date, GoodsState state, ArrayList<String> barCodes, String transferNumber) {
		super();
		this.date = date;
		this.state = state;
		this.barCodes = barCodes;
		this.TransferNumber = transferNumber;
	}
	
	
}
