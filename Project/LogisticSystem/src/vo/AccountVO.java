package vo;

public class AccountVO {
	
	/**
	 * 璐︽埛鍚嶇О
	 */
	private String name;
	
	/**
	 * 璐﹀彿
	 */
	private String account;
	
	public String getName() {
		return name;
	}

	public String getAccount() {
		return account;
	}

	public double getBalance() {
		return balance;
	}

	/**
	 * 璐︽埛浣欓
	 */
	private double balance;

	/**
	 * 鏋勯�犳柟娉�
	 * @param name
	 * @param balance
	 */
	public AccountVO(String name, String account, double balance) {
		this.name = name;
		this.account = account;
		this.balance = balance;
	}

}
