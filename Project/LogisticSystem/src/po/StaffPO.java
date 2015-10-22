package po;

import java.io.Serializable;

public class StaffPO implements Serializable {

	private static final long serialVersionUID = 7037298481421583099L;
	
	String name = null;
	String organization = null;
	String IDCardNumber = null;
	double salary = 0.0;
	String phoneNumber = null;
	String position = null;
	double workHour = 0.0;
	
	public StaffPO(String name, String organization, String iDCardNumber,
			double salary, String phoneNumber, String position, double workHour) {
		super();
		this.name = name;
		this.organization = organization;
		IDCardNumber = iDCardNumber;
		this.salary = salary;
		this.phoneNumber = phoneNumber;
		this.position = position;
		this.workHour = workHour;
	}

	public String getName() {
		return name;
	}

	public String getOrganization() {
		return organization;
	}

	public String getIDCardNumber() {
		return IDCardNumber;
	}

	public double getSalary() {
		return salary;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getPosition() {
		return position;
	}

	public double getWorkHour() {
		return workHour;
	}
	
	
	
	
}
