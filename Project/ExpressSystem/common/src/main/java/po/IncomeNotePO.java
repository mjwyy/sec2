package po;

import java.io.Serializable;
import java.math.BigDecimal;
<<<<<<< HEAD
=======

import vo.BankAccountVO;
import vo.IncomeNoteVO;
>>>>>>> master
/**
 * 记录收款单的PO
 * @author River
 *
 */
<<<<<<< HEAD
//TODO VO PO的统一问题
public class IncomeNotePO implements Serializable {

	private static final long serialVersionUID = 8156585850190316916L;

=======
public class IncomeNotePO implements Serializable {

	private static final long serialVersionUID = 8156585850190316916L;
	
>>>>>>> master
	public IncomeNotePO(){
		
	}
	public IncomeNotePO(String time, String receivingOrganization,
<<<<<<< HEAD
			String incomeHandler, String incomeSource, BigDecimal money,
			String location, BankAccountPO account) {
=======
			String incomeHandler, String incomeSource, String money,
			 BankAccountPO bankAccountPO) {
>>>>>>> master
		super();
		this.time = time;
		this.receivingOrganization = receivingOrganization;
		this.incomeHandler = incomeHandler;
		this.incomeSource = incomeSource;
		this.money = money;
<<<<<<< HEAD
		this.location = location;
		this.account = account;
	}
	
=======
		this.account = bankAccountPO;
	}
	
	
	/**
	 * 日期      收款单位     收款人即财务人员       交款营业厅      金额       银行账户
	 */
	
	
>>>>>>> master
	/**
	 * 收款单时间
	 */
	String time = null;
	
	/**
<<<<<<< HEAD
	 * 收款单位编号
=======
	 * 收款单位名
>>>>>>> master
	 */
	String receivingOrganization = null;
	
	/**
<<<<<<< HEAD
	 * 收款人姓名
=======
	 * 收款人姓名（财务人员）
>>>>>>> master
	 */
	String incomeHandler = null;
	
	/**
<<<<<<< HEAD
	 * 交款营业厅编号
=======
	 * 交款营业厅名
>>>>>>> master
	 */
	String incomeSource = null;
	
	/**
<<<<<<< HEAD
	 * 收款数目
	 */
	BigDecimal money = null;
	
	/**
	 * 收款地点
	 */
	String location = null;
=======
	 * 金额
	 */
	String money = null;
>>>>>>> master
	
	/**
	 * 收款账号
	 */
	BankAccountPO account = null;
	
	public String getTime() {
		return time;
	}
	public String getReceivingOrganization() {
		return receivingOrganization;
	}
	public String getIncomeHandler() {
		return incomeHandler;
	}
	public String getIncomeSource() {
		return incomeSource;
	}
<<<<<<< HEAD
	public BigDecimal getMoney() {
		return money;
	}
	public String getLocation() {
		return location;
	}
=======
	public String getMoney() {
		return money;
	}

>>>>>>> master
	public BankAccountPO getAccount() {
		return account;
	}
	
<<<<<<< HEAD
	
=======
	public Object toVO() {
		IncomeNoteVO vo = new IncomeNoteVO(money, time, receivingOrganization, 
				incomeHandler, incomeSource, (BankAccountVO)account.toVO());
		return vo;
	}
>>>>>>> master
}
