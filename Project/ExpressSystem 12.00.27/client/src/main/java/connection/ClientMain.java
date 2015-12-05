package connection;

import businesslogic.statistic.ChartOutput;
import dataservice.infodataservice.SystemUserManagementDataService;
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
    }
}
