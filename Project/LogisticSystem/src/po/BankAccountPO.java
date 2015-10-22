package po;

import java.io.Serializable;
import java.math.BigDecimal;

public class BankAccountPO implements Serializable {

<<<<<<< HEAD
=======
	public BankAccountPO(String name, String number, BigDecimal balance) {
		super();
		this.name = name;
		this.number = number;
		this.balance = balance;
	}

>>>>>>> master
	/**
	 * 
	 */
	private static final long serialVersionUID = -2348048532115826364L;

<<<<<<< HEAD
	String name = null;
=======
	private String name = null;
>>>>>>> master
	
	/*
	 * 考虑到账号很长，使用String来记录
	 */
<<<<<<< HEAD
	String number = null;
	
	BigDecimal balance = null;
=======
	private String number = null;
	
	private BigDecimal balance = null;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
>>>>>>> master
}
