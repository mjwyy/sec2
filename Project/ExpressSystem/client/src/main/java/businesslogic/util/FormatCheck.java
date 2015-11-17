package businesslogic.util;

import util.ResultMsg;

import java.util.regex.Pattern;

/**
 * Created by kylin on 15/11/17.
 */
public class FormatCheck {

    /**
     * 检查输入是否是合法的订单条形码(10位0～9的数字)
     *
     * @param str
     * @return
     */
    public static ResultMsg IsBarcode(String str) {
        String trueExpression = "\\d{10}$";
        return Pattern.matches(trueExpression,str)? new ResultMsg(true) :
                new ResultMsg(false,"条形码格式错误,应为10位0～9的数字");
    }

    /**
     * 检查输入是否是合法的日期,日期格式为“xxxx－xx－xx”,x是数字
     *
     * @param str
     * @return
     */
    public static ResultMsg IsDate(String str) {
        String trueExpression = "\\d{4}-\\d{1,2}-\\d{1,2}";
        return Pattern.matches(trueExpression,str)? new ResultMsg(true) :
                new ResultMsg(false,"日期格式错误,应为“xxxx－xx－xx");
    }

    /**
     * 检查输入是否是合法的库存查看时间点
     * 库存查看时间点格式为“xxxx－xx－xx xx：xx”，如“2015-09-26 10:30”
     *
     * @param str
     * @return
     */
    public static boolean IsInventoryTime(String str) {
        String trueExpression = "\\d{4}-\\d{1,2}-\\d{1,2}\\s\\d{2}:\\d{2}";
        return Pattern.matches(trueExpression,str);
    }

    /**
     * 检查输入是否是合法的人员姓名,至少是两个合法汉字
     *
     * @param str
     * @return
     */
    public static ResultMsg IsChineseName(String str) {
        String trueExpression = "^[\\u4e00-\\u9fa5]+$";
        return Pattern.matches(trueExpression,str)? new ResultMsg(true) :
                new ResultMsg(false,"姓名格式错误,应为合法汉字");
    }

    /**
     * 检查输入是否是合法的手机号码,11位数字(最前端可以加国家区号)
     *
     * @param str
     * @return
     */
    public static boolean IsPhoneNumber(String str) {
        String trueExpression = "(\\+\\d+)?1\\d{10}";
        return Pattern.matches(trueExpression,str);
    }

}
