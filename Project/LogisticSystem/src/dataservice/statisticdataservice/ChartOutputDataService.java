package dataservice.statisticdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.ChartPO;

public interface ChartOutputDataService extends Remote {

	/**
<<<<<<< HEAD
	 * Data返回封装了详细数据的ChartPO
	 *
=======
	 * ǰ��������ChartPO�ڵĸ���Ϣ�����˸�ʽ���
	 * ����������
>>>>>>> master
	 * @param info
	 * @return
	 * @throws RemoteException
	 */
	public ChartPO getChart(ChartPO info)
			throws RemoteException;
	
}
