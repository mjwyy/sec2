package dataservice.exception;

import java.io.Serializable;

public class FailToPassApprovingException extends Exception implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9014950606252436172L;

	private String message = null;
	
	public FailToPassApprovingException() {
		// Empty constructor
	}
	
	public FailToPassApprovingException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
