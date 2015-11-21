package vo;

import businesslogic.util.FormatCheck;
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
        boolean pass = true;
        ResultMsg result = new ResultMsg(true);
        ResultMsg results[] = new ResultMsg[2];
        results[0] = FormatCheck.isLogKeyWord(this.content);
        results[1] = FormatCheck.IsLogInquiryTime(this.time);
        for(int i = 0; i<results.length; i++){
            if(!results[i].isPass()){
                result.appendMessage(results[i].getMessage()+'\n');
                pass = false;
            }
        }
        if (pass)
            result.appendMessage("系统日志查询信息格式正确");
        return result;
    }

}
