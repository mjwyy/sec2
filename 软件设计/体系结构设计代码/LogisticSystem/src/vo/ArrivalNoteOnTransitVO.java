package vo;

import java.util.ArrayList;

/**
 * 中转中心到达单VO
 * 
 * @author kylin
 *
 */
public class ArrivalNoteOnTransitVO {
	
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
	
	private ArrayList<GoodsInfoVO> GoodsInfoVOs;

	public ArrivalNoteOnTransitVO(String transferNumber, String centerNumber, String date,
			ArrayList<GoodsInfoVO> goodsInfoVOs) {
		super();
		this.transferNumber = transferNumber;
		this.centerNumber = centerNumber;
		this.date = date;
		GoodsInfoVOs = goodsInfoVOs;
	}
	
}
