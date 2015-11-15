package dataservice.statisticdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import po.DistancePO;
import util.enums.PriceType;

/**
* @author River
*/
public interface BusinessDataModificationDataService extends Remote {
	

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
     * Data将name表示的价格条目数值改为newValue
     *
	 * @param name
	 * @param double price
	 * @return
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 */
	public boolean setPrice(PriceType name, double price)
			throws RemoteException,ElementNotFoundException;
	
    /**
     * Data返回对应的价格数值
     *
     * @param name
     * @return
     * @throws RemoteException
     * @throws ElementNotFoundException
     */
    public double getPrice(PriceType name)
            throws RemoteException,ElementNotFoundException;
    
    
    /**
	 * Data将city1与city2之间的距离数据改为distance
     *
	 * @param distancePO
	 * @return true for successful modification
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 */
	public boolean setDistance(DistancePO distancePO)
			throws RemoteException,ElementNotFoundException;
	
	/**
     * Data返回两个城市对应距离数值
     *
     * @param distancePO
     * @return
     * @throws RemoteException
     * @throws ElementNotFoundException
     */
	public DistancePO getDistance(DistancePO distancePO)
			throws RemoteException,ElementNotFoundException;
}
