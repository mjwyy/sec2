package businesslogicservice.infoblservice._driver;

import java.io.File;

import vo.DriverVO;
import vo.VehicleInfoVO;
import businesslogicservice.infoblservice.DriverVehicleManagementBLService;

public class DriverVehicleManagementBLService_Driver{
	

	public void drive(DriverVehicleManagementBLService service){
		service.addDriver(new DriverVO("00210", "����", "2001-10-04", null, null, null, null));
		service.deleteDriver(new DriverVO("00210", "����", "2001-10-04", null, null, null, null));
		service.findDriver(new DriverVO("00210", "����", "2001-10-04", null, null, null, null));
		service.modifyDriver(new DriverVO("00210", "����", "2001-10-04", null, null, null, null));
		service.addVehicle(new VehicleInfoVO("00120", "21221", null,new File("vehicle.txt")));
		service.deleteVehicle(new VehicleInfoVO("00120", "21221", null,new File("vehicle.yxy")));
		service.findVehicle(new VehicleInfoVO("00120", "21221", null,new File("vehilce.txt")));
		service.modifyVehicle(new VehicleInfoVO("00120", "21221", null,new File("vehicle.tx")));

	}

}
