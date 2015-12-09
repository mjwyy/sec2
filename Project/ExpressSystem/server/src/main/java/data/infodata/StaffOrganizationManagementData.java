package data.infodata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.database.DatabaseManager;
import data.database.SqlHelper;
import data.statisticdata.LogInsHelper;
import po.OrganizationPO;
import po.StaffPO;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import dataservice.infodataservice.StaffOrganizationManagementDataService;
import util.enums.OrganizationType;
import util.enums.StaffType;

public class StaffOrganizationManagementData extends UnicastRemoteObject implements
		StaffOrganizationManagementDataService {

	private static final long serialVersionUID = 5173539351377111629L;

	public StaffOrganizationManagementData() throws RemoteException {
        super();
    }

    @Override
	public boolean addStaff(StaffPO staff) throws RemoteException,
            InterruptWithExistedElementException{
        Connection connection = DatabaseManager.getConnection();
        String sql = "insert into `staff` ( `gender`, `salary`, `position`, `organization`," +
                " `workHour`, `staff_id`, `idCardNumber`, `name`, `phoneNumber`) " +
                "values ( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = null;
        int result = 0;
        try {
            if(!this.findStaff(staff).isEmpty()){
                LogInsHelper.insertLog("新增人员失败:信息已存在!");
                DatabaseManager.releaseConnection(connection,null,null);
                throw new InterruptWithExistedElementException("新增人员失败，信息已存在!");
            }
        } catch (ElementNotFoundException e) {}
        try {
            statement = connection.prepareStatement(sql);
            int gender = staff.getGender().equals("男") ? 0 : 1;
            statement.setInt(1, gender);
            statement.setDouble(2, staff.getSalary());
            statement.setInt(3, staff.getPosition().getIntStaffType());
            statement.setString(4, staff.getOrganization());
            statement.setDouble(5, staff.getWorkHour());
            statement.setString(6, staff.getStaffID());
            statement.setString(7, staff.getIDCardNumber());
            statement.setString(8, staff.getName());
            statement.setString(9, staff.getPhoneNumber());
            result = statement.executeUpdate();
            LogInsHelper.insertLog("新增人员:"+staff.getName());
        } catch (SQLException e) {
            e.printStackTrace();
            LogInsHelper.insertLog("新增人员失败!");
            DatabaseManager.releaseConnection(connection,statement,null);
            return false;
        }
        DatabaseManager.releaseConnection(connection,statement,null);
        return result > 0;
    }

	@Override
	public boolean addOrganization(OrganizationPO org) throws RemoteException,
            InterruptWithExistedElementException{
        Connection connection = DatabaseManager.getConnection();
        String sql = "insert into `organization` (type,name,organization_id) " +
                "values (?,?,?)";
        PreparedStatement statement = null;
        int result = 0;
        try {
            if(!this.findOrganization(org).isEmpty()){
                LogInsHelper.insertLog("新增机构失败:信息已存在!");
                DatabaseManager.releaseConnection(connection,null,null);
                throw new InterruptWithExistedElementException("新增机构失败:信息已存在!");
            }
        } catch (ElementNotFoundException e) {}
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,org.getType().getType());
            statement.setString(2,org.getName());
            statement.setString(3,org.getCode());
            result = statement.executeUpdate();
            LogInsHelper.insertLog("新增机构成功!");
            DatabaseManager.releaseConnection(connection,statement,null);
        } catch (SQLException e) {
            e.printStackTrace();
            LogInsHelper.insertLog("新增机构失败!");
            DatabaseManager.releaseConnection(connection,statement,null);
            return false;
        }
		return result > 0;
	}

	@Override
	public boolean removeStaff(StaffPO staff) throws RemoteException,
            ElementNotFoundException{
        if(this.findStaff(staff).isEmpty()){
            LogInsHelper.insertLog("人员信息不存在,删除失败");
            throw new ElementNotFoundException();
        }
        String sql = "DELETE from `staff` where staff_id = '" + staff.getStaffID()+"'";
        try {
            SqlHelper.excUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            LogInsHelper.insertLog("删除人员信息失败");
            return false;
        }
        LogInsHelper.insertLog("删除人员:"+staff.getName());
        return true;
    }

	@Override
	public boolean removeOrganization(OrganizationPO org)
            throws RemoteException, ElementNotFoundException{
        if(this.findOrganization(org).isEmpty()){
            LogInsHelper.insertLog("机构信息不存在,删除失败");
            throw new ElementNotFoundException();
        }
        String sql = "DELETE from `organization` where organization_id = "+org.getCode();
        try {
            SqlHelper.excUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            LogInsHelper.insertLog("删除机构信息失败");
            return false;
        }
        LogInsHelper.insertLog("删除机构:"+org.getName());
        return true;
    }

    @Override
    public boolean modifyStaff(StaffPO staff) throws RemoteException{
        int gender = staff.getGender().equals("男") ? 0 : 1;
        String sql = "UPDATE staff SET name = '" + staff.getName() + "'," +
                " organization = '" + staff.getOrganization() + "'," +
                " gender = '" + gender + "'," +
                " idCardNumber = '" + staff.getIDCardNumber() + "'," +
                " salary = '" + staff.getSalary() + "'," +
                " phoneNumber = '" + staff.getPhoneNumber() + "'," +
                " position = '" + staff.getPosition().getIntStaffType() + "'," +
                " workHour = '" + staff.getWorkHour() + "'" +
                " WHERE staff_id = '" + staff.getStaffID() + "'";
        try {
            SqlHelper.excUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            LogInsHelper.insertLog("修改人员信息失败");
            return false;
        }
        LogInsHelper.insertLog("修改人员信息:"+staff.getName());
        return true;
    }

    @Override
    public boolean modifyOrganization(OrganizationPO org) throws RemoteException{
        String sql = "UPDATE organization SET type = '" + org.getType().getType() + "'," +
                " name = '" + org.getName() + "'" +
                " WHERE organization_id = '" + org.getCode() + "'";
        try {
            SqlHelper.excUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            LogInsHelper.insertLog("修改机构信息失败");
        }
        LogInsHelper.insertLog("修改机构信息:"+org.getName());
        return true;
    }

	@Override
	public ArrayList<StaffPO> findStaff(StaffPO info) throws RemoteException,
            ElementNotFoundException{
        if(info == null){
            String sql2 = "SELECT * FROM staff";
            return this.excFindStaffStatement(sql2);
        }
        String sql = "";
        if (info.getStaffID() != null)
            sql = "SELECT * FROM staff WHERE staff_id = '" + info.getStaffID() + "'";
        else if (info.getName() != null)
            sql = "SELECT * FROM staff WHERE name LIKE '%" + info.getName() + "%'";
        else if (info.getOrganization() != null)
            sql = "SELECT * FROM staff WHERE organization LIKE '%" + info.getOrganization() + "%'";
        else if (info.getGender() != null) {
            int gender = info.getGender().equals("男") ? 0 : 1;
            sql = "SELECT * FROM staff WHERE gender =" + gender;
        } else if (info.getIDCardNumber() != null)
            sql = "SELECT * FROM staff WHERE idCardNumber LIKE '%" + info.getIDCardNumber() + "%'";
        else if (info.getSalary() != -1)
            sql = "SELECT * FROM staff WHERE salary LIKE '%" + info.getSalary() + "%'";
        else if (info.getPhoneNumber() != null)
            sql = "SELECT * FROM staff WHERE phoneNumber LIKE '%" + info.getPhoneNumber() + "%'";
        else if (info.getPosition() != null)
            sql = "SELECT * FROM staff WHERE position LIKE '%" + info.getPosition().getIntStaffType() + "%'";
        else if (info.getWorkHour() != -1)
            sql = "SELECT * FROM staff WHERE workHour LIKE '%" + info.getWorkHour() + "%'";
        return this.excFindStaffStatement(sql);
    }

	@Override
	public ArrayList<OrganizationPO> findOrganization(OrganizationPO info)
            throws RemoteException, ElementNotFoundException{
        String sql = "";
        if(info.getCode() != null)
            sql = "SELECT * FROM organization WHERE organization_id = '" + info.getCode() + "'";
        else if (info.getName() != null)
            sql = "SELECT * FROM organization WHERE name LIKE '%" + info.getName() + "%'";
        else if (info.getType() != null)
            sql = "SELECT * FROM organization WHERE type = "+info.getType().getType();
        return this.excFindOrgStatement(sql);
    }

	@Override
    public ArrayList<StaffPO> getAllStaff() throws RemoteException{
        String sql = "SELECT * from `staff`";
        try {
            return this.excFindStaffStatement(sql);
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

	@Override
	public ArrayList<OrganizationPO> getAllOrganizations()
            throws RemoteException{
        String sql = "SELECT * from organization";
        try {
            return this.excFindOrgStatement(sql);
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private ArrayList<StaffPO> excFindStaffStatement(String str) throws ElementNotFoundException {
        Connection connection = DatabaseManager.getConnection();
        PreparedStatement statement = null;
        ArrayList<StaffPO> result = new ArrayList<>();
        try {
            statement = connection.prepareStatement(str);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String staff_id = resultSet.getString(1);
                String name = resultSet.getString(2);
                String orgnization = resultSet.getString(3);
                int intGender = resultSet.getInt(4);
                String idCardNumber = resultSet.getString(5);
                double salary = resultSet.getDouble(6);
                String phone = resultSet.getString(7);
                int intPosition = resultSet.getInt(8);
                double workhour = resultSet.getDouble(9);
                String strGender = intGender == 0 ? "男" : "女";
                StaffPO po = new StaffPO(staff_id, name, orgnization, strGender,
                        idCardNumber, salary, phone, StaffType.getStaffType(intPosition), workhour);
                result.add(po);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseManager.releaseConnection(connection,statement,null);
        if(result.isEmpty())
            throw new ElementNotFoundException();
        return result;
    }

    private ArrayList<OrganizationPO> excFindOrgStatement(String str) throws ElementNotFoundException {
        Connection connection = DatabaseManager.getConnection();
        PreparedStatement statement = null;
        ArrayList<OrganizationPO> result = new ArrayList<>();
        try {
            statement = connection.prepareStatement(str);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int organization_id = resultSet.getInt(1);
                int intType = resultSet.getInt(2);
                String name = resultSet.getString(3);
                OrganizationType type = OrganizationType.getOrgType(intType);
                OrganizationPO po = new OrganizationPO(Integer.toString(organization_id), type, name);
                result.add(po);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DatabaseManager.releaseConnection(connection,statement,null);
        if(result.isEmpty())
            throw new ElementNotFoundException();
        return result;
    }


}
