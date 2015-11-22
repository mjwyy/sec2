package businesslogic.info;

import businesslogicservice.infoblservice.StaffOrganizationManagementBLService;
import util.ResultMsg;
import vo.OrganizationInfoVO;
import vo.StaffVO;

import java.util.ArrayList;

import po.StaffPO;
import connection.RemoteObjectGetter;
import dataservice.commoditydataservice.StorageInDataService;
import dataservice.infodataservice.StaffOrganizationManagementDataService;

/**
 * Created by kylin on 15/11/17.
 */
public class StaffOrganizationManagement implements StaffOrganizationManagementBLService {
	
	StaffOrganizationManagementDataService dataService = null;
	
	public StaffOrganizationManagement() {
		RemoteObjectGetter getter = new RemoteObjectGetter();
		dataService = (StaffOrganizationManagementDataService) getter.getObjectByName("StaffOrganizationManagementDataService");
	}
	
    @Override
    public ResultMsg addStaff(StaffVO vo) {
        ResultMsg msg = vo.checkFormat();
        
        if(!msg.isPass()) return msg;
        
        try {
        	boolean b = dataService.addStaff((StaffPO) vo.toPO());
        	if(!b) return new ResultMsg(false,"添加失败，请重试");
        } catch (Exception e) {
        	return new ResultMsg(false, e.getMessage());
        }
        
        return new ResultMsg(true);
    }

    @Override
    public ResultMsg delStaff(StaffVO vo) {
    	ResultMsg msg = vo.checkFormat();
        
        if(!msg.isPass()) return msg;
        
        try {
        	boolean b = dataService.removeStaff((StaffPO) vo.toPO());
        	if(!b) return new ResultMsg(false,"删除失败，请重试");
        } catch (Exception e) {
        	return new ResultMsg(false, e.getMessage());
        }
        
        return new ResultMsg(true);
    }

    @Override
    public ResultMsg ModifyStaff(StaffVO original,StaffVO modified) {
    	ResultMsg msg = original.checkFormat();
        if(!msg.isPass()) return msg;
        msg = modified.checkFormat();
        if(!msg.isPass()) return msg;
        
        
        try {
        	boolean b = dataService.modifyStaff((StaffPO) original.toPO(),(StaffPO) modified.toPO());
        	if(!b) return new ResultMsg(false,"修改失败，请重试");
        } catch (Exception e) {
        	return new ResultMsg(false, e.getMessage());
        }
        
        return new ResultMsg(true);
    }

    @Override
    public ArrayList<StaffVO> findStaffInfo(StaffVO vo) {
    	ArrayList<StaffVO> result = new ArrayList<>();
    	
    	ArrayList<StaffPO> get = null;
    	
    	try {
    		get = dataService.findStaff((StaffPO) vo.toPO());
    	} catch (Exception e) {
    		System.err.println("获取所有员工信息时出现异常：");
    		System.err.println(e.getMessage());
    		return result;
    	}
    	
    	for(StaffPO po:get) {
    		result.add((StaffVO) po.toVO());//Now returns null and throws exception
    	}
    	
        return result;
    }

    @Override
    public ResultMsg addOrganization(OrganizationInfoVO vo) {
        return null;
    }

    @Override
    public ResultMsg delOrganization(OrganizationInfoVO vo) {
        return null;
    }

    @Override
    public ResultMsg ModifyOrganization(OrganizationInfoVO vo) {
        return null;
    }

    @Override
    public ArrayList<OrganizationInfoVO> findOrgInfo(OrganizationInfoVO vo) {
        return null;
    }

    @Override
    public ArrayList<OrganizationInfoVO> showAll() {
        return null;
    }
}
