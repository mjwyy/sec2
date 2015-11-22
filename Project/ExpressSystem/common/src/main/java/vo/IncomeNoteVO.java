package vo;

import po.IncomeNotePO;
import util.FormatCheck;
import util.ResultMsg;

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
	
	private BankAccountVO bankAccount;
	
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
			String payee,String payService,String place,BankAccountVO bankAccount){
		this.date = date;
		this.institution =institution;
		this.money = money;
		this.payee = payee;
		this.payService = payService;
		this.place = place;
		this.bankAccount = bankAccount;
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

	public BankAccountVO getBankAccount() {
		return bankAccount;
	}
	
	public ResultMsg checkFormat(){
		ResultMsg[] msgs = new ResultMsg[7];
		msgs[0] = FormatCheck.isDate(date);
		msgs[1] = FormatCheck.isOrganizationName(institution);
		msgs[2] = FormatCheck.isMoney(money);
		msgs[3] = FormatCheck.isChineseName(payee);
		msgs[4] = FormatCheck.isServiceHall(payService);
		msgs[5] = FormatCheck.isTransitCenter(place);
		msgs[6] = bankAccount.checkFormat();
		
		for(int i=0;i<msgs.length;i++) {
			if(!msgs[i].isPass()) return msgs[i];
		}
		
		return new ResultMsg(true);
	}
	
	public Object toPO() {
		
		//TODO 参数根本不对应!
		IncomeNotePO po = new IncomeNotePO(date, institution, payService, payee, null, place, null);
		
		return po;
	}
	
}
