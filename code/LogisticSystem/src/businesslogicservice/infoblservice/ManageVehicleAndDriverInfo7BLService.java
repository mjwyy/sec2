/**
 * 
 * @author wwz
 * @date 2015/10/17
 */
package businesslogicservice.infoblservice;

import java.util.ArrayList;

import vo.DriverInfoVO;
import vo.VehicleInfoVO;
import state.ResultMsg;
public interface ManageVehicleAndDriverInfo7BLService {
	
	/**
	 * 新增车辆信息
	 * 前置条件：业务员选择新增车辆信息功能
	 * 后置条件：系统进行格式检查，返回格式检查结果
	 * @param vo
	 * @return
	 */
	public ResultMsg add(VehicleInfoVO vo);
	
	/**
	 * 删除车辆信息
	 * @param vo
	 * @return
	 */
	public ResultMsg delete(VehicleInfoVO vo);
	
	/**
	 * 修改车辆信息
	 * @param vo
	 * @return
	 */
	public ResultMsg modify(VehicleInfoVO vo);
	
	/**
	 * 新增司机信息
	 * @param vo
	 * @return
	 */
	public ResultMsg add(DriverInfoVO vo);
	
	/**
	 * 删除司机信息
	 * @param vo
	 * @return
	 */
	public ResultMsg delete(DriverInfoVO vo);
	
	/**
	 * 修改司机信息
	 * @param vo
	 * @return
	 */
	public ResultMsg modify(DriverInfoVO vo);
	
	/**
	 * 查询
	 * @param keyword
	 * @return
	 */
	public ArrayList<VehicleInfoVO> findVehicle(String keyword);
	
	/**
	 * 查询
	 * @param keyword
	 * @return
	 */
	public ArrayList<DriverInfoVO> findDriver(String keyword);
	
	

}
