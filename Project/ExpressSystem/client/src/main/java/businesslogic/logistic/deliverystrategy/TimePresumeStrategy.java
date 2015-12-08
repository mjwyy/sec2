package businesslogic.logistic.deliverystrategy;

import dataservice.exception.ElementNotFoundException;
import util.enums.DeliverCategory;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by kylin on 15/11/30.
 */
public class TimePresumeStrategy {

    /**
     * 根据寄件单信息预测预计到达日期
     *
     * @param deliveryInfo 寄件单信息
     * @return 预计到达日期
     */
    public String getPresumedTime(DeliveryInfo deliveryInfo) {
        //获取需要的寄件单信息
        double distance = deliveryInfo.getDistance();
        DeliverCategory category = deliveryInfo.getCategory();

        //获取当前系统时间
        Date startDay = new Date();
        //预测时间业务逻辑
        double time = distance/30 * 60 * 60 * 1000;
        //同一城市内保证一天到达
        if(deliveryInfo.getCity1().equals(deliveryInfo.getCity2())){
            time = 24 * 60 * 60 * 1000;
        }
        if (category == DeliverCategory.EXPRESS)
            time = time/1.5;
        else if (category == DeliverCategory.ECNOMIC)
            time = time*1.5;

        long longTime = (long) time;
        Date arrivalDay = new Date((startDay.getTime()+longTime));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH"+"时");
        return dateFormat.format(arrivalDay);
    }
}
