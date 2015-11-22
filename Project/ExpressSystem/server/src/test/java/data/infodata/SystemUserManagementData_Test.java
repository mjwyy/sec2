package data.infodata;

import static junit.framework.TestCase.assertEquals;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Test;

import po.UserPO;
import data.infodata.MockObject.MockSystemUserManagement;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;

public class SystemUserManagementData_Test {
	static SystemUserManagementData b=new SystemUserManagementData();
static void init() throws RemoteException, InterruptWithExistedElementException{
	MockSystemUserManagement a=new MockSystemUserManagement("1234567");
	MockSystemUserManagement a1=new MockSystemUserManagement("1234666");
	MockSystemUserManagement a2=new MockSystemUserManagement("1234555");
	b.addUser(a);
	b.addUser(a1);
	b.addUser(a2);
}
	@Test
	public void testAddUser() throws RemoteException, InterruptWithExistedElementException {
		MockSystemUserManagement a3=new MockSystemUserManagement("1234567");
		//assertEquals(true,b.addUser(a3));
	}

	@Test
	public void testRemoveUser() throws RemoteException, ElementNotFoundException, InterruptWithExistedElementException {
		MockSystemUserManagement a4=new MockSystemUserManagement("1234566");
		//assertEquals(true,b.removeUser(a4));
	}



	@Test
	public void testInquireUser() throws RemoteException, ElementNotFoundException {
		MockSystemUserManagement a=new MockSystemUserManagement("1234567");
		ArrayList<UserPO> c=new ArrayList<UserPO>();
		c.add(a);
	//	assertEquals(c,b.inquireUser(a));
	}

	@Test
	public void testGetAllUsers() throws RemoteException {
		MockSystemUserManagement a=new MockSystemUserManagement("1234567");
		SystemUserManagementData b=new SystemUserManagementData();
		b.getAllUsers();
		//assertEquals("1234567",a.getAccount());
	}

}
