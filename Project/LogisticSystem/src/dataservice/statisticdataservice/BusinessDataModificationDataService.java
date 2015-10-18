package dataservice.statisticdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.data_service_exception.ElementNotFoundException;
import dataservice.data_service_exception.InterruptWithExistedElementException;

public interface BusinessDataModificationDataService extends Remote {
	
	/**
	 * 前置条件：city、distance经过格式检查
	 * 后置条件：Data层查找两个城市，并修改两者距离参数
	 * @param distance
	 * @param city1
	 * @param city2
	 * @return true for successful modification
	 * @throws RemoteException
	 * @throws ElementNotFoundException  找不到城市
	 */
	public boolean setDistance(double distance,String city1,String city2)
			throws RemoteException,ElementNotFoundException;
	
	/**
	 * 前置条件：无
	 * 后置条件：Data层修改对应常量
	 * @param name
	 * @param newValue
	 * @return
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 */
	public boolean setPrice(String name,double newValue)
			throws RemoteException,ElementNotFoundException;
	/**
	 * 前置条件：无
	 * 后置条件：增加对应城市记录
	 * @param name
	 * @return
	 * @throws RemoteException
	 * @throws InterruptWithExistedElementException
	 */
	public boolean addCity(String name)
			throws RemoteException,InterruptWithExistedElementException;
	
	public ArrayList<String> getAllCities()
			throws RemoteException;
	
	public double getDistance(String city1,String city2)
			throws RemoteException,ElementNotFoundException;
}
