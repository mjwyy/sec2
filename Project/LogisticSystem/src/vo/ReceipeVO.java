package vo;

import java.util.ArrayList;

public class ReceipeVO {
  
	/**
	 * 日期
	 */
	private String date;
	
	/**
	 * 收款总数
	 */
	private String moneySum;
	
	/**
	 * 快递员姓名
	 */
	private String CourierName;
	
	/**
	 *条形码
	 */
	private ArrayList<String> barcode;
	
	/**
	 * 构造方法
	 * @param date
	 * @param moneySum
	 * @param CourierName
	 * @param barcode
	 */
	public ReceipeVO(String date,String moneySum,String CourierName,ArrayList<String> barcode){
		this.date = date;
		this.moneySum = moneySum;
		this.CourierName =CourierName;
		this.barcode = barcode;
	}
}
