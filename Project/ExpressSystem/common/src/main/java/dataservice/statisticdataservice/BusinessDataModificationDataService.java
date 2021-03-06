package dataservice.statisticdataservice;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import po.DistancePO;
import util.enums.PriceType;

/**
 * @author River
 */
public interface BusinessDataModificationDataService extends Remote, Serializable {


    /**
     * Data向数据库中添加name表示的城市记录
     *
     * @param name
     * @return
     * @throws RemoteException
     * @throws InterruptWithExistedElementException
     */
    boolean addCity(String name)
            throws RemoteException, InterruptWithExistedElementException;

    /**
     * Data返回所有城市名
     *
     * @return
     * @throws RemoteException
     */
    ArrayList<String> getAllCities()
            throws RemoteException;

    /**
     * Data将name表示的价格条目数值改为newValue
     *
     * @param name
     * @param price
     * @return
     * @throws RemoteException
     * @throws ElementNotFoundException
     */
    boolean setPrice(PriceType name, double price)
            throws RemoteException, ElementNotFoundException;

    /**
     * Data返回对应的价格数值
     *
     * @param name
     * @return
     * @throws RemoteException
     * @throws ElementNotFoundException
     */
    double getPrice(PriceType name)
            throws RemoteException, ElementNotFoundException;


    /**
     * Data将city1与city2之间的距离数据改为distance
     *
     * @param distancePO
     * @return true for successful modification
     * @throws RemoteException
     * @throws ElementNotFoundException
     */
    boolean setDistance(DistancePO distancePO)
            throws RemoteException, ElementNotFoundException;

    /**
     * Data返回两个城市对应距离数值
     *s
     * @param city1
     * @param city2
     *
     * @return
     * @throws RemoteException
     * @throws ElementNotFoundException
     */
    double getDistance(String city1, String city2)
            throws RemoteException, ElementNotFoundException;
}
