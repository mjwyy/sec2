package dataservice.statisticdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.util.exception.ElementNotFoundException;
import dataservice.util.exception.InterruptWithExistedElementException;

public interface BusinessDataModificationDataService extends Remote {
	
	/**
<<<<<<< HEAD
	 * Data将city1与city2之间的距离数据改为distance
     *
=======
	 * ǰ��������city��distance�����ʽ���
	 * ����������Data������������У����޸����߾������
>>>>>>> master
	 * @param distance
	 * @param city1
	 * @param city2
	 * @return true for successful modification
	 * @throws RemoteException
<<<<<<< HEAD
	 * @throws ElementNotFoundException
=======
	 * @throws ElementNotFoundException  �Ҳ�������
>>>>>>> master
	 */
	public boolean setDistance(double distance,String city1,String city2)
			throws RemoteException,ElementNotFoundException;
	
	/**
<<<<<<< HEAD
     * Data将name表示的价格条目数值改为newValue
     *
=======
	 * ǰ����������
	 * ����������Data���޸Ķ�Ӧ����
>>>>>>> master
	 * @param name
	 * @param newValue
	 * @return
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 */
	public boolean setPrice(String name,double newValue)
			throws RemoteException,ElementNotFoundException;
<<<<<<< HEAD
	/**
     * Data向数据库中添加name表示的城市记录
     *
=======
	
	public double getPrice(String name)
			throws RemoteException,ElementNotFoundException;
	
	/**
	 * ǰ����������
	 * �������������Ӷ�Ӧ���м�¼
>>>>>>> master
	 * @param name
	 * @return
	 * @throws RemoteException
	 * @throws InterruptWithExistedElementException
	 */
	public boolean addCity(String name)
			throws RemoteException,InterruptWithExistedElementException;
<<<<<<< HEAD

    /**
     * Data返回所有城市名
     *
     * @return
     * @throws RemoteException
     */
	public ArrayList<String> getAllCities()
			throws RemoteException;

    /**
     * Data返回两个城市对应距离数值
     *
     * @param city1
     * @param city2
     * @return
     * @throws RemoteException
     * @throws ElementNotFoundException
     */
	public double getDistance(String city1,String city2)
			throws RemoteException,ElementNotFoundException;

    /**
     * Data返回对应的价格数值
     *
     * @param name
     * @return
     * @throws RemoteException
     * @throws ElementNotFoundException
     */
    public double getPrice(String name)
            throws RemoteException,ElementNotFoundException;
=======
	
	public ArrayList<String> getAllCities()
			throws RemoteException;
	
	public double getDistance(String city1,String city2)
			throws RemoteException,ElementNotFoundException;
>>>>>>> master
}
