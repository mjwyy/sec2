/**
 * �����ռ���
 * @author wqy
 * @date 2015/10/17
 */
package po;

public class ReceivingNoteInputPO {
	/**
	 * �ռ�����
	 */
	private String barcode;
	
	/**
	 * �ռ�������
	 */
	private String receiveCustomer;

	/**
	 * �ռ�ʱ��
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
