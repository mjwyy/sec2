package vo;

import po.BankAccountPO;

/**
 * 收款记录
 * 
 * @author kylin
 *
 */
public class IncomeNoteVO {
     
	/**
	 * 金额
	 */
	private String money;
	
	/**
	 * 日期
	 */
	private String date;
	
	/**
	 * 机构
	 */
	private String institution;
	
	/**
	 * 收款人
	 */
	private String payee;
	
	/**
	 * 交款营业厅
	 */
	private String payService;
	
	/**
	 * 收款地点
	 */
	private String place;
	
	/**
	 * 银行账户
	 */
	private BankAccountPO account;
	
	/**
	 * 构造方法
	 * @param money
	 * @param date
	 * @param institution
	 * @param payee
	 * @param payService
	 * @param place
	 */
	public IncomeNoteVO(String money,String date,String institution,
			String payee,String payService,String place,BankAccountPO account){
		this.date = date;
		this.institution =institution;
		this.money = money;
		this.payee = payee;
		this.payService = payService;
		this.place = place;
		this.account = account;
	}

	public String getMoney() {
		return money;
	}

	public String getDate() {
		return date;
	}

	public String getInstitution() {
		return institution;
	}

	public String getPayee() {
		return payee;
	}

	public String getPayService() {
		return payService;
	}

	public String getPlace() {
		return place;
	}

	public BankAccountPO getAccount() {
		return account;
	}

	
}
