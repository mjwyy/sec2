
package businesslogicservice.infoblservice._driver;

import businesslogicservice.infoblservice.StaffOrganizationManagementBLService;
import vo.OrganizationInfoVO;
import vo.StaffInfoVO;

public class StaffOrganizationManagementBLService_Driver {
	
	
	public void drive(StaffOrganizationManagementBLService service){
		service.addStaff(new StaffInfoVO("Tommy", null, null, null, 2, null, 1.0));
		service.delStaff(new StaffInfoVO("Tommy", null, null, null, 2, null, 1.0));
		service.findStaffInfo(new StaffInfoVO("Tommy", null, null, null, 2, null, 1.0));
		service.ModifyStaff(new StaffInfoVO("Tommy", null, null, null, 2, null, 1.0));
		
		service.addOrganization(new OrganizationInfoVO("002122", null));
		service.delOrganization(new OrganizationInfoVO("002122", null));
		service.findOrgInfo(new OrganizationInfoVO("002122", null));
		service.ModifyOrganization(new OrganizationInfoVO("002122", null));

	}
}
