package businesslogic.info;

import businesslogicservice.infoblservice.StaffOrganizationManagementBLService;
import util.ResultMsg;
import vo.OrganizationInfoVO;
import vo.StaffVO;

import java.util.ArrayList;

/**
 * Created by kylin on 15/11/17.
 */
public class StaffOrganizationManagement implements StaffOrganizationManagementBLService {
    @Override
    public ResultMsg addStaff(StaffVO vo) {
        return null;
    }

    @Override
    public ResultMsg delStaff(StaffVO vo) {
        return null;
    }

    @Override
    public ResultMsg ModifyStaff(StaffVO vo) {
        return null;
    }

    @Override
    public ArrayList<StaffVO> findStaffInfo(StaffVO vo) {
        return null;
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
