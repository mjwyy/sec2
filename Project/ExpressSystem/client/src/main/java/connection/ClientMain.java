package connection;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by kylin on 15/11/21.
 */
public class ClientMain {

    public static void main(String[] args) throws RemoteException, NotBoundException {
        RMIHelper.tryConnect();
//        loginFrame frame = new loginFrame();
//        StorageInBLService ser = new StorageIn();
        

    }
}
