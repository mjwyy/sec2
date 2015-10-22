package dataservice.statisticdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.util.exception.ElementNotFoundException;
import dataservice.util.exception.InterruptWithExistedElementException;

public interface BusinessDataModificationDataService extends Remote {
	
	/**
	 * Data将city1与city2之间的距离数据改为distance
     *
	 * @param distance
	 * @param city1
	 * @param city2
	 * @return true for successful modification
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 */
	public boolean setDistance(double distance,String city1,String city2)
			throws RemoteException,ElementNotFoundException;
	
	/**
     * Data将name表示的价格条目数值改为newValue
     *
	 * @param name
	 * @param newValue
	 * @return
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 */
	public boolean setPrice(String name,double newValue)
			throws RemoteException,ElementNotFoundException;
	/**
     * Data向数据库中添加name表示的城市记录
     *
	 * @param name
	 * @return
	 * @throws RemoteException
	 * @throws InterruptWithExistedElementException
	 */
	public boolean addCity(String name)
			throws RemoteException,InterruptWithExistedElementException;

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
}
