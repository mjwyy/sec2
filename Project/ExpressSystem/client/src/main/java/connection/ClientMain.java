package connection;

import presentation.mainui.loginFrame;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by kylin on 15/11/21.
 */
public class ClientMain {

    public static void main(String[] args) throws RemoteException, NotBoundException {
        RMIHelper.tryConnect();
        loginFrame frame = new loginFrame();
//        RemoteObjectGetter getter = new RemoteObjectGetter();
//        OrderInquiryDataService order = (OrderInquiryDataService)
//                getter.getObjectByName("OrderInquiryDataService");
//        boolean result = order.insertOrderPO("1231231231","货物已被快递员 +deliveryMan+ 签收;");
//        System.out.println(result);

    }
}
