package businesslogicservice.statisticblservice;

import java.util.ArrayList;

import util.ApproveNote;
import util.ResultMsg;
import vo.*;

/**
 * 总经理审批单据的逻辑接口
 * 
 * @author kylin
 *
 */
public interface NoteApprovingBLService {
    /**
     * 为界面层提供的获取所有待审批单据的接口
     * @return 待审批的所有单据信息
     * @throws Exception 将会在这里封装错误信息，注意处理
     */
    public ArrayList<ApproveNote> getNotes() throws Exception;
    
    /**
     * 搭配getNotes使用的接受审批结果的接口，将会把审批结果上传
     * @param results 应为之前getNotes获得的单据信息，各个单据应为“通过”或“不通过并填写了审批意见”
     * @return 审批操作反馈，若为false则应使用其中的message提醒总经理
     * @throws Exception 将会在这里封装错误信息，注意处理
     */
    public ResultMsg pushResults(ArrayList<ApproveNote> results) throws Exception;

}
