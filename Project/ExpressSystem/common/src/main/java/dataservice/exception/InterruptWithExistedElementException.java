package dataservice.exception;

import java.io.Serializable;

public class InterruptWithExistedElementException extends Exception implements Serializable {

	private static final long serialVersionUID = 8599232482940770326L;

	private String message = null;
	
	public InterruptWithExistedElementException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
	
}
