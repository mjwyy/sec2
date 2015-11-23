package businesslogic.info;

import businesslogicservice.infoblservice.SystemUserManagementBLService;
import util.ResultMsg;
<<<<<<< HEAD
import vo.UserVO;

=======
import util.LogInMsg;
import vo.UserVO;

import java.rmi.RemoteException;
import java.sql.SQLException;
>>>>>>> master
import java.util.ArrayList;

import po.UserPO;
import connection.RemoteObjectGetter;
<<<<<<< HEAD
import dataservice.financedataservice.PaymentInputDataService;
=======
import dataservice.exception.ElementNotFoundException;
>>>>>>> master
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
<<<<<<< HEAD
        return null;
    }

    @Override
    public ResultMsg modify(UserVO vo) {
        return null;
=======
    	ResultMsg msg = vo.checkFormat();
    	
    	if(!msg.isPass()) return msg;
    	
    	try {
			boolean result = dataService.removeUser((UserPO) vo.toPO());
			if(!result) {
				return new ResultMsg(false,"人员删除失败");
			}
		} catch (Exception e) {
			return new ResultMsg(false,e.getMessage());
		}
        
        return new ResultMsg(true,"人员删除成功");
    	
    	
    }

    @Override
    public ResultMsg modify(UserVO original,UserVO modified) {
    	ResultMsg msg = original.checkFormat();
    	
    	if(!msg.isPass()) return msg;
    	
    	msg = modified.checkFormat();
    	
    	if(!msg.isPass()) return msg;

    	try {
			boolean result = dataService.modifyUser((UserPO) original.toPO(), (UserPO) modified.toPO());
			if(!result) {
				return new ResultMsg(false,"人员修改失败");
			}
		} catch (Exception e) {
			return new ResultMsg(false,e.getMessage());
		}
        
        return new ResultMsg(true,"人员修改成功");
    	
>>>>>>> master
    }

    @Override
    public ArrayList<UserVO> find(UserVO vo) {
<<<<<<< HEAD
        return null;
    }

    @Override
    public ResultMsg logIn(String userNum, String initialPassword) {
        return null;
=======
    	// 此项查找无需格式检查，因为VO内保存的是关键字而非真实数据
    	
    	ArrayList<UserVO> result = new ArrayList<>();
    	ArrayList<UserPO> get = null;
    	try {
			get = dataService.inquireUser((UserPO) vo.toPO());
		} catch (Exception e) {
			System.err.println("查询用户时出现异常：");
			System.err.println(e.getMessage());
		}
    	
    	for(UserPO po: get) {
    		result.add((UserVO)po.toVO());
    	}
    	
    	return result;
    	
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
>>>>>>> master
    }
}
