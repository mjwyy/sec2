package dataservice.statisticdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.ChartPO;

public interface ChartOutputDataService extends Remote {

	/**
	 * 前置条件：ChartPO内的各信息经过了格式检查
	 * 后置条件：
	 * @param info
	 * @return
	 * @throws RemoteException
	 */
	public ChartPO getChart(ChartPO info)
			throws RemoteException;
	
}
