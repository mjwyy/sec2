package data.infodata;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import po.OrganizationPO;
import po.StaffPO;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import dataservice.infodataservice.StaffOrganizationManagementDataService;
import util.enums.OrganizationType;

public class StaffOrganizationManagementData implements
		StaffOrganizationManagementDataService {

    private Connection connection;

    public StaffOrganizationManagementData(Connection con) throws RemoteException {
        super();
        this.connection = con;
    }

    @Override
	public boolean addStaff(StaffPO staff) throws RemoteException,
			InterruptWithExistedElementException {
        String sql = "insert into staff ( `gender`, `salary`, `position`, `organization`," +
                " `workHour`, `staff_id`, `idCardNumber`, `name`, `phoneNumber`) " +
                "values ( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		return false;
	}

	@Override
	public boolean addOrganization(OrganizationPO org) throws RemoteException,
            InterruptWithExistedElementException, SQLException {
        String sql = "insert into `organization` (type,name,organization_id) " +
                "values (?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,org.getType().getType());
        statement.setString(2,org.getName());
        statement.setInt(3,Integer.parseInt(org.getCode()));
        int result = statement.executeUpdate();
        statement.close();
		return result>0;
	}

	@Override
	public boolean removeStaff(StaffPO staff) throws RemoteException,
			ElementNotFoundException {
		  
		return false;
	}

	@Override
	public boolean removeOrganization(OrganizationPO org)
            throws RemoteException, ElementNotFoundException, SQLException {
        String sql = "DELETE from `organization` where organization_id = "+org.getCode();
        PreparedStatement statement = connection.prepareStatement(sql);
        int result = statement.executeUpdate();
        statement.close();
        return result>0;
	}

    @Override
    public boolean modifyStaff(StaffPO staff) throws RemoteException, ElementNotFoundException, InterruptWithExistedElementException {
        return false;
    }

    @Override
    public boolean modifyOrganization(OrganizationPO org) throws RemoteException, ElementNotFoundException, InterruptWithExistedElementException {
        return false;
    }

	@Override
	public ArrayList<StaffPO> findStaff(StaffPO info) throws RemoteException,
			ElementNotFoundException {
		  
		return null;
	}

	@Override
	public ArrayList<OrganizationPO> findOrganization(OrganizationPO info)
            throws RemoteException, ElementNotFoundException, SQLException {
        String sql = "SELECT * FROM organization WHERE name LIKE '%"+info.getName()+"%'";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        ArrayList<OrganizationPO> result = new ArrayList<>();
        while (resultSet.next()){
            int organization_id = resultSet.getInt(1);
            int intType = resultSet.getInt(2);
            String name = resultSet.getString(3);
            OrganizationType type = OrganizationType.getOrgType(intType);
            OrganizationPO po = new OrganizationPO(Integer.toString(organization_id),type,name);
            result.add(po);
        }
        statement.close();
        return result;
	}

	@Override
	public ArrayList<StaffPO> getAllStaff() throws RemoteException {

		return null;
	}

	@Override
	public ArrayList<OrganizationPO> getAllOrganizations()
            throws RemoteException, SQLException {
        String sql = "SELECT * from organization";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        ArrayList<OrganizationPO> result = new ArrayList<>();
        while (resultSet.next()){
            int organization_id = resultSet.getInt(1);
            int intType = resultSet.getInt(2);
            String name = resultSet.getString(3);
            OrganizationType type = OrganizationType.getOrgType(intType);
            OrganizationPO po = new OrganizationPO(Integer.toString(organization_id),type,name);
            result.add(po);
        }
        statement.close();
        return result;
	}

}
