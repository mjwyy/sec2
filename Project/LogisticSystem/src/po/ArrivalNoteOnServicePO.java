/**
 * ����Ӫҵ�������PO
 * @author wqy
 * @date 2015/10/17
 */
package po;

import java.util.Date;

public class ArrivalNoteOnServicePO extends NotePO{


Date time;//���ﵽ������
int transitNoteNum;//��ת�����
String from;//������
String state;//���ﵽ��״̬
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

int Barcode;//����������
String DeliveryMan;//���Ա
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
