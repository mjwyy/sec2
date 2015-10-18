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
}
