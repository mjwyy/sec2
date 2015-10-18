/**
 * 管理机构人员信息
 * @author wwz
 * @date 2015/10/17
 */
package businesslogicservice.infoblservice;

import java.util.ArrayList;

import state.ResultMsg;
import vo.OrganizationInfoVO;
import vo.StaffInfoVO;

public interface ManageStaffOrganizationInfo22BLService {
	
	/**
	 * 新增人员信息
	 * @param vo
	 * @return
	 */
	public ResultMsg add(StaffInfoVO vo);
	
	/**
	 * 删除人员信息
	 * @param vo
	 * @return
	 */
	public ResultMsg del(StaffInfoVO vo);
	
	/**
	 * 修改人员信息
	 * @param vo
	 * @return
	 */
	public ResultMsg Modify(StaffInfoVO vo);
	
	/**
	 * 查找人员信息
	 * @param keyword
	 * @return
	 */
	public ArrayList<StaffInfoVO> findStaffInfo(String keyword);
	
	/**
	 * 新增机构信息
	 * @param vo
	 * @return
	 */
	public ResultMsg add(OrganizationInfoVO vo);
	
	/**
	 * 删除机构信息
	 * @param vo
	 * @return
	 */
	public ResultMsg del(OrganizationInfoVO vo);
	
	/**
	 * 修改机构信息
	 * @param vo
	 * @return
	 */
	public ResultMsg Modify(OrganizationInfoVO vo);
	
	/**
	 * 查找机构信息
	 * @param keyword
	 * @return
	 */
	public ArrayList<OrganizationInfoVO> findOrgInfo(String keyword);
	
	/**
	 * 显示所有机构人员信息
	 * @return
	 */
	public ArrayList<OrganizationInfoVO> showAll();

}
