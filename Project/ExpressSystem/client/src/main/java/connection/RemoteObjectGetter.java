package connection;

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
                RMIHelper helper = RMIHelper.getInstance();
                provider = helper.getProvider();
    }

    public Object getObjectByName(String name) {
        Object object = null;
        try {
            object = provider.getObjectByName(name);
        } catch (RemoteException e) {
            System.out.println("Got remote exception");
            e.printStackTrace();
        }
        return object;
    }

}
