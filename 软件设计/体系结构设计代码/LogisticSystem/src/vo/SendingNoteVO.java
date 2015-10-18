package vo;

import businesslogic.logisticbl.DeliverCategory;

/**
 * 寄件单VO
 * 
 * @author kylin
 *
 */
public class SendingNoteVO {
	
	/**
	 * 客户姓名
	 */
	private String senderName;
	
	/**
	 * 客户地址
	 */
	private String senderAddress;
	
	/**
	 * 客户单位地址
	 */
	private String senderWorkPlace;
	
	/**
	 * 客户电话（手机）号码
	 */
	private String senderTeleNumber;
	
	/**
	 * 寄件件数
	 */
	private String number;
	
	/**
	 * 货物实际重量
	 */
	private double weight;
	
	/**
	 * 货物体积
	 */
	private double volume;
	
	/**
	 * 货物内件品名
	 */
	private String name;
	
	/**
	 * 快递种类
	 */
	private DeliverCategory category;
	
	/**
	 * 包装费用
	 */
	private double packPrice;
	
	/**
	 * 货物条形码
	 */
	private String barCode;
	
	public SendingNoteVO(String senderName, String senderAddress, String senderWorkPlace, String senderTeleNumber,
			String number, double weight, double volume, String name, DeliverCategory category, double packPrice,
			String barCode) {
		super();
		this.senderName = senderName;
		this.senderAddress = senderAddress;
		this.senderWorkPlace = senderWorkPlace;
		this.senderTeleNumber = senderTeleNumber;
		this.number = number;
		this.weight = weight;
		this.volume = volume;
		this.name = name;
		this.category = category;
		this.packPrice = packPrice;
		this.barCode = barCode;
	}
	
}
