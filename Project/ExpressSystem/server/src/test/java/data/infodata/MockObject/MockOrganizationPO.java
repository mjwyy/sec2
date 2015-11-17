package data.infodata.MockObject;

import java.util.ArrayList;

import po.OrganizationPO;
import po.StaffPO;

public class MockOrganizationPO extends OrganizationPO {

	public MockOrganizationPO(String type, String code, String name,
			ArrayList<StaffPO> staff) {
		super(type, code, name, staff);
	}

}
