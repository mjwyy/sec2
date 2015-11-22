package vo;

import util.FormatCheck;

import po.ChartPO;
import util.ResultMsg;
import util.enums.ChartType;

/**
 * 表格VO
 * 
 * @author kylin
 *
 */
public class ChartVO {


    //TODO 选取的类型是否需要检查格式
	/**
	 * 报表类型
	 */
	ChartType type;
	
	/**
	 * 报表起止时间
	 */
	String time1;
	String time2;

    public ChartVO(ChartType type, String time1, String time2) {
        this.type = type;
        this.time1 = time1;
        this.time2 = time2;
    }

    public ChartType getType() {
        return type;
    }

    public String getTime1() {
        return time1;
    }

    public String getTime2() {
        return time2;
    }

    public ResultMsg checkFormat(){
        ResultMsg result = new ResultMsg(true);
        ResultMsg results[] = new ResultMsg[2];
        results[0] = FormatCheck.isDate(this.time1);
        results[1] = FormatCheck.isDate(this.time2);
        for(int i = 0; i<results.length; i++){
            if(!results[i].isPass())
                return results[i];
        }
        return result;
    }

}
