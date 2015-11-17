package data.infodata;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data.infodata.MockObject.MockOrganizationPO;
import data.infodata.MockObject.MockStaffPO;
import org.junit.Test;

import po.StaffPO;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;

public class StaffOrganizationManagementData_Test {

	public StaffOrganizationManagementData_Test() {}
	
	static StaffOrganizationManagementData initService() throws RemoteException, InterruptWithExistedElementException{
		StaffOrganizationManagementData result = new StaffOrganizationManagementData();
		
		ArrayList<StaffPO> list = new ArrayList<>();
		list.add(new MockStaffPO("张三", "仙林营业厅", "123456198001012222", 3000, "13566677777", "营业厅业务员", 8.0));
		list.add(new MockStaffPO("李四", "仙林营业厅", "123456197001012345", 2500, "13500099876", "快递员", 10.0));
		
		result.addOrganization(new MockOrganizationPO("营业厅", "0251000", "仙林营业厅", list));
		
		result.addStaff(new MockStaffPO("李明", "仙林营业厅", "320602198808088888", 3000, "13888888888", "营业厅业务员", 8.0));
		
		return result;
	}
	
	@Test
	public void testRemoveStaff() throws RemoteException, InterruptWithExistedElementException, ElementNotFoundException{
		StaffOrganizationManagementData data = initService();
//		assertEquals(true,data.removeStaff(new MockStaffPO("李四", "仙林营业厅", "123456197001012345", 2500, "13500099876", "快递员", 10.0)));
//		try {
//			data.removeStaff(new MockStaffPO("王五", "仙林营业厅", "123456196001010987", 3220,"12567891234", "营业厅业务员", 8.0));
//		} catch(ElementNotFoundException e) {
//			assertEquals(1,1);
//		} catch (Exception e) {
//			assertEquals(1,0);
//		}
	}
	
	@Test
	public void testRemoveOrganization() throws RemoteException, InterruptWithExistedElementException, ElementNotFoundException{
		StaffOrganizationManagementData data = initService();
//		assertEquals(true,data.removeOrganization(new MockOrganizationPO("营业厅", "0251000", "仙林营业厅", null)));
//		try {
//			data.removeOrganization(new MockOrganizationPO("营业厅", "0251001", "鼓楼营业厅", null));
//		} catch(ElementNotFoundException e) {
//			assertEquals(1,1);
//		} catch (Exception e) {
//			assertEquals(1,0);
//		}
	}
	
	@Test
	public void testModifyStaff() throws RemoteException, ElementNotFoundException, InterruptWithExistedElementException{
		StaffOrganizationManagementData data = initService();
		
//		assertEquals(true,data.modifyStaff(new MockStaffPO("张三", "仙林营业厅", "123456198001012222", 3000, "13566677777", "营业厅业务员", 8.0),
//				new MockStaffPO("王五", "仙林营业厅", "123456196001010987", 3220,"12567891234", "营业厅业务员", 8.0)));
//		try {
//			assertEquals(false,data.modifyStaff(new MockStaffPO("王五", "仙林营业厅", "123456196001010987", 3220,"12567891234", "营业厅业务员", 8.0)
//			, new MockStaffPO("李四", "仙林营业厅", "123456197001012345", 2500, "13500099876", "快递员", 10.0)));
//		}catch(InterruptWithExistedElementException e) {
//			assertEquals(1, 1);
//		}catch(Exception e) {
//			assertEquals(0,1);
//		}
		
	}
	
	@Test
	public void testModifyOrganization() throws RemoteException, InterruptWithExistedElementException, ElementNotFoundException{
		StaffOrganizationManagementData data = initService();

//			assertEquals(true,data.modifyOrganization(new MockOrganizationPO("营业厅", "0251000", "仙林营业厅", null), new MockOrganizationPO("营业厅", "0251000", "南大营业厅", null)));
//			
//			try {
//				assertEquals(false,data.modifyOrganization(new MockOrganizationPO("营业厅", "0251000", "仙林营业厅", null), new MockOrganizationPO("营业厅", "0251000", "东南营业厅", null)));
//			} catch(ElementNotFoundException e) {
//				assertEquals(1,1);
//			} catch(Exception e) {
//				assertEquals(0,1);
//			}
	}
	
	@Test
	public void testFindStaff() throws RemoteException, InterruptWithExistedElementException, ElementNotFoundException{
		StaffOrganizationManagementData data = initService();
		
//		assertEquals(1,data.findStaff(new MockStaffPO("李明", "仙林营业厅", "320602198808088888", 3000, "13888888888", "营业厅业务员", 8.0)).size());
//		
//		try {
//			data.findStaff(new MockStaffPO("王五", "仙林营业厅", "123456196001010987", 3220,"12567891234", "营业厅业务员", 8.0));
//		} catch (ElementNotFoundException e) {
//			assertEquals(1,1);
//		} catch(Exception e) {
//			assertEquals(1,0);
//		}
		
	}
	
	@Test
	public void testFindOrganization() throws RemoteException, InterruptWithExistedElementException, ElementNotFoundException{
		StaffOrganizationManagementData data = initService();
		
//		assertEquals(1,data.findOrganization(new MockOrganizationPO(null, null, "仙林营业厅", null)).size());
//		assertEquals(1,data.findOrganization(new MockOrganizationPO(null, "0251000",null , null)).size());
//		
//		try {
//			data.findOrganization(new MockOrganizationPO(null, null, "鼓楼营业厅", null));
//		} catch(ElementNotFoundException e) {
//			assertEquals(1,1);
//		} catch(Exception e) {
//			assertEquals(1,0);
//		}
	}
	
	@Test
	public void testFindAllStaff() throws RemoteException, InterruptWithExistedElementException{
		StaffOrganizationManagementData data = initService();
		
//		assertEquals(true,data.getAllStaff().size()>=3);
	}
	
	@Test
	public void testFindAllOrganization() throws RemoteException, InterruptWithExistedElementException{
		StaffOrganizationManagementData data = initService();
		
//		assertEquals(true,data.getAllOrganizations().size()>=1);
	}
}
