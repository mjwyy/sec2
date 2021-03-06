package connection;

import connection.config.RMIConfig;

import java.net.MalformedURLException;
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
    private String hostIP;
    private int regPort;

    private static RMIPublisher thisObj = null;
    private DisconnectionCheckerObj disconnObj = null;

    public RMIPublisher() throws RemoteException, MalformedURLException {
        System.out.println("RMI server starting...");
        setHostIP();

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new RMISecurityManager());
        }

        disconnObj = new DisconnectionCheckerObj();

        try {
            StaticRmiSocketFactory regFac = new StaticRmiSocketFactory(hostIP, regPort);
            Registry reg = LocateRegistry.createRegistry(regPort, regFac, regFac);
            System.out.println("java RMI registry created.");
            System.out.println("Rebinding");
            //Instantiate RmiServer
            RMIObjectProvider obj = new RMIObjectProvider();
            reg.rebind("RMIObjectProvider", obj);
            reg.rebind("DisconnectionCheckerObj",disconnObj);
            System.out.println("PeerServer bound in registry");
        } catch (RemoteException e) {
            // 当端口注册失败时（例如，端口被占用或者不存在的端口号），
            // 该方法抛出RemoteException异常。
            System.out.println("java RMI registry already exists.");
            e.printStackTrace();
        }

    }

    /**
     * 服务器向指定的IP与端口注册
     */
    private void setHostIP() {
        hostIP =  RMIConfig.getServerIP();
        regPort =  Integer.parseInt(RMIConfig.getPort());
    }

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
