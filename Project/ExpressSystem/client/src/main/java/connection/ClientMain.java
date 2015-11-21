package connection;

import dataservice.infodataservice.SystemUserManagementDataService;
import po.UserPO;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

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
            dataService.addUser(new UserPO("test10","test10",2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
