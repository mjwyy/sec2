package dataservice.exception;

import java.io.Serializable;

/**
* @author River
*/
public class ElementNotFoundException extends Exception implements Serializable{

	public String message;
	
	public ElementNotFoundException(String string) {
		this.message = string;
	}

	private static final long serialVersionUID = -4080377879461286908L;

	
}
