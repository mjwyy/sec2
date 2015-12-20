package businesslogic.info;

import businesslogicservice.infoblservice.SystemUserManagementBLService;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import util.ResultMsg;
import util.LogInMsg;
import util.RuntimeUserInfo;
import vo.UserVO;

import java.rmi.RemoteException;
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
            if(result)
                return new ResultMsg(true,"人员添加成功");
		} catch (RemoteException e) {
            e.printStackTrace();
            return new ResultMsg(false,"网络异常:人员添加失败!");
        } catch (InterruptWithExistedElementException e) {
            e.printStackTrace();
            return new ResultMsg(false,e.getMessage());
        }
        return new ResultMsg(true,"人员添加失败!");
    }

    @Override
    public ResultMsg delete(UserVO vo) {

    	try {
			boolean result = dataService.removeUser((UserPO) vo.toPO());
			if(result)
				return new ResultMsg(true,"人员删除成功");
		} catch (RemoteException e) {
            e.printStackTrace();
            return new ResultMsg(false,"网络异常:人员添加失败!");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
            return new ResultMsg(false,"人员信息不存在,删除失败!");
        }

        return new ResultMsg(false,"人员删除失败");
    	
    	
    }

    @Override
    public ResultMsg modify(UserVO original,UserVO modified) {

    	try {
			boolean result = dataService.modifyUser((UserPO) original.toPO(), (UserPO) modified.toPO());
			if(!result) {
				return new ResultMsg(false,"人员修改失败");
			}
		} catch (Exception e) {
			return new ResultMsg(false,e.getMessage());
		}

        return new ResultMsg(true,"人员修改成功");
    	
    }

    @Override
    public ArrayList<UserVO> find(UserVO vo) {
    	
    	ArrayList<UserVO> result = new ArrayList<>();
    	ArrayList<UserPO> get = null;
    	try {
            if(vo == null){
                get = dataService.getAllUsers();
            }else
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
    public LogInMsg logIn(String userNum, String initialPassword)  {
    	try {
			LogInMsg msg = dataService.logIn(userNum, initialPassword);
			if(msg.isPass()) {
				RuntimeUserInfo.setUserNum(userNum);
			}
            return msg;
		} catch (RemoteException e) {
            e.printStackTrace();
            return new LogInMsg(false, null, "网络连接异常，目前无法登陆。");
        }
    	
    }
}
