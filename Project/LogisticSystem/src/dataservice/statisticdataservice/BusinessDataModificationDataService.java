package dataservice.statisticdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.DistancePO;
import dataservice.util.exception.ElementNotFoundException;
import dataservice.util.exception.InterruptWithExistedElementException;

public interface BusinessDataModificationDataService extends Remote {
	
	/**
	 * ǰ��������city��distance�����ʽ���
	 * ����������Data������������У����޸����߾������
	 * @param distance
	 * @param city1
	 * @param city2
	 * @return true for successful modification
	 * @throws RemoteException
	 * @throws ElementNotFoundException  �Ҳ�������
	 */
	public boolean setDistance(DistancePO distancePO)
			throws RemoteException,ElementNotFoundException;
	
	/**
	 * ǰ����������
	 * ����������Data���޸Ķ�Ӧ����
	 * @param name
	 * @param newValue
	 * @return
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 */
	public boolean setPrice(String name,double newValue)
			throws RemoteException,ElementNotFoundException;
	/**
	 * ǰ����������
	 * �������������Ӷ�Ӧ���м�¼
	 * @param name
	 * @return
	 * @throws RemoteException
	 * @throws InterruptWithExistedElementException
	 */
	public boolean addCity(String name)
			throws RemoteException,InterruptWithExistedElementException;
	
	public ArrayList<String> getAllCities()
			throws RemoteException;
	
<<<<<<< HEAD
	public double getDistance(DistancePO distancePO)
=======
	public double getDistance(String city1,String city2)
>>>>>>> parent of 2d8eb69... 10.22这个世界没有锟斤拷版本
			throws RemoteException,ElementNotFoundException;
}
