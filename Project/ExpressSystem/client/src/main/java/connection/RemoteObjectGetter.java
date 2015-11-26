package connection;

import dataservice.infodataservice.SystemUserManagementDataService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * @author River
 *
 * 实际需要使用远程对象时，只需新建此对象，然后
 * 调用getObjectByName(String name)即可
 *
 */
public class RemoteObjectGetter {

    private RMIObjectProviderService provider = null;

    public RemoteObjectGetter() {
        try {
            RMIHelper.tryConnect();
            if(RMIHelper.getConnectionStatus()){
                RMIHelper helper = RMIHelper.getInstance();
                provider = helper.getProvider();
            }else
                System.out.println("RMIHelper.getConnectionStatus()==失败");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }

    public Object getObjectByName(String name) {
        Object object = null;
        try {
            object = provider.getObjectByName(name);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return object;
    }

}
