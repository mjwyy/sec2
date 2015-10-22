package businesslogic.util;

public class ResultMsg {
	
    boolean pass;
	String message;
	
	public ResultMsg(boolean pass, String message) {
		super();
		this.pass = pass;
		this.message = message;
	}
	public String toString(){
		return message;
	}
	public boolean isPass() {
		return pass;
	}
	public String getMessage() {
		return message;
	}
	
}
