package po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

public class CreditNotePO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1995375081984827715L;

	String date = null;
	
	BigDecimal money = null;
	
	String nameOfDeliveryMan = null;
	
	public CreditNotePO(String date,BigDecimal money,String nameofDeliveryMan){
		this.date = date;
		this.money = money;
		this.nameOfDeliveryMan = nameofDeliveryMan;
	}
	
}
