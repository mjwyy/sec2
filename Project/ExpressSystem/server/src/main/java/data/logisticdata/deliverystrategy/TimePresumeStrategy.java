package data.logisticdata.deliverystrategy;

import data.statisticdata.BusinessDataModificationData;
import dataservice.exception.ElementNotFoundException;
import dataservice.statisticdataservice.BusinessDataModificationDataService;
import util.enums.DeliverCategory;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by kylin on 15/11/30.
 */
public class TimePresumeStrategy {


    public String getPresumedTime(DeliveryInfo deliveryInfo)
            throws ElementNotFoundException, RemoteException, SQLException {
        //获取需要的寄件单信息
        double distance = deliveryInfo.getDistance();
        DeliverCategory category = deliveryInfo.getCategory();

        //获取当前系统时间
        Date startDay = new Date();

        //预测时间业务逻辑
        double time = distance/300 * 60 * 60 * 1000;
        if (category == DeliverCategory.EXPRESS)
            time = time/2;
        else if (category == DeliverCategory.ECNOMIC)
            time = time*1.5;

        long longTime = (long) time;
        Date arrivalDay = new Date((startDay.getTime()+longTime));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(arrivalDay);
    }
}
