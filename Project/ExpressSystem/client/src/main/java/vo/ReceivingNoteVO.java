package vo;

import po.ReceivingNotePO;
import util.ResultMsg;

/**
 * 收件单VO
 * 
 * @author kylin
 *
 */
public class ReceivingNoteVO extends NoteVO {

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

	public ReceivingNoteVO(String barcode, String receiveCustomer, String time) {
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

    @Override
    public ResultMsg checkFormat() {
        return super.checkFormat();
    }

    @Override
    public ReceivingNotePO toPO() {
        return new ReceivingNotePO(this.getBarcode(),this.getReceiveCustomer(),this.getTime());
    }
}
