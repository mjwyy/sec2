package vo;

import util.ResultMsg;
import util.enums.StaffType;

public class DriverVO extends StaffVO {

    /**
     * 驾照过期时间
     */
    String licenseDate = null;

    public DriverVO(String name, String sex, String organization, StaffType postion, String IDNum,
                    int workingtime, String phoneNum, String wage, String licenseDate) {
        super(name, sex, organization, postion, IDNum, workingtime, phoneNum, wage);
        this.licenseDate = licenseDate;
    }

    public Object toPO() {
        return null;
		//TODO Fill up!
	}
	
	public ResultMsg checkFormat(){
		return null;
		//TODO So it is!
	}
}
