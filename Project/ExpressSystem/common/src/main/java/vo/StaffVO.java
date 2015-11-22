package vo;

import javax.print.DocFlavor.READER;

import po.StaffPO;
import util.FormatCheck;
import util.ResultMsg;

public class StaffVO {
	
	/**
	 * 姓名
	 */
	private String name;
	
	/**
	 * 性别
	 */
	private String sex;
	
	/**
	 * 职位
	 */
	private String  postion;
	
	/**
	 * 身份证
	 */
	private String IDNum;
	
	/**
	 * 工作时长（按月）
	 */
	private int workingtime;
	
	/**
	 * 手机
	 */
	private String phoneNum;
	
	/**
	 * 工资
	 */
	private String wage;
	
	/**
	 * @param name
	 * @param sex
	 * @param postion
	 * @param IDNum
	 * @param workingtime
	 * @param phoneNum
	 * @param wage
	 */
	public StaffVO(String name,String sex,String postion,String IDNum,int workingtime,String phoneNum,String wage){
		this.name = name;
		this.sex = sex;
		this.IDNum = IDNum;
		this.phoneNum = phoneNum;
		this.postion = postion;
		this.wage = wage;
		this.workingtime = workingtime;
	}

	public String getName() {
		return name;
	}

	public String getSex() {
		return sex;
	}

	public String getPostion() {
		return postion;
	}

	public String getIDNum() {
		return IDNum;
	}

	public int getWorkingtime() {
		return workingtime;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public String getWage() {
		return wage;
	}
	
	public ResultMsg checkFormat() {
		ResultMsg[] msgs = new ResultMsg[6];
		
		msgs[0] = FormatCheck.isChineseName(name);
		msgs[1] = FormatCheck.isGender(sex);
		msgs[2] = FormatCheck.isPhoneNumber(phoneNum);
		msgs[3] = FormatCheck.isIDNumber(IDNum);
		msgs[4] = FormatCheck.isVocation(postion);
		msgs[5] = FormatCheck.isSalary(wage);
		msgs[6] = workingtime>0?new ResultMsg(true):new ResultMsg(false,"工作时间应为正数");

		for(int i=0;i<msgs.length;i++) {
			if(!msgs[i].isPass()) return  msgs[i];
		}
		
		return new ResultMsg(true);
		
	}

	public Object toPO() {
		//TODO PO,VO 不一致！
		StaffPO po = null;
		return po;
	}
	
}
