package po;

import java.io.Serializable;

public class DriverPO implements Serializable {

	private static final long serialVersionUID = 5894748451667870139L;
	
	String driverNumber = null;
	String hallNumber = null;
	String name = null;
	String birthday = null;
	String IDCardNumber = null;
	String phoneNumber = null;
	String gender = null;
	String licenseDate = null;
	
	public DriverPO(String driverNumber, String hallNumber, String name,
			String birthday, String iDCardNumber, String phoneNumber,
			String gender, String licenseDate){
		this.driverNumber = driverNumber;
		this.hallNumber = hallNumber;
		this.name = name;
		this.birthday = birthday;
		this.IDCardNumber = iDCardNumber;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.licenseDate = licenseDate;
	}
	
	public String getDriverNumber() {
		return driverNumber;
	}
	public void setDriverNumber(String driverNumber) {
		this.driverNumber = driverNumber;
	}
	public String getHallNumber() {
		return hallNumber;
	}
	public void setHallNumber(String hallNumber) {
		this.hallNumber = hallNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getIDCardNumber() {
		return IDCardNumber;
	}
	public void setIDCardNumber(String iDCardNumber) {
		IDCardNumber = iDCardNumber;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getLicenseDate() {
		return licenseDate;
	}
	public void setLicenseDate(String licenseDate) {
		this.licenseDate = licenseDate;
	}
	
}
