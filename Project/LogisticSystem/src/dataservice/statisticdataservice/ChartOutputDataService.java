package dataservice.statisticdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.ChartPO;

public interface ChartOutputDataService extends Remote {

	/**
	 * ǰ��������ChartPO�ڵĸ���Ϣ�����˸�ʽ���
	 * ����������
	 * @param info
	 * @return
	 * @throws RemoteException
	 */
	public ChartPO getChart(ChartPO info)
			throws RemoteException;
	
}
