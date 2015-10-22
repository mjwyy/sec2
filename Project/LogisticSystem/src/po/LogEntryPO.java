package po;

import java.io.Serializable;

public class LogEntryPO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8123672483324893530L;

	String Time = null;
	String record = null;
	
	public LogEntryPO(String time, String record) {
		super();
		Time = time;
		this.record = record;
	}

	public String getTime() {
		return Time;
	}

	public String getRecord() {
		return record;
	}
	
}
