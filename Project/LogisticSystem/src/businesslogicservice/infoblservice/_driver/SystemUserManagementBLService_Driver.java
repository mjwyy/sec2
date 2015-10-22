
package businesslogicservice.infoblservice._driver;

import java.util.ArrayList;

import businesslogic.util.ResultMsg;
import businesslogicservice.infoblservice.SystemUserManagementBLService;
import vo.UserVO;

public class SystemUserManagementBLService_Driver {

	public void drive(SystemUserManagementBLService service){
		
		service.add(new UserVO("0012122", null, null));
		service.delete(new UserVO("0012122", null, null));
		service.find("0012122");
		service.modify(new UserVO("0012122", null, null));
		
	}
	
}
