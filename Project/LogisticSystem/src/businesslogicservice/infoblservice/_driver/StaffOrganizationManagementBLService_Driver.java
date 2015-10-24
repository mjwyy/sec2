
package businesslogicservice.infoblservice._driver;

import java.util.ArrayList;

import businesslogic.util.ResultMsg;
import businesslogicservice.infoblservice.StaffOrganizationManagementBLService;
import vo.OrganizationInfoVO;
import vo.StaffInfoVO;
/**
 * 
 * @author River
 *
 */
public class StaffOrganizationManagementBLService_Driver {
	
	
	public void drive(StaffOrganizationManagementBLService service){
		service.addStaff(new StaffInfoVO("Mark", null, null, null, 2, null, 1.0));
		service.delStaff(new StaffInfoVO("Mark", null, null, null, 2, null, 1.0));
		service.findStaffInfo("Mark");
		service.ModifyStaff(new StaffInfoVO("Mark", null, null, null, 2, null, 1.0));
		
		service.addOrganization(new OrganizationInfoVO("002122", null));
		service.delOrganization(new OrganizationInfoVO("002122", null));
		service.findOrgInfo("002122");
		service.ModifyOrganization(new OrganizationInfoVO("002122", null));

	}
}
