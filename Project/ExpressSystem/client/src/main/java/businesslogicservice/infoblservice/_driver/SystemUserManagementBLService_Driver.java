
package businesslogicservice.infoblservice._driver;

import businesslogic.info.SystemUserManagement;
import businesslogicservice.infoblservice.SystemUserManagementBLService;
import connection.RMIHelper;
import po.UserPO;
import vo.UserVO;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class SystemUserManagementBLService_Driver {

    public static void main(String[] args) throws RemoteException, NotBoundException {
        RMIHelper.tryConnect();
        SystemUserManagementBLService_Driver driver = new SystemUserManagementBLService_Driver();
        SystemUserManagement systemUserManagement = new SystemUserManagement();
        driver.drive(systemUserManagement);
    }

	public void drive(SystemUserManagementBLService service){
        ArrayList<UserVO> result = service.find(new UserVO("1234567",null,null));
        for (UserVO po2:result) {
            System.out.println(po2.getAuthority());
        }

	}
	
}
