package po;

import java.io.Serializable;
import java.math.BigDecimal;

public class BankAccountPO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2348048532115826364L;

	String name = null;
	
	/*
	 * 考虑到账号很长，使用String来记录
	 */
	String number = null;
	
	BigDecimal balance = null;
}
