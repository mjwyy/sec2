package businesslogic.util;

public class FormatCheckResultMsg extends ResultMsg{

	public FormatCheckResultMsg(boolean pass, String message) {
		super(pass, message);
	}

	boolean pass;
	
}
