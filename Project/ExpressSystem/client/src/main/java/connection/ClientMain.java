package connection;

import dataservice.infodataservice.SystemUserManagementDataService;
import po.UserPO;
<<<<<<< HEAD
=======
import util.enums.Authority;
>>>>>>> master

/**
 * Created by kylin on 15/11/21.
 */
public class ClientMain {
    public static void main(String[] args) {
        RemoteObjectGetter objectGetter = new RemoteObjectGetter();
        SystemUserManagementDataService dataService =
                (SystemUserManagementDataService) objectGetter.getObjectByName("SystemUserManagementDataService");
        System.out.println("客户端得到SystemUserManagementDataService");
        try {
<<<<<<< HEAD
            dataService.addUser(new UserPO("twokylin","twokylin",6));
=======
            dataService.addUser(new UserPO("host","twokylin",6));
>>>>>>> master
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
