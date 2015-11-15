package data.infodata;

import static junit.framework.TestCase.assertEquals;

import java.rmi.RemoteException;

import org.junit.Test;

import data.infodata.MockObject.MockSystemUserManagement;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;

public class SystemUserManagementData_Test {

	@Test
	public void testAddUser() throws RemoteException, InterruptWithExistedElementException {
		MockSystemUserManagement a=new MockSystemUserManagement("1234567");
		SystemUserManagementData b=new SystemUserManagementData();
		b.addUser(a);
		assertEquals("1234567",a.getAccount());
	}

	@Test
	public void testRemoveUser() throws RemoteException, ElementNotFoundException {
		MockSystemUserManagement a=new MockSystemUserManagement("1234567");
		SystemUserManagementData b=new SystemUserManagementData();
		b.removeUser(a);
		assertEquals("1234567",a.getAccount());
	}



	@Test
	public void testInquireUser() throws RemoteException, ElementNotFoundException {
		MockSystemUserManagement a=new MockSystemUserManagement("1234567");
		SystemUserManagementData b=new SystemUserManagementData();
		b.inquireUser(a);
		assertEquals("1234567",a.getAccount());
	}

	@Test
	public void testGetAllUsers() throws RemoteException {
		MockSystemUserManagement a=new MockSystemUserManagement("1234567");
		SystemUserManagementData b=new SystemUserManagementData();
		b.getAllUsers();
		assertEquals("1234567",a.getAccount());
	}

}
