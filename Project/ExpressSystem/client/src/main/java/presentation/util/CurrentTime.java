
/**
 * 获取当前时间
 * 
 * @author wqy
 *
 */
package presentation.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentTime {
	
	//精确到秒
	public static String getCurrentTimeSecond(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(new Date());
	}
	//精确到分
	public static String getCurrentTimeMinute(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return df.format(new Date());
	}
	//精确到时
    public static String getCurrentTimeHour(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH");
        return df.format(new Date());
    }
    //精确到日
    public static String getCurrentTimeDate(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(new Date());
    }
    public static String getCurrentTimeDateSimple(){
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        return df.format(new Date());
    }
    public static String second(){
        SimpleDateFormat df = new SimpleDateFormat("HH:mm");
        return df.format(new Date());
    }
}
