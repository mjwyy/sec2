package businesslogic.logistic;

import businesslogicservice.statisticblservice.BusinessDataModificationBLService;
import connection.RMIHelper;
import connection.RemoteObjectGetter;
import dataservice.statisticdataservice.BusinessDataModificationDataService;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kylin on 15/12/15.
 */
public class CityManager {

    private static BusinessDataModificationDataService dataService;

    static {
        RemoteObjectGetter getter = new RemoteObjectGetter();
        dataService = (BusinessDataModificationDataService)
                getter.getObjectByName("BusinessDataModificationDataService");;
    }

    /**
     * 判断一个详细的现实业务地址中的城市是否在系统中存在
     *
     * @param address 现实地址
     * @return 地址中城市是否在系统中存在
     */
    public static boolean hasCity(String address) throws RemoteException {
        ArrayList<String> cities = dataService.getAllCities();
        for (String regex : cities) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(address);
            if (matcher.find())
                return true;
        }
        return false;
    }


    /**
     * 从一个详细的现实业务地址中获取有效的城市名称
     *
     * @param senderAddress 现实地址
     * @return 从地址中找到的城市(如果存在)
     */
    public static String findCity(String senderAddress) throws RemoteException {
        ArrayList<String> cities = dataService.getAllCities();
        for (String regex : cities) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(senderAddress);
            if (matcher.find())
                return regex;
        }
        return null;
    }

}
