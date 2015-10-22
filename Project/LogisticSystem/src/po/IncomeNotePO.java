package po;

import java.io.Serializable;
import java.math.BigDecimal;

public class IncomeNotePO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8156585850190316916L;

	String time = null;
	String receivingOrganization = null;
	String incomeHandler = null;
	String incomeSource = null;
	BigDecimal money = null;
	String location = null;
	BankAccountPO account = null;
	
	public IncomeNotePO(String time,String receivingOrganization,String incomeHandler,
			String incomeSource,BigDecimal money,String location,BankAccountPO account){
		this.time = time;
		this.receivingOrganization = receivingOrganization;
		this.incomeHandler  = incomeHandler;
		this.incomeSource = incomeSource;
		this.money = money;
		this.location = location;
		this.account = account;
	}
	
	public String getTime(){
		return time;
	}
	
	public String getReceivingOrganization(){
		return receivingOrganization;
	}
	
	public String getIncomeSource(){
		return incomeSource;
	}
	
	public BigDecimal getMoney(){
		return money;
	}
	
	public String getLocation(){
		return location;
	}
	
	public BankAccountPO getAccount(){
		return account;
	}
}
