package connection;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author River
 * 启动服务器时，只需要调用本类的buildConnection()方法即可
 * 若返回true则成功链接，否则失败，可重复尝试
 *
 */
public class RMIPublisher {
    private String hostIP = "localhost";

    private static RMIPublisher thisObj = null;

    public RMIPublisher() throws RemoteException, MalformedURLException {
        System.out.println("RMI server starting...");

        setHostIP();

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new RMISecurityManager());
        }

        try {
            //服务器开启RMI服务，第一步就是为其注册端口，
            // 通过方法LocateRegistry.createRegistry(1)实现，
            // 该方法返回一个Registry对象，代表对远程对象的一个注册实例。
            Registry registry = LocateRegistry.createRegistry(1099);
            System.out.println("java RMI registry created.");
            // Bind this object instance to the name "RmiServer"
            //第二步，为注册实例绑定RMI服务，通过方法registry.rebind(2)
            //第一个参数表示RMI服务的名称，第二个参数表示RMI服务的实现类对象
            System.out.println("Rebinding");
            //Instantiate RmiServer
            RMIObjectProvider obj = new RMIObjectProvider();
            registry.rebind("RMIObjectProvider", obj);
            System.out.println("PeerServer bound in registry");
        } catch (RemoteException e) {
            // 当端口注册失败时（例如，端口被占用或者不存在的端口号），
            // 该方法抛出RemoteException异常。
            System.out.println("java RMI registry already exists.");
        }

    }

    private void setHostIP() {}


    public static boolean buildConnection() {
        try {
            thisObj = new RMIPublisher();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
