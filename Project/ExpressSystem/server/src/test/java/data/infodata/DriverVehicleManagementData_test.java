package data.infodata;

import static org.junit.Assert.*;

import java.io.File;
import java.rmi.RemoteException;

import org.junit.Test;

import data.infodata.MockObject.MockDriver;
import data.infodata.MockObject.MockVehicle;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import dataservice.infodataservice.DriverVehicleManagementDataService;

public class DriverVehicleManagementData_test {
	
	private static DriverVehicleManagementDataService service = new DriverVehicleManagementData();
	private static MockDriver driver1 = new MockDriver("025010007", "王莉莉", "1995-12-09",
				"320322199512096666", "18376567890", "男",
				"2018-10-10");
	private static MockDriver driver2 = new MockDriver("025010008", "王莉", "1995-11-09",
				"320322199511096777", "18376567890", "女",
				"2018-10-10");
	private static MockVehicle vehicle1 = new MockVehicle("0250100001", "六合营业厅", null,
				"2015-10-10");
	 private static MockVehicle vehicle2 = new MockVehicle("02501000002","鼓楼营业厅",null,
				"2015-10-10");

	static void init() throws RemoteException, InterruptWithExistedElementException{ 
		service.addDriver(driver1);
		service.addDriver(driver2);
		service.addVehicle(vehicle1);
		service.addVehicle(vehicle2);	
	}


	@Test
	public void testAddDriver() throws RemoteException, InterruptWithExistedElementException {
		MockDriver driver3 = new MockDriver("025010004", "金三胖", "1995-12-09",
				"320322199512096664", "18376567891", "男",
				"2018-10-10");
		//assertEquals(true,service.addDriver(driver3));
		
	}
    @Test
	public void testAddVehicle() throws RemoteException, InterruptWithExistedElementException {
		MockVehicle vehicle3 = new MockVehicle("02501000008","鼓楼营业厅",null,
				"2015-11-10");
		//assertEquals(true,service.addVehicle(vehicle3));
		
	}
    @Test
	public void testRemoveDriver() throws RemoteException, ElementNotFoundException, InterruptWithExistedElementException {
		MockDriver driver4 = new MockDriver("025010000", "金胖", "1995-12-09",
				"320322199512096654", "18376567896", "男",
				"2018-10-10");
		service.addDriver(driver4);
		//assertEquals(true,service.removeDriver(driver4));
	}
    @Test
	public void testRemoveVehicle() throws RemoteException, InterruptWithExistedElementException, ElementNotFoundException {
		MockVehicle vehicle4 = new MockVehicle("02501000003","鼓楼营业厅",null,
				"2015-11-10");
		service.addVehicle(vehicle4);
		//assertEquals(true,service.removeVehicle(vehicle4));		
	}
    @Test
	public void testFindDriver() throws RemoteException, ElementNotFoundException {
		//assertEquals(driver1,service.inquireDriver(new MockDriver("025010007", null, null,null, null, null,null)));
		//assertEquals(driver2,service.inquireDriver(new MockDriver(null, "王莉", null,null, null, null,null)));
		
		
	}
    @Test
	public void testFindVehicle() throws RemoteException {
		//assertEquals(vehicle1,service.inquireVehicle(new MockVehicle("02501000001",null,null,null)));
		//assertEquals(vehicle2,service.inquireVehicle(new MockVehicle("02501000002",null,null,null)));
	}
	
}
