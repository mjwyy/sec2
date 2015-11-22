package data.infodata;

import static junit.framework.TestCase.assertEquals;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import data.dao.DatabaseFactory;
import dataservice.infodataservice.SystemUserManagementDataService;
import org.junit.Test;

import po.UserPO;
import data.infodata.MockObject.MockSystemUserManagement;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;

public class SystemUserManagementData_Test {

//	@Test
	public void testAddUser() throws Exception {
		UserPO po = new UserPO("toDelete","sbsbsb",5);
        SystemUserManagementDataService service = DatabaseFactory.getSystemUserManagementDataInstance();
		assertEquals(true,service.addUser(po));
	}

//	@Test
	public void testRemoveUser() throws Exception {
        UserPO po = new UserPO("test1",null,0);
        SystemUserManagementDataService service = DatabaseFactory.getSystemUserManagementDataInstance();
        assertEquals(true,service.removeUser(po));
	}

//    @Test
    public void testInquireUser() throws Exception {
        UserPO a=new UserPO("admin",null,0);
        SystemUserManagementDataService service = DatabaseFactory.getSystemUserManagementDataInstance();
        ArrayList<UserPO> result = service.inquireUser(a);
        for (UserPO po2:result) {
            System.out.println(po2);
        }
    }

//	@Test
	public void testGetAllUsers() throws Exception {
        SystemUserManagementDataService service = DatabaseFactory.getSystemUserManagementDataInstance();
        ArrayList<UserPO> result = service.getAllUsers();
        for (UserPO po2:result) {
            System.out.println(po2);
        }
	}

}
