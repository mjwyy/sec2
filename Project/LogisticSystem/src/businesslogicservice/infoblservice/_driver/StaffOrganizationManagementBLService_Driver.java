
package businesslogicservice.infoblservice._driver;

import businesslogicservice.infoblservice.StaffOrganizationManagementBLService;
import vo.OrganizationVO;
import vo.StaffVO;

public class StaffOrganizationManagementBLService_Driver {
	
	
	public void drive(StaffOrganizationManagementBLService service){
		if(service.addStaff(new StaffVO("Tommy", null, null, null, 2, null, 1.0)).isPass()){
			System.out.println("Passed");
		}else{
			System.out.println("Failed");
		}
		
		if(service.delStaff(new StaffVO("Tommy", null, null, null, 2, null, 1.0)).isPass()){
			System.out.println("Passed");
		}else{
			System.out.println("Failed");
		}
		
		if(service.ModifyStaff(new StaffVO("Tommy", null, null, null, 2, null, 1.0)).isPass()){
			System.out.println("Passed");
		}else{
			System.out.println("Failed");
		}
		
		if(service.addOrganization(new OrganizationVO("002122", null)).isPass()){
			System.out.println("Passed");
		}else{
			System.out.println("Failed");
		}
		
		if(service.delOrganization(new OrganizationVO("002122", null)).isPass()){
			System.out.println("Passed");
		}else{
			System.out.println("Failed");
		}
		
		if(service.ModifyOrganization(new OrganizationVO("002122", null)).isPass()){
			System.out.println("Passed");
		}else{
			System.out.println("Failed");
		}

		if(service.findStaffInfo(new StaffVO("Tommy", null, null, null, 2, null, 1.0))!=null){
			System.out.println("Got list");
		}else{
			System.out.println("Null return");
		}
		
		if(service.findOrgInfo(new OrganizationVO("002122", null))!=null){
			System.out.println("Got list");
		}else{
			System.out.println("Null return");
		}

	}
}
