/**
 * 
 * @author wwz
 * @date 2015/10/17
 */
package businesslogicservice.infoblservice;

import java.util.ArrayList;

import vo.DriverInfoVO;
import vo.VehicleInfoVO;
import businesslogic.util.ResultMsg;
public interface DriverVehicleManagementBLService {
	
	/**
	 * 新增车辆信息
	 * 前置条件：经验证的业务员选择新增车辆信息功能
	 * 后置条件：系统进行格式检查，返回格式检查结果，系统日志记录
	 * @param vo
	 * @return
	 */
	public ResultMsg add(VehicleInfoVO vo);
	
	/**
	 * 删除车辆信息
	 * 前置条件：经验证的业务员选择删除车辆信息功能
	 * 后置条件：系统返回删除结果，系统日志记录
	 * @param vo
	 * @return
	 */
	public ResultMsg delete(VehicleInfoVO vo);
	
	/**
	 * 修改车辆信息
	 * 前置条件：经验证的业务员选择修改车辆信息功能
	 * 后置条件：系统返回修改结果，系统日志记录	
	 * @param vo
	 * @return
	 */
	public ResultMsg modify(VehicleInfoVO vo);
	
	/**
	 * 新增司机信息
	 * 前置条件：经验证的业务员选择新增司机信息功能
	 * 后置条件：系统进行格式检查，返回格式检查结果，系统日志记录
	 * @param vo
	 * @return
	 */
	public ResultMsg add(DriverInfoVO vo);
	
	/**
	 * 删除司机信息
	 * 前置条件：经验证的业务员选择删除司机信息功能
	 * 后置条件：系统返回删除结果，系统日志记录
	 * @param vo
	 * @return
	 */
	public ResultMsg delete(DriverInfoVO vo);
	
	/**
	 * 修改司机信息
	 * 前置条件：经验证的业务员选择修改司机信息功能
	 * 后置条件：系统返回删除结果，系统日志记录
	 * @param vo
	 * @return
	 */
	public ResultMsg modify(DriverInfoVO vo);
	
	/**
	 * 查询
	 * 前置条件：经验证的业务员选择查询车辆信息
	 * 后置条件：系统检查关键字格式，若无误显示查询到的信息
	 * @param keyword
	 * @return
	 */
	public ArrayList<VehicleInfoVO> findVehicle(String keyword);
	
	/**
	 * 查询
	 * 前置条件：经验证的业务员选择查询司机信息
	 * 后置条件：系统检查关键字格式，若无误显示查询到的信息
	 * @param keyword
	 * @return
	 */
	public ArrayList<DriverInfoVO> findDriver(String keyword);
	
	

}
