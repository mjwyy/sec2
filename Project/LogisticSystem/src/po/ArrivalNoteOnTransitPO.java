/**
 * ������ת���ĵ����PO
 * @author wqy
 * @date 2015/10/17
 */
package po;

import java.util.Date;

public class ArrivalNoteOnTransitPO {
	int transitNum;//��ת���ı��
	Date time;//���ﵽ������
	int transitNoteNum;//��ת�����
	String from;//������
	String state;//���ﵽ��״̬
	public ArrivalNoteOnTransitPO(Date time,int transitNoteNum,String from,String state,int transitNum){
		this.time=time;
		this.transitNoteNum=transitNoteNum;
		this.from=from;
		this.state=state;
		this.transitNum=transitNum;
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

	public int getTransitNum() {
		return transitNum;
	}
}
