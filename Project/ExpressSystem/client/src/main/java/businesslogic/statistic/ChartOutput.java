package businesslogic.statistic;

import businesslogicservice.statisticblservice.ChartOutputBLService;
import dataservice.statisticdataservice.ChartOutputDataService;
import po.ChartPO;
import po.chart.BusinessStateChartPO;
import po.chart.CostAndProfitChartPO;
import util.ResultMsg;
import util.enums.ChartType;
import vo.BusinessStateChartVO;
import vo.ChartVO;
import vo.CostAndProfitChartVO;

import java.rmi.RemoteException;

/**
 * Created by kylin on 15/11/17.
 */
public class ChartOutput implements ChartOutputBLService {

    private ChartOutputDataService dataService;

    private ChartVO inputChartVO;

    private BusinessStateChartVO businessStateVO;
    private BusinessStateChartPO businessStatePO;

    private CostAndProfitChartVO costAndProfitVO;
    private CostAndProfitChartPO costAndProfitPO;

    @Override
    public ResultMsg enquiryChart(ChartType chartType, String time1, String time2) {
        this.inputChartVO = new ChartVO(chartType,time1,time2);
        ResultMsg formatCheck = inputChartVO.checkFormat();
        if(formatCheck.isPass())
            this.getChartVO(chartType,time1,time2);
        return formatCheck;
    }

    @Override
    public ChartVO getChartVO(ChartType chartType, String time1, String time2) {
        try {
            if (chartType == ChartType.BUSINESS_STAT_CHART){
                businessStatePO = dataService.getBusinessStateChart(new BusinessStateChartPO(time1,time2));
                businessStateVO = new BusinessStateChartVO(
                        time1,time2,businessStatePO.getProfix(),businessStatePO.getGrowthRate());
                return businessStateVO;
            }
            else{
                costAndProfitPO = dataService.getCostAndProfitChart(new CostAndProfitChartPO(time1,time2));
                costAndProfitVO = new CostAndProfitChartVO(
                        time1,time2,costAndProfitPO.getCost(),costAndProfitPO.getProfit());
                return costAndProfitVO;
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultMsg exportChart(String path) {
        //TODO 报表内容存在问题
        return null;
    }
}
