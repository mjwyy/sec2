package vo;

import util.FormatCheck;
import util.ResultMsg;

/**
 * 系统日志VO
 * 
 * @author kylin
 *
 */
public class SystemLogVO {
    
	/**
	 * 创建时间
	 */
	String time;
	
	/**
	 * 日志内容
	 */
	String content;

	public SystemLogVO(String time, String content) {
		super();
		this.time = time;
		this.content = content;
	}

	public String getTime() {
		return time;
	}

	public String getContent() {
		return content;
	}

    public ResultMsg checkFormat() {
        ResultMsg result = new ResultMsg(true);
        ResultMsg results[] = new ResultMsg[2];
        results[0] = FormatCheck.isLogKeyWord(this.content);
        results[1] = FormatCheck.isLogInquiryTime(this.time);
        for(int i = 0; i<results.length; i++){
            if(!results[i].isPass()){
                return results[i];
            }
        }
        return result;
    }

    //TODO 界面问题:下面的测试可以通过,而界面无法只查询一个关键字
//    public static void main(String[] args) {
//        SystemLogVO testVO = new SystemLogVO("2015-01-07","营业厅 派件单");
//        System.out.println(testVO.checkFormat().isPass());
//
//        testVO = new SystemLogVO(null,"营业厅 派件单");
//        System.out.println(testVO.checkFormat().isPass());
//
//        testVO = new SystemLogVO("2015-01-07",null);
//        System.out.println(testVO.checkFormat().isPass());
//    }

}
