package connection;


import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author River
 *
 * 本类RMIHelper用于在程序启动时建立起对服务器的连接
 * 其中，必须先调用tryConnect()尝试连接链接
 * 之后用getConnectionStatus()检查是否成功建立了连接
 *
 */
public class RMIHelper {

    private static String serverIP = "localhost";
    private static String objectiveName = "RMIObjectProvider";

    private RMIObjectProviderService provider = null;

    private static RMIHelper obj;

    private boolean connectStatus = false;

    private RMIHelper() {
        initiateIP();
    }

    private void initiateIP() {}

    public static void tryConnect() throws RemoteException, NotBoundException {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        obj = new RMIHelper();
        // 客户端通过方法Naming.lookup(1)查找RMI服务，
        // 如果查找成功，将返回一个代表远程服务对象的桩对象，客户端应当进行强制类型转换为接口来使用。
        // lookup的参数是一个URL，格式是：rmi://<服务器IP地址>:<端口号>/<服务名称>。
        Registry registry = LocateRegistry.getRegistry(serverIP);
        Remote provider = registry.lookup(objectiveName);
        obj.provider = (RMIObjectProviderService) provider;
        System.out.println("客户端成功获得RMIObjectProviderService");
        obj.connectStatus = true;
    }

    public static boolean getConnectionStatus() {
        if(obj==null) obj = new RMIHelper();
        return obj.connectStatus;
    }

    public static RMIHelper getInstance() {
        return obj;
    }

    public RMIObjectProviderService getProvider() {
        return obj.provider;
    }
}
