/**
 * 输入收件单
 * @author wqy
 * @date 2015/10/17
 */
package po;

public class ReceivingNoteInputPO {
	/**
	 * 收件单号
	 */
	private String barcode;
	
	/**
	 * 收件人姓名
	 */
	private String receiveCustomer;

	/**
	 * 收件时间
	 */
	private String time;

	public ReceivingNoteInputPO(String barcode, String receiveCustomer, String time) {
		super();
		this.barcode = barcode;
		this.receiveCustomer = receiveCustomer;
		this.time = time;
	}

	public String getBarcode() {
		return barcode;
	}

	public String getReceiveCustomer() {
		return receiveCustomer;
	}

	public String getTime() {
		return time;
	}
	
}
