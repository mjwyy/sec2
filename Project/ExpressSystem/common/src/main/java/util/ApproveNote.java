package util;

import java.io.Serializable;

public class ApproveNote implements Serializable{

	private static final long serialVersionUID = -2251198382973115232L;

	private String id = null;
	private NoteType type = null;
	private String info = null;
	
	private boolean isPass = false;
	private String rejectionMessage = null;
	
	public ApproveNote(String id, NoteType type, String info) {
		super();
		this.id = id;
		this.type = type;
		this.info = info;
	}

	public boolean isPass() {
		return isPass;
	}

	public void setPass(boolean isPass) {
		this.isPass = isPass;
	}

	public String getRejectionMessage() {
		return rejectionMessage;
	}

	public void setRejectionMessage(String rejectionMessage) {
		this.rejectionMessage = rejectionMessage;
	}

	public String getId() {
		return id;
	}

	public NoteType getType() {
		return type;
	}

	public String getInfo() {
		return info;
	}

}
