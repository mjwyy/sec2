package data.infodata.Proxy;

import data.database.DatabaseConnection;
import data.infodata.StaffOrganizationManagementData;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import dataservice.infodataservice.StaffOrganizationManagementDataService;
import po.OrganizationPO;
import po.StaffPO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/11/24.
 */
public class StaffOrgManageProxy extends UnicastRemoteObject implements StaffOrganizationManagementDataService{
    private DatabaseConnection connection;
    private StaffOrganizationManagementDataService staffOrganizationManagementDataService;

    public StaffOrgManageProxy() throws RemoteException {
        connection = new DatabaseConnection();
        staffOrganizationManagementDataService =
                new StaffOrganizationManagementData(connection.getConnection());
    }


    @Override
    public boolean addStaff(StaffPO staff) throws RemoteException, InterruptWithExistedElementException, SQLException {
        boolean result = this.staffOrganizationManagementDataService.addStaff(staff);
        connection.close();
        return result;
    }

    @Override
    public boolean addOrganization(OrganizationPO org) throws RemoteException, InterruptWithExistedElementException, SQLException {
        boolean result = this.staffOrganizationManagementDataService.addOrganization(org);
        connection.close();
        return result;
    }

    @Override
    public boolean removeStaff(StaffPO staff) throws RemoteException, ElementNotFoundException, InterruptWithExistedElementException, SQLException {
        boolean result = this.staffOrganizationManagementDataService.removeStaff(staff);
        connection.close();
        return result;
    }

    @Override
    public boolean removeOrganization(OrganizationPO org) throws RemoteException, ElementNotFoundException, SQLException, InterruptWithExistedElementException {
        boolean result = this.staffOrganizationManagementDataService.removeOrganization(org);
        connection.close();
        return result;
    }

    @Override
    public boolean modifyStaff(StaffPO staff) throws RemoteException, ElementNotFoundException, InterruptWithExistedElementException, SQLException {
        boolean result = this.staffOrganizationManagementDataService.modifyStaff(staff);
        connection.close();
        return result;
    }

    @Override
    public boolean modifyOrganization(OrganizationPO org) throws RemoteException, ElementNotFoundException, InterruptWithExistedElementException, SQLException {
        boolean result = this.staffOrganizationManagementDataService.modifyOrganization(org);
        connection.close();
        return result;
    }

    @Override
    public ArrayList<StaffPO> findStaff(StaffPO info) throws RemoteException, ElementNotFoundException, SQLException {
        ArrayList<StaffPO> result = this.staffOrganizationManagementDataService.findStaff(info);
        connection.close();
        return result;
    }

    @Override
    public ArrayList<OrganizationPO> findOrganization(OrganizationPO info) throws RemoteException, ElementNotFoundException, SQLException {
        ArrayList<OrganizationPO> result = this.staffOrganizationManagementDataService.findOrganization(info);
        connection.close();
        return result;
    }

    @Override
    public ArrayList<StaffPO> getAllStaff() throws RemoteException, SQLException {
        ArrayList<StaffPO> result = this.staffOrganizationManagementDataService.getAllStaff();
        connection.close();
        return result;
    }

    @Override
    public ArrayList<OrganizationPO> getAllOrganizations() throws RemoteException, SQLException {
        ArrayList<OrganizationPO> result =
                this.staffOrganizationManagementDataService.getAllOrganizations();
        connection.close();
        return result;
    }
}
