
package businesslogicservice.infoblservice._driver;

import businesslogic.info.SystemUserManagement;
import businesslogicservice.infoblservice.SystemUserManagementBLService;
import connection.RMIHelper;
import po.UserPO;
import util.ResultMsg;
import util.enums.Authority;
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
//        add(service);
//        del(service);
        find(service);
	}

    private void del(SystemUserManagementBLService service) {
        ResultMsg resultMsg =service.delete(new UserVO
                ("12121212","12121212", Authority.DELIVERY_MAN));
        System.out.println(resultMsg.getMessage());
    }

    public void find(SystemUserManagementBLService service){
        ArrayList<UserVO> result = service.find(new UserVO(
                null,null,Authority.SERVICE_HALL_PERSONNEL));

        System.out.println("result is empty?"+result.isEmpty());

        for (UserVO po2:result) {
            System.out.println(po2.getAuthority()+po2.getUserNum());
        }
    }

    public void add(SystemUserManagementBLService service){
        ResultMsg resultMsg = service.add(new UserVO
                ("12121212","12121212", Authority.DELIVERY_MAN));
        System.out.println(resultMsg.getMessage());
    }
}
