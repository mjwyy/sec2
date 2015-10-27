package vo;

import java.util.ArrayList;

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
	 * 货物条形码与状态
	 */
	private ArrayList<BarcodeAndStateVO> GoodsInfoVOs;

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

	public ArrayList<BarcodeAndStateVO> getGoodsInfoVOs() {
		return GoodsInfoVOs;
	}

	public ArrivalNoteOnTransitVO(String transferNumber, String centerNumber, String date, String departurePlace,
			ArrayList<BarcodeAndStateVO> goodsInfoVOs) {
		super();
		this.transferNumber = transferNumber;
		this.centerNumber = centerNumber;
		this.date = date;
		this.departurePlace = departurePlace;
		GoodsInfoVOs = goodsInfoVOs;
	}
		
}
