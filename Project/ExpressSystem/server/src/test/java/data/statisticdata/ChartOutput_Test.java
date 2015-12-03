package data.statisticdata;
/**
 *@author  wwz
 * @time 2015/11/15
 */
import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Test;

import po.chart.BusinessStateChartPO;
import util.chart.BusinessStateContent;
import util.enums.ChartType;
import data.statisticdata.MockObject.MockBusinessStateChart;
import data.statisticdata.MockObject.MockCostAndProfitChart;
import dataservice.statisticdataservice.ChartOutputDataService;

public class ChartOutput_Test {
    
	private ChartOutputDataService service = new ChartOutputData();
	@Test
	public void testGetBusinessStateChart() throws RemoteException {
        BusinessStateChartPO businessStateChartPO =
                service.getBusinessStateChart(new BusinessStateChartPO("2015-12-20","2015-12-30"));
		ArrayList<BusinessStateContent> contents  = businessStateChartPO.getContents();
        System.out.println(contents.size());
    }
    @Test
	public void testGetCostAndProfitChart() throws RemoteException{
	}

}
