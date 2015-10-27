/**
 * 管理机构人员信息
 * @author wwz
 * @date 2015/10/17
 */
package businesslogicservice.infoblservice;

import java.util.ArrayList;

import businesslogic.util.ResultMsg;
import vo.OrganizationVO;
import vo.StaffVO;

public interface StaffOrganizationManagementBLService {
	
	/**
	 * 新增人员信息
	 * @param vo
	 * @return
	 */
	public ResultMsg addStaff(StaffVO vo);
	
	/**
	 * 删除人员信息
	 * @param vo
	 * @return
	 */
	public ResultMsg delStaff(StaffVO vo);
	
	/**
	 * 修改人员信息
	 * @param vo
	 * @return
	 */
	public ResultMsg ModifyStaff(StaffVO vo);
	
	/**
	 * 关键字查找人员信息
	 * @param keyword
	 * @return
	 */
	public ArrayList<StaffVO> findStaffInfo(StaffVO vo);
	
	/**
	 * 新增机构信息
	 * @param vo
	 * @return
	 */
	public ResultMsg addOrganization(OrganizationVO vo);
	
	/**
	 * 删除机构信息
	 * @param vo
	 * @return
	 */
	public ResultMsg delOrganization(OrganizationVO vo);
	
	/**
	 * 修改机构信息
	 * @param vo
	 * @return
	 */
	public ResultMsg ModifyOrganization(OrganizationVO vo);
	
	/**
	 * 关键字查找机构信息
	 * @param keyword
	 * @return
	 */
	public ArrayList<OrganizationVO> findOrgInfo(OrganizationVO vo);
	
	/**
	 * 显示所有机构人员信息
	 * @return
	 */
	public ArrayList<OrganizationVO> showAll();

}
