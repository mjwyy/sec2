package data.infodata;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import po.DriverPO;
import po.StaffPO;
import po.VehiclePO;
import data.database.DatabaseFactory;
import data.database.DatabaseFactoryMysqlImpl;
import data.statisticdata.inte.LogInsertDataService;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import dataservice.infodataservice.DriverVehicleManagementDataService;
import dataservice.infodataservice.StaffOrganizationManagementDataService;

public class DriverVehicleManagementData implements DriverVehicleManagementDataService{

	Connection connection;
	DatabaseFactory dataFac = null;
	
	public DriverVehicleManagementData(Connection con) throws RemoteException {
		super();
		connection = con;
		dataFac = DatabaseFactoryMysqlImpl.getInstance();
	}

    public DriverVehicleManagementData() {

    }

    @Override
    public boolean addDriver(DriverPO driver) throws RemoteException,
			InterruptWithExistedElementException, SQLException {
		
		//First, insert as a staff.
		StaffOrganizationManagementDataService staffIns = dataFac.getStaffOrganizationManagementDataService();
		LogInsertDataService logIns = dataFac.getLogInsertDataService();
		boolean result = staffIns.addStaff(driver);
		
		//If insertion failed then skip the operation
		if(!result) {
			return false;
		}
		
		//Get the Staff to be linked to.
		StaffPO get ;
		try {
			get = staffIns.findStaff(driver).get(0);
		} catch (Exception e) {
			logIns.insertSystemLog("查找员工："+driver.getName()+"失败，新增司机操作取消");
			return false;
		}
		
		String stat = "insert into Drivers (staffID,licenseDate) values('"+driver.getStaffID()+"','"+driver.getLicenseDate()+"')";
		PreparedStatement statement = connection.prepareStatement(stat);
		int resultNum = statement.executeUpdate();
		logIns.insertSystemLog("新增司机信息完成："+(resultNum>0));
		return resultNum > 0;
	}

	@Override
	public boolean addVehicle(VehiclePO vehicle) throws RemoteException,
			InterruptWithExistedElementException {
		//TODO how to store the file?
		return false;
	}

	@Override
	public boolean removeDriver(DriverPO driver) throws RemoteException,
			ElementNotFoundException, SQLException {
		//First, delete as a staff.
		StaffOrganizationManagementDataService staffIns = dataFac.getStaffOrganizationManagementDataService();
		LogInsertDataService logIns = dataFac.getLogInsertDataService();
		try {
			boolean result = staffIns.removeStaff(driver);
			if(!result) throw new Exception();
		} catch (Exception e) {
			logIns.insertSystemLog("删除员工："+driver.getName()+"失败，删除司机操作取消");
		}
		
		String stat = "delete from Drivers from where staffID='"+driver.getStaffID()+"'";
		PreparedStatement statement = connection.prepareStatement(stat);
		int resultNum = statement.executeUpdate();
		logIns.insertSystemLog("删除司机信息完成："+(resultNum>0));
		return resultNum>0;
	}

	@Override
	public boolean removeVehicle(VehiclePO vehicle) throws RemoteException,
			ElementNotFoundException {
		 
		return false;
	}

    @Override
    public boolean modifyDriver(DriverPO driver) throws RemoteException, ElementNotFoundException, InterruptWithExistedElementException, SQLException {
    	StaffOrganizationManagementDataService staffIns = dataFac.getStaffOrganizationManagementDataService();
		LogInsertDataService logIns = dataFac.getLogInsertDataService();
		try {
			boolean result = staffIns.modifyStaff(driver);
			if(!result) throw new Exception();
		} catch (Exception e) {
			logIns.insertSystemLog("修改员工："+driver.getName()+"失败，修改司机操作取消");
		}
		
		String stat = "update Drivers set licenseDate='"+driver.getLicenseDate()+"' where staffID='"+driver.getStaffID()+"'";
		PreparedStatement statement = connection.prepareStatement(stat);
		int resultNum = statement.executeUpdate();
		logIns.insertSystemLog("修改司机信息完成："+(resultNum>0));
    	return resultNum>0;
    }

    @Override
    public boolean modifyVehicle(VehiclePO originalVehicle) throws RemoteException, ElementNotFoundException, InterruptWithExistedElementException {
        return false;
    }

	@Override
	public ArrayList<DriverPO> getAllDriver() throws RemoteException, SQLException {
		StaffOrganizationManagementDataService staffIns = dataFac.getStaffOrganizationManagementDataService();
		LogInsertDataService logIns = dataFac.getLogInsertDataService();
		ArrayList<DriverPO> result = new ArrayList<>();
		
		String stat = "select * from Drivers";
		PreparedStatement statement = connection.prepareStatement(stat);
		ResultSet drivers = statement.executeQuery();
		
		while(drivers.next()) {
			try {
				StaffPO temp = staffIns.findStaff(new StaffPO(drivers.getString("staffID"), null, null, null, null, 0, null, null, 0)).get(0);
				result.add(new DriverPO(temp, drivers.getString("licenseDate")));
			} catch (Exception e) {
				logIns.insertSystemLog("获取员工信息失败，取消获取司机信息操作");
				return new ArrayList<>();
			}
		}
		logIns.insertSystemLog("返回司机信息完成：返回数量为"+result.size());
		return result;
	}

	@Override
	public ArrayList<VehiclePO> getAllVehicles() throws RemoteException {
		 
		return null;
	}

	@Override
	public ArrayList<DriverPO> inquireDriver(DriverPO keywords)
			throws RemoteException, ElementNotFoundException, SQLException {
		
		StaffOrganizationManagementDataService staffIns = dataFac.getStaffOrganizationManagementDataService();
		LogInsertDataService logIns = dataFac.getLogInsertDataService();
		ArrayList<DriverPO> result = new ArrayList<>();
		
		String stat = null;
		if(keywords.getLicenseDate()!=null) {// Search the driver list first.
			
			stat = "select * from Drivers where licenseData LIKE '%"+keywords.getLicenseDate()+"%'";
			PreparedStatement statement = connection.prepareStatement(stat);
			ResultSet drivers = statement.executeQuery();
			
			while(drivers.next()) {
				StaffPO temp = staffIns.findStaff(new StaffPO(drivers.getString("staffID"), null, null, null, null, 0, null, null, 0)).get(0);
				result.add(new DriverPO(temp, drivers.getString("licenseDate")));
			}
			
		} else { //Search the staff list first.
			ArrayList<StaffPO> staff = staffIns.findStaff(keywords);
			
			for(StaffPO po:staff) {
				stat = "select * from Drivers where staffID = '"+po.getStaffID()+"'";
				PreparedStatement statement = connection.prepareStatement(stat);
				ResultSet drivers = statement.executeQuery();
				if(!drivers.next()) continue;
				else {
					result.add(new DriverPO(po, drivers.getString("licenseDate")));
				}
			}
			
		}
		logIns.insertSystemLog("返回司机信息完成：返回数量为"+result.size());
		return result;
	}

	@Override
	public ArrayList<VehiclePO> inquireVehicle(VehiclePO keywords)
			throws RemoteException {
		 
		return null;
	}

}
