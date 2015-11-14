
package businesslogicservice.infoblservice._driver;

import businesslogicservice.infoblservice.StaffOrganizationManagementBLService;
import vo.OrganizationInfoVO;
import vo.StaffVO;

public class StaffOrganizationManagementBLService_Driver {
	
	
	public void drive(StaffOrganizationManagementBLService service){
		service.addStaff(new StaffVO("Tommy", null, null, null, 2, null, 1.0));
		service.delStaff(new StaffVO("Tommy", null, null, null, 2, null, 1.0));
		service.findStaffInfo(new StaffVO("Tommy", null, null, null, 2, null, 1.0));
		service.ModifyStaff(new StaffVO("Tommy", null, null, null, 2, null, 1.0));
		
		service.addOrganization(new OrganizationInfoVO("002122", null, null, null));
		service.delOrganization(new OrganizationInfoVO("002122", null, null, null));
		service.findOrgInfo(new OrganizationInfoVO("002122", null, null, null));
		service.ModifyOrganization(new OrganizationInfoVO("002122", null, null, null));

	}
}
