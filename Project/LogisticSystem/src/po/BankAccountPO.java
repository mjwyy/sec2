package po;

import java.io.Serializable;
import java.math.BigDecimal;

public class BankAccountPO implements Serializable {

	public BankAccountPO(String name, String number, BigDecimal balance) {
		super();
		this.name = name;
		this.number = number;
		this.balance = balance;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -2348048532115826364L;

	private String name = null;
	
	/*
	 * ���ǵ��˺źܳ���ʹ��String����¼
	 */
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
	
<<<<<<< HEAD
	BigDecimal balance = null;
	
 	public BankAccountPO(String name,String number,BigDecimal balance){
 		this.name = name;
 		this.number = number;
 		this.balance = balance;
 	}
 	
 	public String getName(){
 		return name;
 	}
 	
 	public String getNumber(){
 		return number;
 	}
 	
 	public BigDecimal getBalance(){
 		return balance;
 	}
=======
>>>>>>> master
}
