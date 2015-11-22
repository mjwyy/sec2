/**
 * 处理中转中心到达件PO
 * @author wqy
 * @date 2015/10/17
 */
package po;

import java.io.Serializable;
import java.util.ArrayList;

import util.BarcodeAndState;

public class ArrivalNoteOnTransitPO extends NotePO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7182509551136962156L;

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

	public ArrivalNoteOnTransitPO(String transferNumber, String centerNumber,
			String date, String departurePlace,
			ArrayList<BarcodeAndState> barcodeAndStates) {
		super();
		this.transferNumber = transferNumber;
		this.centerNumber = centerNumber;
		this.date = date;
		this.departurePlace = departurePlace;
		BarcodeAndStates = barcodeAndStates;
	}

    public ArrivalNoteOnTransitPO() {
        super();
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