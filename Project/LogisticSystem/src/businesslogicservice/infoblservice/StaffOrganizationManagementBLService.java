/**
 * 管理机构人员信息
 * @author wwz
 * @date 2015/10/17
 */
package businesslogicservice.infoblservice;

import java.util.ArrayList;

import businesslogic.util.ResultMsg;
import vo.OrganizationInfoVO;
import vo.StaffInfoVO;

public interface StaffOrganizationManagementBLService {
	
	/**
	 * 新增人员信息
	 * 前置条件：经验证的业务员选择新增人员信息
	 * 后置条件；系统更新人员信息，系统日志记录
	 * @param vo
	 * @return
	 */
	public ResultMsg add(StaffInfoVO vo);
	
	/**
	 * 删除人员信息
	 * 前置条件：经验证的业务员选择删除人员信息
	 * 后置条件；系统更新人员信息，系统日志记录	
	 * @param vo
	 * @return
	 */
	public ResultMsg del(StaffInfoVO vo);
	
	/**
	 * 修改人员信息
	 * 前置条件：经验证的业务员选择修改人员信息
	 * 后置条件；系统更新人员信息，系统日志记录
	 * @param vo
	 * @return
	 */
	public ResultMsg Modify(StaffInfoVO vo);
	
	/**
	 * 查找人员信息
	 * 前置条件：经验证的业务员选择查找人员信息
	 * 后置条件；系统显示查找到的信息，系统日志记录
	 * @param keyword
	 * @return
	 */
	public ArrayList<StaffInfoVO> findStaffInfo(String keyword);
	
	/**
	 * 新增机构信息
	 * 前置条件：经验证的业务员选择新增机构信息
	 * 后置条件；系统更新机构信息，系统日志记录
	 * @param vo
	 * @return
	 */
	public ResultMsg add(OrganizationInfoVO vo);
	
	/**
	 * 删除机构信息
	 * 前置条件：经验证的业务员选择删除机构信息
	 * 后置条件；系统更新机构信息，系统日志记录
	 * @param vo
	 * @return
	 */
	public ResultMsg del(OrganizationInfoVO vo);
	
	/**
	 * 修改机构信息
	 * 前置条件：经验证的业务员选择修改机构信息
	 * 后置条件；系统更新机构信息，系统日志记录
	 * @param vo
	 * @return
	 */
	public ResultMsg Modify(OrganizationInfoVO vo);
	
	/**
	 * 查找机构信息
	 * 前置条件：经验证的业务员选择查找机构信息
	 * 后置条件；系统显示查找到的信息，系统日志记录
	 * @param keyword
	 * @return
	 */
	public ArrayList<OrganizationInfoVO> findOrgInfo(String keyword);
	
	/**
	 * 显示所有机构人员信息
	 * 前置条件：经验证的业务员要求查看机构所有信息
	 * 后置条件：系统显示机构所有信息，系统日志记录
	 * @return
	 */
	public ArrayList<OrganizationInfoVO> showAll();

}
