package util;

import java.io.Serializable;

public enum NoteType implements Serializable{
	//TODO All types of notes requires approving?

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
	
	ARRIVAL_NOTE_ON_SERVICE(""),
	DELIVER_NOTE_ON_SERVICE(""),
	ARRIVAL_NOTE_ON_TRANSIT(""),
	DELIVERY_NOTE(""),
	LOAD_NOTE_ON_SERVICE(""),
	LOAD_NOTE_ON_TRANSIT(""),
	RECEIVING_NOTE(""),
	TRANSIT_NOTE("");
	
	private String name = null;
	
	private NoteType(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
	
}
