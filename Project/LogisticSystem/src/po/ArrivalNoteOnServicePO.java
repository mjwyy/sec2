
/**
 * 处理营业厅到达件PO
 * @author wqy
 * @date 2015/10/17
 */
package po;

import java.util.Date;

public class ArrivalNoteOnServicePO extends NotePO{


	private String time;//货物到达日期
	private String transitNoteNum;//中转单编号
	private String from;//出发地
	private String state;//货物到达状态
	public ArrivalNoteOnServicePO(String time,String transitNoteNum,String from,String state){
		this.time=time;
		this.transitNoteNum=transitNoteNum;
		this.from=from;
		this.state=state;
	}
	public String getTime() {
		return time;
	}
	public String getTransitNoteNum() {
		return transitNoteNum;
	}
	public String getFrom() {
		return from;
	}
	public String getState() {
		return state;
	}

	String Barcode;//货物条形码
	String DeliveryMan;//快递员
	public ArrivalNoteOnServicePO(String time,String Barcode,String Deliveryman){
		this.time=time;
		this.Barcode=Barcode;
		this.DeliveryMan=Deliveryman;
	}
	public String getBarcode() {
		return Barcode;
	}
	public String getDeliveryMan() {
		return DeliveryMan;
	}

}