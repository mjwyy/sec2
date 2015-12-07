package util;

import java.io.Serializable;

import util.enums.NoteType;

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

	/**
	 * 设置单据审批结果
	 * @param isPass 单据审批结果（通过或不通过）
	 */
	public void setPass(boolean isPass) {
		this.isPass = isPass;
	}

	public String getRejectionMessage() {
		return rejectionMessage;
	}
	
	/**
	 * 设置审批意见（仅当不通过时调用）
	 * @param rejectionMessage 审批不通过的意见
	 */
	public void setRejectionMessage(String rejectionMessage) {
		this.rejectionMessage = rejectionMessage;
	}

	/**
	 * 此接口不建议界面使用，因为不具有业务价值
	 * @return 单据唯一辨识ID
	 */
	public String getId() {
		return id;
	}

	/**
	 * 返回待审批单据的种类（注意：NoteType有toString()方法）
	 * @return 单据的种类
	 */
	public NoteType getType() {
		return type;
	}

	/**
	 * @return 界面需要显示的“较长字符串”，用于表征单据信息 =
	 */
	public String getInfo() {
		return info;
	}

}
