/**
 * 处理营业厅到达件PO
 * @author wqy
 * @date 2015/10/17
 */
package po;

import java.util.Date;

public class ArrivalNoteOnServicePO extends NotePO{


Date time;//货物到达日期
int transitNoteNum;//中转单编号
String from;//出发地
String state;//货物到达状态
public ArrivalNoteOnServicePO(Date time,int transitNoteNum,String from,String state){
	this.time=time;
	this.transitNoteNum=transitNoteNum;
	this.from=from;
	this.state=state;
}
public Date getTime() {
	return time;
}
public int getTransitNoteNum() {
	return transitNoteNum;
}
public String getFrom() {
	return from;
}
public String getState() {
	return state;
}

int Barcode;//货物条形码
String DeliveryMan;//快递员
public ArrivalNoteOnServicePO(Date time,int Barcode,String Deliveryman){
	this.time=time;
this.Barcode=Barcode;
this.DeliveryMan=Deliveryman;
}
public int getBarcode() {
	return Barcode;
}
public String getDeliveryMan() {
	return DeliveryMan;
}

}
