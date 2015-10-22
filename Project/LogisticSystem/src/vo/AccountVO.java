package vo;

public class AccountVO {
	
	/**
<<<<<<< HEAD
	 * 账户名称
=======
	 * 璐︽埛鍚嶇О
>>>>>>> master
	 */
	private String name;
	
	/**
<<<<<<< HEAD
	 * 账号
	 */
	private String account;
	
	/**
	 * 账户余额
=======
	 * 璐﹀彿
	 */
	private String account;
	


	/**
	 * 璐︽埛浣欓
>>>>>>> master
	 */
	private double balance;

	/**
<<<<<<< HEAD
	 * 构造方法
=======
	 * 鏋勯�犳柟娉�
>>>>>>> master
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
