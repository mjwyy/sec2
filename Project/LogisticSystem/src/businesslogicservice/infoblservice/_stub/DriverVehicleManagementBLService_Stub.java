/**
 * 
 * @author wwz
 * @date 2015/10/17
 */
package businesslogicservice.infoblservice._stub;

import java.util.ArrayList;

import vo.DriverInfoVO;
import vo.VehicleInfoVO;
import businesslogic.util.ResultMsg;
import businesslogicservice.infoblservice.DriverVehicleManagementBLService;

public class DriverVehicleManagementBLService_Stub implements DriverVehicleManagementBLService {
	

	public ResultMsg addVehicle(VehicleInfoVO vo){
		System.out.println("added vehicle!");
		return new ResultMsg(true, "Success!");
	};
	

	public ResultMsg deleteVehicle(VehicleInfoVO vo){
		System.out.println("deleted vehicle!");
		return new ResultMsg(true, "Success!");
	};
	

	public ResultMsg modifyVehicle(VehicleInfoVO vo){
		System.out.println("modified vehicle!");
		return new ResultMsg(true, "Success!");
	};
	

	public ResultMsg addDriver(DriverInfoVO vo){
		System.out.println("added driver!");
		return new ResultMsg(true, "Success!");
	};
	

	public ResultMsg deleteDriver(DriverInfoVO vo){
		System.out.println("deleted driver!");
		return new ResultMsg(true, "Success!");
	};
	

	public ResultMsg modifyDriver(DriverInfoVO vo){
		System.out.println("modified driver!");
		return new ResultMsg(true, "Success!");
	};
	

	public ArrayList<VehicleInfoVO> findVehicle(String keyword){
		System.out.println("found vehicle");
		return new ArrayList<>();
	};
	

	public ArrayList<DriverInfoVO> findDriver(String keyword){
		System.out.println("found driver");
		return new ArrayList<>();
	};
	
	

}
