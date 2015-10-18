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
	
}
