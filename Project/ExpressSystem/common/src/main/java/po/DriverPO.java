package po;

import java.io.Serializable;

import vo.DriverVO;

/**
 * 表示司机信息的PO
 * @author River
 */
public class DriverPO extends StaffPO implements Serializable {

	private static final long serialVersionUID = 5894748451667870139L;
	

	/**
	 * 驾照过期时间
	 */
	String licenseDate = null;

    public DriverPO(String staffID, String name, String organization, String gender,
                    String IDCardNumber, double salary, String phoneNumber,
                    String position, double workHour, String licenseDate) {
        super(staffID, name, organization, gender, IDCardNumber, salary, phoneNumber, position, workHour);
        this.licenseDate = licenseDate;
    }

    public String getLicenseDate() {
        return licenseDate;
    }
}
