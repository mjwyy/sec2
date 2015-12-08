package businesslogicservice.statisticblservice._driver;

import businesslogic.statistic.ChartOutput;
import businesslogicservice.statisticblservice.ChartOutputBLService;
import connection.RMIHelper;
import util.ResultMsg;
import util.enums.ChartType;
import vo.ChartVO;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ChartOutputBLService_Driver {

    public static void main(String[] args) throws RemoteException, NotBoundException {
        RMIHelper.tryConnect();
        ChartOutputBLService_Driver driver = new ChartOutputBLService_Driver();
        ChartOutputBLService service = new ChartOutput();
        driver.drive(service);
    }


	public void drive(ChartOutputBLService service){
        ChartVO chartVO = service.getChartVO(
                ChartType.BUSINESS_STAT_CHART,  "2015-12-20", "2015-12-30");
       ResultMsg msg =  service.exportChart(chartVO,"/Users/kylin/Documents/");
        System.out.println(msg.getMessage());
    }
}
