package data.infodata;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.RMIPublisher;
import po.DriverPO;
import po.StaffPO;
import po.VehiclePO;
import data.database.DatabaseFactoryMysqlImpl;
import data.database.DatabaseManager;
import data.statisticdata.LogInsHelper;
import data.statisticdata.inte.LogInsertDataService;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import dataservice.infodataservice.DriverVehicleManagementDataService;
import dataservice.infodataservice.StaffOrganizationManagementDataService;

public class DriverVehicleManagementData extends UnicastRemoteObject implements DriverVehicleManagementDataService{


    private static final long serialVersionUID = 7214249074956257035L;

    
    public DriverVehicleManagementData() throws RemoteException {
        super();
    }

    @Override
    public boolean addDriver(DriverPO driver) throws RemoteException,
            InterruptWithExistedElementException, SQLException {
    	Connection connection = DatabaseManager.getConnection();
        //First, insert as a staff.
        StaffOrganizationManagementDataService staffIns = DatabaseFactoryMysqlImpl.getInstance().getStaffOrganizationManagementDataService();

        boolean result = staffIns.addStaff(driver);

        //If insertion failed then skip the operation
        if(!result) {
            return false;
        }

        //Get the Staff to be linked to.
        StaffPO get = null;
        try {
            get = staffIns.findStaff(driver).get(0);
        } catch (Exception e) {
            LogInsHelper.insertLog("查找员工："+driver.getName()+"失败，新增司机操作取消");
            e.printStackTrace();
            DatabaseManager.releaseConnection(connection,null,null);
            return false;
        }

        String stat = "insert into Drivers (staffID,licenseDate) values('"+driver.getStaffID()+"','"+driver.getLicenseDate()+"')";
        PreparedStatement statement = connection.prepareStatement(stat);
        int resultNum = statement.executeUpdate();
        LogInsHelper.insertLog("新增司机信息完成："+(resultNum>0));
        
        DatabaseManager.releaseConnection(connection,statement,null);
        
        return resultNum > 0;
    }

    @Override
    public boolean addVehicle(VehiclePO vehicle) throws InterruptWithExistedElementException, SQLException, IOException {
    	Connection connection = DatabaseManager.getConnection();

        ArrayList<VehiclePO> list = inquireVehicle(vehicle);
        if(list.size()>0) {
        	LogInsHelper.insertLog("尝试添加车辆："+vehicle.getCarNumber()+"但数据库已包含其数据");
            return false;
        }

        String sql = "insert into Vehicles (carNumber,organizationNumber,firstUseTime,"
                + "picName,picFile) values (?,?,?,?,?)";
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setString(1, vehicle.getCarNumber());
        stmt.setString(2, vehicle.getInstitutionNumber());
        stmt.setString(3, vehicle.getFirstUseTime());

        File picture = vehicle.getPicture();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(picture);
        } catch (FileNotFoundException e) {
        	LogInsHelper.insertLog("读取图片失败："+picture.getName());
            e.printStackTrace();
            DatabaseManager.releaseConnection(connection,null,null);
            return false;
        }

        stmt.setString(4, picture.getName());
        stmt.setBinaryStream(5, fis);

        int resultNum = stmt.executeUpdate();

        LogInsHelper.insertLog("成功加入车辆信息："+vehicle.getCarNumber());
        DatabaseManager.releaseConnection(connection,stmt,null);
        
        return resultNum>0;
    }

    @Override
    public boolean removeDriver(DriverPO driver) throws RemoteException,
            ElementNotFoundException, SQLException {
    	Connection connection = DatabaseManager.getConnection();
        //First, delete as a staff.
        StaffOrganizationManagementDataService staffIns = DatabaseFactoryMysqlImpl.getInstance().getStaffOrganizationManagementDataService();
       
        try {
            boolean result = staffIns.removeStaff(driver);
            if(!result) throw new Exception();
        } catch (Exception e) {
        	LogInsHelper.insertLog("删除员工："+driver.getName()+"失败，删除司机操作取消");
            e.printStackTrace();
            DatabaseManager.releaseConnection(connection,null,null);
            return false;
        }

        String stat = "delete from Drivers from where staffID='"+driver.getStaffID()+"'";
        PreparedStatement statement = connection.prepareStatement(stat);
        
        int resultNum = statement.executeUpdate();
        
        LogInsHelper.insertLog("删除司机信息完成："+(resultNum>0));
        
        DatabaseManager.releaseConnection(connection,statement,null);
        return resultNum>0;
    }

    @Override
    public boolean removeVehicle(VehiclePO vehicle) throws ElementNotFoundException, SQLException, IOException {
    	Connection connection = DatabaseManager.getConnection();
        LogInsertDataService logIns = DatabaseFactoryMysqlImpl.getInstance().getLogInsertDataService();

        ArrayList<VehiclePO> list = inquireVehicle(vehicle);
        if(list.size()==0) {
            logIns.insertSystemLog("欲删除车辆信息："+vehicle.getCarNumber()+",未找到此信息");
            DatabaseManager.releaseConnection(connection,null,null);
            return false;
        }

        String sql = "delete from Vehicles where carNumber='"+vehicle.getCarNumber()+"'";
        PreparedStatement stmt = connection.prepareStatement(sql);
        int resultNum = stmt.executeUpdate();

        logIns.insertSystemLog("成功删除车辆信息:"+vehicle.getCarNumber());
        DatabaseManager.releaseConnection(connection,stmt,null);
        return resultNum>0;
    }

    @Override
    public boolean modifyDriver(DriverPO driver) throws RemoteException, ElementNotFoundException, InterruptWithExistedElementException, SQLException {
    	Connection connection = DatabaseManager.getConnection();
    	
    	StaffOrganizationManagementDataService staffIns = DatabaseFactoryMysqlImpl.getInstance().getStaffOrganizationManagementDataService();
       
        try {
            boolean result = staffIns.modifyStaff(driver);
            if(!result) throw new Exception();
        } catch (Exception e) {
        	LogInsHelper.insertLog("修改员工："+driver.getName()+"失败，修改司机操作取消");
            e.printStackTrace();
            DatabaseManager.releaseConnection(connection,null,null);
            return false;
        }

        String stat = "update Drivers set licenseDate='"+driver.getLicenseDate()+"' where staffID='"+driver.getStaffID()+"'";
        PreparedStatement statement = connection.prepareStatement(stat);
        int resultNum = statement.executeUpdate();
        LogInsHelper.insertLog("修改司机信息完成："+(resultNum>0));
        DatabaseManager.releaseConnection(connection,statement,null);
        return resultNum>0;
    }

    @Override
    public boolean modifyVehicle(VehiclePO originalVehicle) throws ElementNotFoundException, InterruptWithExistedElementException, SQLException, IOException {
    	Connection connection = DatabaseManager.getConnection();

        ArrayList<VehiclePO> list = inquireVehicle(originalVehicle);
        if(list.size()==0) {
        	LogInsHelper.insertLog("欲修改车辆信息："+originalVehicle.getCarNumber()+",未找到记录");
            DatabaseManager.releaseConnection(connection,null,null);
            throw new ElementNotFoundException("未找到该车辆信息");
        }

        boolean result = removeVehicle(originalVehicle);
        if(!result) {
            result = addVehicle(originalVehicle);
        }

        LogInsHelper.insertLog("成功修改车辆信息："+originalVehicle.getCarNumber());
        DatabaseManager.releaseConnection(connection,null,null);
        return result;
    }

    @Override
    public ArrayList<DriverPO> getAllDriver() throws RemoteException, SQLException {
    	Connection connection = DatabaseManager.getConnection();
    	StaffOrganizationManagementDataService staffIns = DatabaseFactoryMysqlImpl.getInstance().getStaffOrganizationManagementDataService();
    	
        ArrayList<DriverPO> result = new ArrayList<>();

        String stat = "select * from Drivers";
        PreparedStatement statement = connection.prepareStatement(stat);
        ResultSet drivers = statement.executeQuery();

        while(drivers.next()) {
            try {
                StaffPO temp = staffIns.findStaff(new StaffPO(drivers.getString("staffID"), null, null, null, null, 0, null, null, 0)).get(0);
                result.add(new DriverPO(temp, drivers.getString("licenseDate")));
            } catch (Exception e) {
            	LogInsHelper.insertLog("获取员工信息失败，取消获取司机信息操作");
                e.printStackTrace();
                DatabaseManager.releaseConnection(connection,statement,drivers);
                return new ArrayList<>();
            }
        }
        LogInsHelper.insertLog("返回司机信息完成：返回数量为"+result.size());
        DatabaseManager.releaseConnection(connection,statement,drivers);
        return result;
    }

    @Override
    public ArrayList<VehiclePO> getAllVehicles() throws SQLException, IOException {
        return inquireVehicle(null);
    }

    @Override
    public ArrayList<DriverPO> inquireDriver(DriverPO keywords)
            throws RemoteException, ElementNotFoundException, SQLException {
    	Connection connection = DatabaseManager.getConnection();
        StaffOrganizationManagementDataService staffIns = DatabaseFactoryMysqlImpl.getInstance().getStaffOrganizationManagementDataService();
        
        ArrayList<DriverPO> result = new ArrayList<>();

        String stat = null;
        if(keywords==null) {
        	stat = "select * from Drivers";
        	PreparedStatement statement = connection.prepareStatement(stat);
            ResultSet drivers = statement.executeQuery();

            while(drivers.next()) {
                StaffPO temp = staffIns.findStaff(new StaffPO(drivers.getString("staffID"), null, null, null, null, 0, null, null, 0)).get(0);
                result.add(new DriverPO(temp, drivers.getString("licenseDate")));
            }
            
            DatabaseManager.releaseConnection(connection,statement,drivers);
            
        } else if(keywords.getLicenseDate()!=null) {// Search the driver list first.

            stat = "select * from Drivers where licenseDate LIKE '%"+keywords.getLicenseDate()+"%'";
            PreparedStatement statement = connection.prepareStatement(stat);
            ResultSet drivers = statement.executeQuery();

            while(drivers.next()) {
                StaffPO temp = staffIns.findStaff(new StaffPO(drivers.getString("staffID"), null, null, null, null, 0, null, null, 0)).get(0);
                result.add(new DriverPO(temp, drivers.getString("licenseDate")));
            }
            
            DatabaseManager.releaseConnection(connection,statement,drivers);

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
        LogInsHelper.insertLog("返回司机信息完成：返回数量为"+result.size());
        
        return result;
    }

    @Override
    public ArrayList<VehiclePO> inquireVehicle(VehiclePO keywords)
            throws SQLException, IOException {
    	Connection connection = DatabaseManager.getConnection();
        
        ArrayList<VehiclePO> result = new ArrayList<>();

        String sql = "select * from Vehicles";

        if(keywords==null) {
            // Do nothing
        } else {
            sql = sql + " where ";
            if(keywords.getCarNumber()!=null) {
                sql = sql + "(carNumber LIKE '%"+keywords.getCarNumber()+"%') ";
            }
            if(keywords.getInstitutionNumber()!=null) {
                if(keywords.getCarNumber()!=null) {
                    sql = sql + " OR ";
                }
                sql = sql + "(organizationNumber LIKE '%"+keywords.getInstitutionNumber()+"%')";
            }
        }

        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet set = stmt.executeQuery();
        while(set.next()) {
            String carNum = set.getString("carNumber");
            String org = set.getString("organizationNumber");
            String first = set.getString("firstUseTime");

            InputStream fis = set.getBinaryStream("picFile");
            String picName = set.getString("picName");
            File pic = File.createTempFile(picName, "");
            FileOutputStream fos = new FileOutputStream(pic);

            byte[] buf = new byte[1024];
            int data = 0;
            while((data = fis.read(buf))!=-1) {
                fos.write(buf, 0, data);
            }
            fis.close();
            fos.close();

            VehiclePO po = new VehiclePO(carNum, org, pic, first);
            result.add(po);
        }

        LogInsHelper.insertLog("成功查找车辆信息");
        DatabaseManager.releaseConnection(connection,stmt,set);
        return result;
    }

}
