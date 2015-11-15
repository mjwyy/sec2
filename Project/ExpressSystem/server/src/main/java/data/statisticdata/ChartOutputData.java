package data.statisticdata;
/**
 * @author wwz
 * @date 2015/11/14
 */
import java.rmi.RemoteException;

import po.ChartPO;
import dataservice.statisticdataservice.ChartOutputDataService;

public class ChartOutputData implements ChartOutputDataService{

	@Override
	public ChartPO getChart(ChartPO info) throws RemoteException {
		return null;
	}

}
