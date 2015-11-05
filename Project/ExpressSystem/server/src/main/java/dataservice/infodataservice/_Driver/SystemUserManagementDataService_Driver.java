package dataservice.infodataservice._Driver;
/**
 * @author wwz
 * @data 2015/10/22
 *
 */
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataImpl.infodata.SystemUserManagementData;
import dataservice.infodataservice.SystemUserManagementDataService;
import dataservice.infodataservice._Stub.SystemUserManagementDataService_Stub;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import po.UserPO;

public class SystemUserManagementDataService_Driver {
	private UserPO userPO1;
    private UserPO userPO2;
    private UserPO userPO3;
	private ArrayList<UserPO> list = new ArrayList<UserPO>();

	public SystemUserManagementDataService_Driver() {
		userPO1 = new UserPO("test1","test1",1);
		userPO2 = new UserPO("test2","test2",1);
		userPO3 = new UserPO("test3","test3",1);
		list.add(userPO1);
		list.add(userPO2);
		list.add(userPO3);
	}
	
	public void drive(SystemUserManagementDataService sumDataService) throws RemoteException, InterruptWithExistedElementException, ElementNotFoundException {
		if(sumDataService.addUser(userPO1))
			System.out.println("success");
		else
			System.out.println("fail");

        if(sumDataService.addUser(userPO2))
            System.out.println("success");
        else
            System.out.println("fail");

        if(sumDataService.addUser(userPO3))
            System.out.println("success");
        else
            System.out.println("fail");

		if(sumDataService.removeUser(userPO2))
			System.out.println("success");
		else
			System.out.println("fail");
		if(sumDataService.modifyUser(userPO1, userPO3))
			System.out.println("success");
		else
			System.out.println("fail");
		
	}
	
	public static void main(String[] args) throws RemoteException, InterruptWithExistedElementException, ElementNotFoundException {
		SystemUserManagementData userManagementData = new SystemUserManagementData();
		SystemUserManagementDataService_Driver driver = new SystemUserManagementDataService_Driver();
		driver.drive(userManagementData);
	}
	
	

}
