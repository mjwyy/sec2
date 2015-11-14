/**
 * 营业厅派件单
 * @author wqy
 * @date 2015/10/17
 */
package po;

import java.util.ArrayList;

public class DeliverNoteOnServicePO {
	/**
	 * 货物到达日期
	 */
	private String date;

	/**
	 * 货物托运条形号码
	 */
	private ArrayList<String> BarCode;

	/**
	 * 派件员
	 */
	private String DeliveryMan;

	public String getDate() {
		return date;
	}

	public ArrayList<String> getBarCode() {
		return BarCode;
	}

	public String getDeliveryMan() {
		return DeliveryMan;
	}

	public DeliverNoteOnServicePO(String date, ArrayList<String> barCode,
			String deliveryMan) {
		super();
		this.date = date;
		BarCode = barCode;
		DeliveryMan = deliveryMan;
	}


}
