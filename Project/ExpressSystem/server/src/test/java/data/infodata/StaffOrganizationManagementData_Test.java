package data.infodata;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.sql.SQLException;

import data.infodata.Proxy.StaffOrgManageProxy;
import dataservice.infodataservice.StaffOrganizationManagementDataService;
import org.junit.Test;

import po.OrganizationPO;
import dataservice.exception.InterruptWithExistedElementException;
import util.enums.OrganizationType;

public class StaffOrganizationManagementData_Test {

    @Test
    public void testAddOrg(){
        try {
            StaffOrganizationManagementDataService dataService
                     = new StaffOrgManageProxy();
            OrganizationPO po = new OrganizationPO("0516002",OrganizationType.SERVICE_HALL,
                    "徐州市沛县汤沐路营业厅");
            assertEquals(dataService.addOrganization(po),true);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InterruptWithExistedElementException e) {
            e.printStackTrace();
        }
    }

}
