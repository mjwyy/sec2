package connection;

import dataservice.infodataservice.SystemUserManagementDataService;

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
//        String x = objectGetter.testObjectGetter();
//        System.out.println(x);
        SystemUserManagementDataService dataService =
                (SystemUserManagementDataService) objectGetter.getObjectByName("SystemUserManagementDataService");
        System.out.println("客户端得到SystemUserManagementDataService");
    }
}
