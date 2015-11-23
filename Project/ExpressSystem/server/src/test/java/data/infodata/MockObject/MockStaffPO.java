package data.infodata.MockObject;

import po.StaffPO;

public class MockStaffPO extends StaffPO {

	public MockStaffPO(String name, String organization, String iDCardNumber,
			double salary, String phoneNumber, String position, double workHour) {
<<<<<<< HEAD
		super(name, organization, iDCardNumber, salary, phoneNumber, position,
=======
		super(name, organization, iDCardNumber, position, salary, phoneNumber, position,
>>>>>>> master
				workHour);
	}

}
