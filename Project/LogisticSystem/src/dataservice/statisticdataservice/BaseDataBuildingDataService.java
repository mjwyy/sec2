package dataservice.statisticdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 
 * @author River
 * �ڳ����˵���������ɾ�Ĳ�Ľӿ�
 * һ����ʼ�ڳ����˲������ڼ�Data��ֹ�����û����ݷ������޸�
 */
public interface BaseDataBuildingDataService extends Remote {
	
	/**
	 * ǰ����������
	 * ����������Data��ʼ���ܵ�һ�ͻ��˲�������
	 * @param withBase
	 * @return
	 * @throws RemoteException
	 */
	public boolean startBaseDataBuilding(boolean withBase)
			throws RemoteException;
	
	/**
	 * ǰ�����������˵Ŀͻ�������˽������в���
	 * ����������Data��������ˣ���ʹ������
	 * @return
	 * @throws RemoteException
	 */
	public boolean endBaseDataBuilding()
			throws RemoteException;
	
}
