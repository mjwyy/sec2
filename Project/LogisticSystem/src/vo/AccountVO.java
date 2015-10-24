package vo;

public class AccountVO {
	
	/**
	 * 账户名称
	 */
	private String name;
	
	/**
	 * 账号
	 */
	private String account;
	
	/**
	 * 账户余额
	 */
	private double balance;

	/**
	 * 构造方法
	 * @param name
	 * @param balance
	 */
	public AccountVO(String name, String account, double balance) {
		this.name = name;
		this.account = account;
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public String getAccount() {
		return account;
	}

	public double getBalance() {
		return balance;
	}
}
