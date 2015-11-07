package vo;

import java.util.ArrayList;

import util.BarcodeAndState;

/**
 * 中转中心到达单VO
 * 
 * @author kylin
 *
 */
//TODO povo的统一
public class ArrivalNoteOnTransitVO extends NoteVO {
	
	/**
	 * 中转单编号
	 */
	private String transferNumber;
	
	/**
	 * 中转中心编号
	 */
	private String centerNumber;

	/**
	 * 货物到达日期
	 */
	private String date;
	
	/**
	 * 货物出发地
	 */
	private String departurePlace;
	
	/**
	 * 条形码与货物状态
	 */
	private ArrayList<BarcodeAndState> BarcodeAndStates;

	public ArrivalNoteOnTransitVO(String transferNumber, String centerNumber, String date, String departurePlace,
			ArrayList<BarcodeAndState> barcodeAndStates) {
		super();
		this.transferNumber = transferNumber;
		this.centerNumber = centerNumber;
		this.date = date;
		this.departurePlace = departurePlace;
		BarcodeAndStates = barcodeAndStates;
	}

	public String getTransferNumber() {
		return transferNumber;
	}

	public String getCenterNumber() {
		return centerNumber;
	}

	public String getDate() {
		return date;
	}

	public String getDeparturePlace() {
		return departurePlace;
	}

	public ArrayList<BarcodeAndState> getBarcodeAndStates() {
		return BarcodeAndStates;
	}

}
