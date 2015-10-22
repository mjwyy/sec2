package vo;

public class DriverInfoVO {
	
	/**
	 * 城市编号
	 */
	private String driverNum; 
    
	/**
	 * 姓名
	 */
	private String name;
	
	/**
	 * 出生日期
	 */
	private String birthday;
	
	/**
	 * 身份证号
	 */
	private String IDNum;
	
	/**
	 * 手机号
	 */
	private String phoneNum;
	
	/**
	 * 性别
	 */
	private String sex;
	
	/**
	 * 行驶证期限
	 */
	private String drvingLicencePeriod;
	
	/**
	 * 构造方法
	 * @param cityNum
	 * @param name
	 * @param birthday
	 * @param IDNum
	 * @param phoneNum
	 * @param sex
	 * @param drvingLicencePeriod
	 */
     public DriverInfoVO(String driverNum,String name,String birthday,
    		 String IDNum,String phoneNum,String sex,String drvingLicencePeriod){
    	 this.driverNum = driverNum;
    	 this.name = name;
    	 this.IDNum = IDNum;
    	 this.birthday = birthday;
    	 this.phoneNum = phoneNum;
    	 this.sex = sex;
    	 this.drvingLicencePeriod = drvingLicencePeriod;
    			 
     }
	
}
