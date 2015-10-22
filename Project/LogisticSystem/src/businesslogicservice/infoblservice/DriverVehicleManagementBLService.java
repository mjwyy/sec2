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
	 * 关键字查询车辆信息
	 * @param keyword
	 * @return
	 */
	public ArrayList<VehicleInfoVO> findVehicle(String keyword);
	
	/**
	 * 关键字查询司机信息
	 * @param keyword
	 * @return
	 */
	public ArrayList<DriverInfoVO> findDriver(String keyword);
	
}
