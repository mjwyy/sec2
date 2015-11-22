package businesslogic.info;

import businesslogicservice.infoblservice.DriverVehicleManagementBLService;
import util.ResultMsg;
import vo.DriverVO;
import vo.VehicleVO;

import java.util.ArrayList;

import connection.RemoteObjectGetter;
import dataservice.commoditydataservice.StorageInDataService;
import dataservice.infodataservice.DriverVehicleManagementDataService;

/**
 * Created by kylin on 15/11/17.
 */
public class DriverVehicleManagement implements DriverVehicleManagementBLService {
	
	DriverVehicleManagementDataService dataService = null;
	
	public DriverVehicleManagement() {
		RemoteObjectGetter getter = new RemoteObjectGetter();
		dataService = (DriverVehicleManagementDataService) getter.getObjectByName("DriverVehicleManagementDataService");
	}
	
    @Override
    public ResultMsg addVehicle(VehicleVO vo) {
        return null;
    }

    @Override
    public ResultMsg deleteVehicle(VehicleVO vo) {
        return null;
    }

    @Override
    public ResultMsg modifyVehicle(VehicleVO vo) {
        return null;
    }

    @Override
    public ResultMsg addDriver(DriverVO vo) {
        return null;
    }

    @Override
    public ResultMsg deleteDriver(DriverVO vo) {
        return null;
    }

    @Override
    public ResultMsg modifyDriver(DriverVO vo) {
        return null;
    }

    @Override
    public ArrayList<VehicleVO> findVehicle(VehicleVO vo) {
        return null;
    }

    @Override
    public ArrayList<DriverVO> findDriver(DriverVO vo) {
        return null;
    }
}
