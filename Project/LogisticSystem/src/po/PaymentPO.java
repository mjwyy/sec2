package po;

import java.io.Serializable;
import java.math.BigDecimal;

public class PaymentPO implements Serializable {

	private static final long serialVersionUID = 8277049058138246140L;


	String date = null;
	String nameOfPayer = null;
	String accountNumber = null;
	BigDecimal amountOfMoney = null;
	String type = null;
	String comment = null;
	
	public PaymentPO(String data,String nameOfPayer,String accountNumber,
			BigDecimal amountOfMoney,String type,String comment){
		this.date = date;
		this.nameOfPayer = nameOfPayer;
		this.amountOfMoney = amountOfMoney;
		this.type = type;
		this.comment = comment;
		this.accountNumber = accountNumber;
		
	}
	
	public String getDate(){
		return date;
	}
	
	public String getNameOfPayer(){
		return nameOfPayer;
	}
	
	public BigDecimal getAmountOfMoney(){
		return amountOfMoney;
	}
	
	public String getAccountNumber(){
		return accountNumber;
	}
	
	public String getType(){
		return type;
	}
	
	public String getComment(){
		return comment;
	}
}
