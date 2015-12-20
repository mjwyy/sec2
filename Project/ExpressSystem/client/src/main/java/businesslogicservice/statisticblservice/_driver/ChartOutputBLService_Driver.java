package businesslogicservice.statisticblservice._driver;

import businesslogic.statistic.ChartOutput;
import businesslogicservice.statisticblservice.ChartOutputBLService;
import connection.RMIHelper;
import util.ResultMsg;
import util.chart.CostAndProfitContent;
import util.enums.ChartType;
import vo.ChartVO;
import vo.CostAndProfitChartVO;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class ChartOutputBLService_Driver {

    public static void main(String[] args) throws RemoteException, NotBoundException {
        RMIHelper.tryConnect();
        ChartOutputBLService_Driver driver = new ChartOutputBLService_Driver();
        ChartOutputBLService service = new ChartOutput();
        driver.drive(service);
    }


	public void drive(ChartOutputBLService service){
        ChartVO chartVO = service.getChartVO(
                ChartType.PROFIT_CHART,  "2015-12-16", "2015-12-20");
        CostAndProfitChartVO costAndProfitChartVO = (CostAndProfitChartVO) chartVO;
            ArrayList<CostAndProfitContent> x = costAndProfitChartVO.getCostAndProfitContents();
        for (CostAndProfitContent a : x){
            System.out.println(a.getDate());
            System.out.println(a.getCost());
            System.out.println(a.getIncome());
        }
    }
}
