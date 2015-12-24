package util.enums;

import java.io.Serializable;

public enum NoteType implements Serializable{
	//TODO All types of notes requires approving? More!

	/**
	 * These are notes from the original interface, but may not be enough: 
	 * ArrivalNoteOnServicePO
	 * DeliverNoteOnServicePO
	 * ArrivalNoteOnTransitPO
	 * DeliveryNotePO
	 * LoadNoteOnServicePO
	 * LoadNoteOnTransitPO
	 * ReceivingNotePO
	 * TransitNotePO
	 */
	
	ARRIVAL_NOTE_ON_SERVICE("营业厅到达单"),
	DELIVER_NOTE_ON_SERVICE("营业厅派件单"),
	ARRIVAL_NOTE_ON_TRANSIT("中转中心到达单"),
	DELIVERY_NOTE("寄件单"),
	LOAD_NOTE_ON_SERVICE("营业厅装车单"),
	LOAD_NOTE_ON_TRANSIT("中转中心装车单"),
	RECEIVING_NOTE("收件单"),
	TRANSIT_NOTE("中转单"),
	STORAGE_IN("仓库入库单"),
	STORAGE_OUT("仓库出库单"),
	CREDIT_NOTE("营业厅收款单");
	
	private String name = null;
	
	private NoteType(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
	
}
