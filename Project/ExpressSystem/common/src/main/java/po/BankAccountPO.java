package po;

import java.io.Serializable;
import java.math.BigDecimal;

<<<<<<< HEAD
=======
import vo.BankAccountVO;

>>>>>>> master
public class BankAccountPO implements Serializable {
	public BankAccountPO(){
		
	}
<<<<<<< HEAD
	public BankAccountPO(String name, String number, BigDecimal balance) {
=======
	public BankAccountPO(String name, String number, String balance) {
>>>>>>> master
		super();
		this.name = name;
		this.number = number;
		this.balance = balance;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -2348048532115826364L;

	/**
	 * 账户名称用字符串表示
	 */
	private String name = null;
	
	/**
	 * 账号用字符串表示
	 */
	private String number = null;
	
	/**
<<<<<<< HEAD
	 * 为保证精度，余额用BigDecimal表示
	 */
	private BigDecimal balance = null;
=======
	 * 余额
	 */
	private String balance = null;
>>>>>>> master

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

<<<<<<< HEAD
	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
=======
	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}
	
	public Object toVO() {
		BankAccountVO vo = new BankAccountVO(name, number, balance);
		return vo;
	}
	
>>>>>>> master
}
