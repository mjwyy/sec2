/**
 * 
 * @author wwz
 * @date 2015/10/17
 */
package businesslogicservice.infoblservice._driver;

import java.io.File;
import java.util.ArrayList;

import vo.DriverInfoVO;
import vo.VehicleInfoVO;
import businesslogic.util.ResultMsg;
import businesslogicservice.infoblservice.DriverVehicleManagementBLService;

public class DriverVehicleManagementBLService_Driver{
	

	public void drive(DriverVehicleManagementBLService service){
		service.addDriver(new DriverInfoVO("00210", "Mark", "2001-10-04", null, null, null, null));
		service.deleteDriver(new DriverInfoVO("00210", "Mark", "2001-10-04", null, null, null, null));
		service.findDriver(new DriverInfoVO("00210", "Mark", "2001-10-04", null, null, null, null));
		service.modifyDriver(new DriverInfoVO("00210", "Mark", "2001-10-04", null, null, null, null));
		service.addVehicle(new VehicleInfoVO("00120", "21221", null,new File("vehicle.txt")));
		service.deleteVehicle(new VehicleInfoVO("00120", "21221", null,new File("vehicle.yxy")));
		service.findVehicle(new VehicleInfoVO("00120", "21221", null,new File("vehilce.txt")));
		service.modifyVehicle(new VehicleInfoVO("00120", "21221", null,new File("vehicle.tx")));

	}

}
