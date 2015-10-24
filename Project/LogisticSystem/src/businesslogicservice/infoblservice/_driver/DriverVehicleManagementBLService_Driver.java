<<<<<<< HEAD
/**
 * 
 * @author wwz
 * @date 2015/10/17
 */
package businesslogicservice.infoblservice._driver;

import java.util.ArrayList;

import vo.DriverInfoVO;
import vo.VehicleInfoVO;
import businesslogic.util.ResultMsg;
import businesslogicservice.infoblservice.DriverVehicleManagementBLService;

public class DriverVehicleManagementBLService_Driver{
	

	public void drive(DriverVehicleManagementBLService service){
		service.addDriver(new DriverInfoVO("00210", "张三", "2001-10-04", null, null, null, null));
		service.deleteDriver(new DriverInfoVO("00210", "张三", "2001-10-04", null, null, null, null));
		service.findDriver("张三");
		service.modifyDriver(new DriverInfoVO("00210", "张三", "2001-10-04", null, null, null, null));
		service.addVehicle(new VehicleInfoVO("00120", "21221", null));
		service.deleteVehicle(new VehicleInfoVO("00120", "21221", null));
		service.findVehicle("00210");
		service.modifyVehicle(new VehicleInfoVO("00120", "21221", null));

	}

}
=======
/**
 * 
 * @author River
 * @date 2015/10/17
 */
package businesslogicservice.infoblservice._driver;

import java.util.ArrayList;

import vo.DriverInfoVO;
import vo.VehicleInfoVO;
import businesslogic.util.ResultMsg;
import businesslogicservice.infoblservice.DriverVehicleManagementBLService;

public class DriverVehicleManagementBLService_Driver{
	

	public void drive(DriverVehicleManagementBLService service){
		service.addDriver(new DriverInfoVO("00210", "Mark", "2001-10-04", null, null, null, null));
		service.deleteDriver(new DriverInfoVO("00210", "Mark", "2001-10-04", null, null, null, null));
		service.findDriver("Mark");
		service.modifyDriver(new DriverInfoVO("00210", "Mark", "2001-10-04", null, null, null, null));
		service.addVehicle(new VehicleInfoVO("00120", "21221", null));
		service.deleteVehicle(new VehicleInfoVO("00120", "21221", null));
		service.findVehicle("00210");
		service.modifyVehicle(new VehicleInfoVO("00120", "21221", null));

	}

}
>>>>>>> master
