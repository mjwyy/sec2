package businesslogic.info;

import businesslogicservice.infoblservice.SystemUserManagementBLService;
import util.ResultMsg;
import util.LogInMsg;
import vo.UserVO;

import java.util.ArrayList;

import po.UserPO;
import connection.RemoteObjectGetter;
import dataservice.infodataservice.SystemUserManagementDataService;

/**
 * Created by kylin on 15/11/17.
 */
public class SystemUserManagement implements SystemUserManagementBLService {
	
	SystemUserManagementDataService dataService = null;
	
	public SystemUserManagement() {
		RemoteObjectGetter getter = new RemoteObjectGetter();
		dataService = (SystemUserManagementDataService)getter.getObjectByName("SystemUserManagementDataService");
	}
	
    @Override
    public ResultMsg add(UserVO vo) {
    	
    	ResultMsg msg = vo.checkFormat();
    	
    	if(!msg.isPass()) return msg;
    	
        try {
			boolean result = dataService.addUser((UserPO) vo.toPO());
			if(!result) {
				return new ResultMsg(false,"人员添加失败");
			}
		} catch (Exception e) {
			return new ResultMsg(false,e.getMessage());
		}
        
        return new ResultMsg(true,"人员添加成功");
        
    }

    @Override
    public ResultMsg delete(UserVO vo) {
        return null;
    }

    @Override
    public ResultMsg modify(UserVO vo) {
        return null;
    }

    @Override
    public ArrayList<UserVO> find(UserVO vo) {
        return null;
    }

    @Override
    public LogInMsg logIn(String userNum, String initialPassword) {
        UserVO vo = new UserVO(userNum,initialPassword,null);
        ArrayList<UserVO> found = this.find(vo);
        if(found.size()==0)
            return new LogInMsg(false,null);
        UserVO foundVO = found.get(0);
        if(foundVO.getInitialPassword().equals(initialPassword))
            return new LogInMsg(true,foundVO.getAuthority());
        else
            return new LogInMsg(false,null);
    }
}
