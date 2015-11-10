package connection;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
<<<<<<< HEAD
 *
=======
 * 
>>>>>>> origin/master
 * @author River
 * 启动服务器时，只需要调用本类的buildConnection()方法即可
 * 若返回true则成功链接，否则失败，可重复尝试
 */
public class RMIPublisher {
<<<<<<< HEAD
    private String hostIP = "localhost";

    private static RMIPublisher thisObj = null;

    public RMIPublisher() throws RemoteException, MalformedURLException {
        System.out.println("RMI server started");

        setHostIP();

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        try { //special exception handler for registry creation
            LocateRegistry.createRegistry(1099);
=======

	private String hostIP = "localhost";
	
	private static RMIPublisher thisObj = null;
	
	public RMIPublisher() throws RemoteException, MalformedURLException  {
		System.out.println("RMI server started");

		setHostIP();
		
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        
        try { //special exception handler for registry creation
            LocateRegistry.createRegistry(1099); 
>>>>>>> origin/master
            System.out.println("java RMI registry created.");
        } catch (RemoteException e) {
            //do nothing, error means registry already exists
            System.out.println("java RMI registry already exists.");
        }
<<<<<<< HEAD

        //Instantiate RmiServer

        RMIObjectProvider obj = new RMIObjectProvider();

=======
           
        //Instantiate RmiServer

        RMIObjectProvider obj = new RMIObjectProvider();
        
>>>>>>> origin/master
        System.out.println("Rebinding");
        // Bind this object instance to the name "RmiServer"
        Naming.rebind("//"+hostIP+"/RMIObjectProvider", obj);
        System.out.println("PeerServer bound in registry");
<<<<<<< HEAD
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
=======
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
>>>>>>> origin/master
}
