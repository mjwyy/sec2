package businesslogic.info;

import businesslogicservice.infoblservice.StaffOrganizationManagementBLService;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import util.ResultMsg;
import vo.OrganizationInfoVO;
import vo.StaffVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.OrganizationPO;
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
        } catch (RemoteException e) {
            e.printStackTrace();
            return new ResultMsg(false,"网络异常,请重试!");
        } catch (InterruptWithExistedElementException e) {
            e.printStackTrace();
            return new ResultMsg(false,"人员信息已存在!");
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
        } catch (RemoteException e) {
            e.printStackTrace();
            return new ResultMsg(false,"网络异常,请重试!");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
            return new ResultMsg(false,"删除的信息不存在!");
        }
        return new ResultMsg(true);
    }

    @Override
    public ResultMsg ModifyStaff(StaffVO staff) {
    	ResultMsg msg = staff.checkFormat();
        if(!msg.isPass()) return msg;

        try {
        	boolean b = dataService.modifyStaff((StaffPO) staff.toPO());
        	if(!b) return new ResultMsg(false,"修改失败，请重试");
        } catch (RemoteException e) {
            e.printStackTrace();
            return new ResultMsg(false,"网络异常,请重试!");
        }
        return new ResultMsg(true);
    }

    @Override
    public ArrayList<StaffVO> findStaffInfo(StaffVO vo) {
    	ArrayList<StaffVO> result = new ArrayList<>();
    	ArrayList<StaffPO> get = null;
    	try {
            if(vo == null)
                get = dataService.getAllStaff();
            else
    		    get = dataService.findStaff((StaffPO) vo.toPO());
            for(StaffPO po:get) {
                result.add((StaffVO) po.toVO());
            }
            return result;
    	} catch (RemoteException e) {
            e.printStackTrace();
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ResultMsg addOrganization(OrganizationInfoVO vo) {
    	
    	ResultMsg msg = vo.checkFormat();
    	if(!msg.isPass()) return msg;
    	
    	try {
    		boolean b = dataService.addOrganization((OrganizationPO) vo.toPO());
    		if(!b) return new ResultMsg(false,"添加机构失败，请重试");
    	} catch (RemoteException e) {
            e.printStackTrace();
            return new ResultMsg(false,"网络异常,请重试!");
        } catch (InterruptWithExistedElementException e) {
            e.printStackTrace();
            return new ResultMsg(false,"机构信息已存在!");
        }
        return new ResultMsg(true);
    }

    @Override
    public ResultMsg delOrganization(OrganizationInfoVO vo) {
    	
    	ResultMsg msg = vo.checkFormat();
    	if(!msg.isPass()) return msg;
    	
    	try {
    		boolean b = dataService.removeOrganization((OrganizationPO) vo.toPO());
    		if(!b) return new ResultMsg(false,"删除机构失败，请重试");
    	} catch (RemoteException e) {
            e.printStackTrace();
            return new ResultMsg(false,"网络异常,请重试!");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
            return new ResultMsg(false,"机构信息不存在!");
        }
        return new ResultMsg(true);
        
    }

    @Override
    public ResultMsg ModifyOrganization(OrganizationInfoVO vo) {
    	
    	ResultMsg msg = vo.checkFormat();
    	if(!msg.isPass()) return msg;
    	
    	try {
    		boolean b = dataService.modifyOrganization((OrganizationPO) vo.toPO());
    		if(!b) return new ResultMsg(false,"删除机构失败，请重试");
    	} catch (RemoteException e) {
            e.printStackTrace();
            return new ResultMsg(false,"网络异常,请重试!");
        }
        return new ResultMsg(true);
        
    }

    @Override
    public ArrayList<OrganizationInfoVO> findOrgInfo(OrganizationInfoVO vo) {
    	
    	ArrayList<OrganizationInfoVO> result = new ArrayList<>();
    	ArrayList<OrganizationPO> get = null;
    	
    	try {
    		if(vo==null) {
    			get = dataService.getAllOrganizations();
    		} else {
    			get = dataService.findOrganization((OrganizationPO) vo.toPO());
    		}

            for(OrganizationPO po:get){
                result.add((OrganizationInfoVO) po.toVO());
            }
            return result;
    	} catch (RemoteException e) {
            e.printStackTrace();
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<OrganizationInfoVO> showAll() {
    	return findOrgInfo(null);
    }
}
