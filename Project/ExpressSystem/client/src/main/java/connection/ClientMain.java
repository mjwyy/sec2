package connection;

import businesslogic.statistic.ChartOutput;
import dataservice.infodataservice.SystemUserManagementDataService;
import dataservice.statisticdataservice.OrderInquiryDataService;
import po.UserPO;
import presentation.mainui.loginFrame;
import util.enums.Authority;
import vo.BusinessStateChartVO;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

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
