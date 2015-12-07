package util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by kylin on 15/12/7.
 */
public class TimeHelper {

    /**
     * 获取今天的日期,返回格式为2015-12-07的字符串
     *
     * @return 系统当前日期
     */
    public static String getDate(){
        SimpleDateFormat dateForamte = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String today = dateForamte.format(date);
        return today;
    }

    /**
     * 获取今天的日期与实践,返回格式为2015-12-07 13:31
     *
     * @return 系统当前日期与时间
     */
    public static String getDateAndTime(){
        SimpleDateFormat dateForamte = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = new Date();
        String today = dateForamte.format(date);
        return today;
    }

}
