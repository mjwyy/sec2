package businesslogic.util;

import util.ResultMsg;

import java.util.regex.Pattern;

/**
 * Created by kylin on 15/11/17.
 */
public class FormatCheck {

    /**
     * 1检查输入是否是合法的订单条形码(10位0～9的数字)
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
     * 2检查输入是否是合法的日期,日期格式为“xxxx－xx－xx”,x是数字
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
     * 3检查输入是否是合法的库存查看时间点
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
     * 4检查输入是否是合法的人员姓名,至少是两个合法汉字
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
     * 5检查输入是否是合法的手机号码,11位数字(最前端可以加国家区号)
     *
     * @param str
     * @return
     */
    public static boolean IsPhoneNumber(String str) {
        String trueExpression = "(\\+\\d+)?1\\d{10}";
        return Pattern.matches(trueExpression,str);
    }

    /**
     * 6检查输入是否是合法的固定电话号码
     * 电话格式为“xxxx－xxxxxxxx”，即四位区号＋8位座机号，如“0250-66778899”。
     *
     * @param str
     * @return
     */
    public static boolean IsFixedPhoneNumber(String str) {
        String trueExpression = "\\d{4}-\\d{8}";
        return Pattern.matches(trueExpression,str);
    }

    /**
     * 8检查输入是否是合法的营业厅编号
     * 营业厅编号格式为“025城市编码+1营业厅+000鼓楼营业厅”
     *
     * @param str
     * @return
     */
    public static boolean IsServiceHallNumber(String str) {
        String trueExpression = "\\d{7}";
        return Pattern.matches(trueExpression,str);
    }

    /**
     * 9检查输入是否是合法的车辆代号
     * 车辆代号格式为“城市编号（电话号码区号南京025）＋营业厅编号（000三位）＋000三位数字”
     *
     * @param str
     * @return
     */
    public static boolean IsCarNumber(String str) {
        String trueExpression = "\\d{9}";
        return Pattern.matches(trueExpression,str);
    }

    /**
     * 10检查输入是否是合法的司机编号
     * 司机编号格式为“城市编号（电话号码区号南京025）＋营业厅编号（000 三位数字）＋000三位数字”
     *
     * @param str
     * @return
     */
    public static boolean IsDriverNumber(String str) {
        String trueExpression = "\\d{9}";
        return Pattern.matches(trueExpression,str);
    }

    /**
     * 11检查输入是否是合法的身份证号
     * 身份证号为18位0～9的数字，允许最后一位是‘x’
     *
     * @param str
     * @return
     */
    public static boolean IsIDNumber(String str) {
        String trueExpression = "\\d{17}(\\d|x|X)";
        return Pattern.matches(trueExpression,str);
    }

    /**
     * 12检查输入是否是合法的中转中心编号
     * 中转中心编号格式为“025城市编码+0营业厅+00鼓楼中转中心”
     *
     * @param str
     * @return
     */
    public static boolean IsCenterNumber(String str) {
        String trueExpression = "\\d{6}";
        return Pattern.matches(trueExpression,str);
    }

    /**
     * 13检查输入是否是合法的中转中心汽运编号
     * 中转中心汽运编号“中转中心编号(6位)＋日期＋7位0～9的数字”，日期为形如“20151012”
     *
     * @param str
     * @return
     */
    public static boolean IsCenterLoadNumber(String str) {
        String trueExpression = "\\d{21}";
        return Pattern.matches(trueExpression,str);
    }

    /**
     * 14检查输入是否是合法的中转单编号
     * 中转单编号格式为“中转中心编号(6位)＋日期＋7位0～9的数字”
     *
     * @param str
     * @return
     */
    public static boolean IsTransitNoteNumber(String str) {
        String trueExpression = "\\d{21}";
        return Pattern.matches(trueExpression,str);
    }

    /**
     * 15检查输入是否是合法的基础账目数据
     * 基础账目数据必须位大于0的数字
     *
     * @param str
     * @return
     */
    public static boolean IsBaseData(String str) {
        int trueExpression = Integer.parseInt(str);
        return trueExpression > 0;
    }

    /**
     * 17检查输入是否是合法的款项金额
     * 所有款项金额必须为正的数字
     *
     * @param str
     * @return
     */
    public static boolean IsMoney(String str) {
        int trueExpression = Integer.parseInt(str);
        return trueExpression > 0;
    }

    /**
     * 18检查输入是否是合法的系统日志查询关键字位日期
     * 系统日志查询关键字位日期，格式位“xxxx-xx-xx”，如“2015-01-07”X代指0～9的数字
     *
     * @param str
     * @return
     */
    public static boolean IsLogInquiryTime(String str) {
        String trueExpression = "\\d{4}-\\d{1,2}-\\d{1,2}";
        return Pattern.matches(trueExpression,str);
    }

}
