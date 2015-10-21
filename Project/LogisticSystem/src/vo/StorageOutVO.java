package vo;

import java.util.ArrayList;

public class StorageOutVO {
	
	/**
	 * 日期
	 */
	private String date;
	
	/**
	 *目的地 
	 */
	private String destination;
	
	/**
	 * 汽运编号
	 */
	private String truckNum;
	
	/**
	 * 中转单编号
	 */
	private String transferNum;
	
	/**
	 * 装运方式
	 */
	private String shippingForm;
	
	/**
	 * 条形码
	 */
	private ArrayList<String> barcode;
	
	/**
	 * 构造方法
	 * @param date
	 * @param destination
	 * @param truckNum
	 * @param transferNum
	 * @param shippingForm
	 * @param barcode
	 */
	public StorageOutVO(String date,String destination,String truckNum,
			String transferNum,String shippingForm,ArrayList<String>barcode){
		this.date = date;
		this.destination = destination;
		this.truckNum = truckNum;
		this.transferNum = transferNum;
		this.shippingForm = shippingForm;
		this.barcode = barcode;
	}
	

}
