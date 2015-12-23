package businesslogic.logistic;

import businesslogic.info.StaffOrganizationManagement;
import connection.RMIHelper;
import connection.RemoteObjectGetter;
import dataservice.exception.ElementNotFoundException;
import dataservice.infodataservice.StaffOrganizationManagementDataService;
import dataservice.statisticdataservice.BusinessDataModificationDataService;
import po.StaffPO;
import vo.StaffVO;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kylin on 15/12/15.
 */
public class InfoManager {

    private static BusinessDataModificationDataService businessDataService;
    private static StaffOrganizationManagementDataService staffDataService;

    static {
        RemoteObjectGetter getter = new RemoteObjectGetter();
        businessDataService = (BusinessDataModificationDataService)
                getter.getObjectByName("BusinessDataModificationDataService");
        staffDataService = (StaffOrganizationManagementDataService)
                getter.getObjectByName("StaffOrganizationManagementDataService");
    }

    /**
     * 判断一个详细的现实业务地址中的城市是否在系统中存在
     *
     * @param address 现实地址
     * @return 地址中城市是否在系统中存在
     */
    public static boolean hasCity(String address) throws RemoteException {
        ArrayList<String> cities = businessDataService.getAllCities();
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
        ArrayList<String> cities = businessDataService.getAllCities();
        for (String regex : cities) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(senderAddress);
            if (matcher.find())
                return regex;
        }
        return null;
    }


    /**
     * 判断一个人员是否存在于系统中
     *
     * @param staffName 目标人员的名字
     * @return 查询结果
     */
    public static boolean isStaffInDB(String staffName) throws RemoteException {
        StaffVO vo = new StaffVO(null,staffName,null,null,null,null,-1,null,null);
        StaffPO po = (StaffPO) vo.toPO();
        try {
            ArrayList<StaffPO> staffPOs = staffDataService.findStaff(po);
            if( !staffPOs.isEmpty() )
                return true;
        } catch (ElementNotFoundException e) {
            return false;
        }
        return false;
    }

}
