package data.infodata;

import static junit.framework.TestCase.assertEquals;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data.database.DatabaseFactoryMysqlImpl;
import data.database.DatabaseFactory;
import dataservice.infodataservice.SystemUserManagementDataService;

import po.UserPO;

public class SystemUserManagementData_Test {
    DatabaseFactory databaseFactory;

    public SystemUserManagementData_Test() throws RemoteException {
        databaseFactory = DatabaseFactoryMysqlImpl.getInstance();
    }

    //	@Test
	public void testAddUser() throws Exception {
		UserPO po = new UserPO("toDelete","sbsbsb",5);
        SystemUserManagementDataService service = databaseFactory.getSystemUserManagementDataService();
		assertEquals(true,service.addUser(po));
	}

//	@Test
	public void testRemoveUser() throws Exception {
        UserPO po = new UserPO("test1",null,0);
        SystemUserManagementDataService service = databaseFactory.getSystemUserManagementDataService();
        assertEquals(true,service.removeUser(po));
	}

//    @Test
    public void testInquireUser() throws Exception {
        UserPO a=new UserPO("admin",null,0);
        SystemUserManagementDataService service = databaseFactory.getSystemUserManagementDataService();
        ArrayList<UserPO> result = service.inquireUser(a);
        for (UserPO po2:result) {
            System.out.println(po2);
        }
    }

//	@Test
	public void testGetAllUsers() throws Exception {
        SystemUserManagementDataService service = databaseFactory.getSystemUserManagementDataService();
        ArrayList<UserPO> result = service.getAllUsers();
        for (UserPO po2:result) {
            System.out.println(po2);
        }
	}

}
