package dataservice.financedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 
 * @author River
<<<<<<< HEAD
 */
public interface BaseDataBuildingDataService extends Remote {

	/**
	 * Data开始接受单一客户端操作请求
	 *
=======
 * �ڳ����˵���������ɾ�Ĳ�Ľӿ�
 * һ����ʼ�ڳ����˲������ڼ�Data��ֹ�����û����ݷ������޸�
 */
public interface BaseDataBuildingDataService extends Remote {
	
	/**
	 * ǰ����������
	 * ����������Data��ʼ���ܵ�һ�ͻ��˲�������
	 * @param withBase
>>>>>>> master
	 * @return
	 * @throws RemoteException
	 */
	public boolean startBaseDataBuilding(boolean withBase)
			throws RemoteException;
<<<<<<< HEAD

	/**
	 * Data层结束建账，并使用新账
	 *
=======
	
	/**
	 * ǰ�����������˵Ŀͻ�������˽������в���
	 * ����������Data��������ˣ���ʹ������
>>>>>>> master
	 * @return
	 * @throws RemoteException
	 */
	public boolean endBaseDataBuilding()
			throws RemoteException;
	
}
