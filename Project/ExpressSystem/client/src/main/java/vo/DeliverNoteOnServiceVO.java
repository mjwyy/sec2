package vo;

import po.DeliverNoteOnServicePO;
import po.NotePO;
import util.ResultMsg;

import java.util.ArrayList;

/**
 * 营业厅派件单VO
 * 
 * @author kylin
 *
 */
public class DeliverNoteOnServiceVO extends NoteVO {
	
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

	public DeliverNoteOnServiceVO(String date, ArrayList<String> barCode, String deliveryMan) {
		super();
		this.date = date;
		BarCode = barCode;
		DeliveryMan = deliveryMan;
	}

    public String getDate() {
        return date;
    }

    public ArrayList<String> getBarCode() {
        return BarCode;
    }

    public String getDeliveryMan() {
        return DeliveryMan;
    }

    @Override
    public ResultMsg checkFormat() {
        return super.checkFormat();
    }

    @Override
    public DeliverNoteOnServicePO toPO() {
        return new DeliverNoteOnServicePO(this.getDate(),this.getBarCode(),this.getDeliveryMan());
    }
}
