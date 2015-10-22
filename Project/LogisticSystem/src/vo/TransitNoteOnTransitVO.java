package vo;

import java.util.ArrayList;

/**
 * 中转中心中转单VO
 * 
 * @author kylin
 *
 */
public class TransitNoteOnTransitVO extends NoteVO {

	/**
	 * 装车日期
	 */
	private String date;

	/**
	 * 中转单编号	
	 */
	private String transitDocNumber;

	/**
	 * 航班号	
	 */
	private String flightNumber;

	/**
	 * 出发地
	 */
	private String departurePlace;

	/**
	 * 到达地
	 */
	private String desitination;

	/**
	 * 货柜号
	 */
	private String containerNumber;

	/**
	 * 监装员
	 */
	private String supercargoMan;

	/**
	 * 装箱所有托运单号
	 */
	private ArrayList<String> barcodes;
	
	/**
	 * 运费
	 */
	private double price;

	public TransitNoteOnTransitVO(String date, String transitDocNumber, String flightNumber, String departurePlace,
			String desitination, String containerNumber, String supercargoMan, ArrayList<String> barcodes) {
		super();
		this.date = date;
		this.transitDocNumber = transitDocNumber;
		this.flightNumber = flightNumber;
		this.departurePlace = departurePlace;
		this.desitination = desitination;
		this.containerNumber = containerNumber;
		this.supercargoMan = supercargoMan;
		this.barcodes = barcodes;
	}
	
	
	
}
