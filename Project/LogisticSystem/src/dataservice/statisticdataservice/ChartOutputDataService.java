package dataservice.statisticdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.ChartPO;

public interface ChartOutputDataService extends Remote {

	/**
	 * Data返回封装了详细数据的ChartPO
	 *
	 * @param info
	 * @return
	 * @throws RemoteException
	 */
	public ChartPO getChart(ChartPO info)
			throws RemoteException;
	
}
