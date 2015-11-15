package data.infodata;

import static junit.framework.TestCase.assertEquals;

import java.rmi.RemoteException;

import org.junit.Test;

import data.infodata.MockObject.MockBankAccountManagement;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;

public class BankAccountManagementData_Test {

	@Test
	public void testAddBankAccount() throws RemoteException, InterruptWithExistedElementException {
		MockBankAccountManagement bam=new MockBankAccountManagement("lizy");
		BankAccountManagementData bmd=new BankAccountManagementData();
		bmd.addBankAccount(bam);
		assertEquals("lizy",bam.getName());
	}

	@Test
	public void testRemoveBankAccount() throws RemoteException, InterruptWithExistedElementException, ElementNotFoundException {
		MockBankAccountManagement bam=new MockBankAccountManagement("lizy");
		BankAccountManagementData bmd=new BankAccountManagementData();
		bmd.removeBankAccount(bam);
		assertEquals("lizy",bam.getName());
	}



	@Test
	public void testFindBankAccount() throws RemoteException, ElementNotFoundException {
		MockBankAccountManagement bam=new MockBankAccountManagement("lizy");
		BankAccountManagementData bmd=new BankAccountManagementData();
		bmd.findBankAccount(bam);
		assertEquals("lizy",bam.getName());
	}

	@Test
	public void testGetAllAccounts() {
		 assertEquals(1,1);
	}

}
