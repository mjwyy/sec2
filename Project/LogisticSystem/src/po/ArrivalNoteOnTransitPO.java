/**
 * 处理中转中心到达件PO
 * @author wqy
 * @date 2015/10/17
 */
package po;

import java.util.Date;

public class ArrivalNoteOnTransitPO {
	int transitNum;//中转中心编号
	Date time;//货物到达日期
	int transitNoteNum;//中转单编号
	String from;//出发地
	String state;//货物到达状态
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
