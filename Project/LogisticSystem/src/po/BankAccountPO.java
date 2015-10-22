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
	 * ���ǵ��˺źܳ���ʹ��String����¼
	 */
	String number = null;
	
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
}
