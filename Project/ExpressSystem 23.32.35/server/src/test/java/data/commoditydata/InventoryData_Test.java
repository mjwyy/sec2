package data.commoditydata;


import static junit.framework.TestCase.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import data.commoditydata.mock_object.MockInventoryPO;
import po.InventoryPO;

public class InventoryData_Test {
	
	@Test
	public static void main(String[] args) throws RemoteException { // Hard to use junit test.
		InventoryData id = new InventoryData();
		
		ArrayList<InventoryPO> list = id.findByTime("2015-06-07", "2015-11-15");
		for(InventoryPO po:list) {
			System.out.println("Time:"+((MockInventoryPO) po).getTime());
		}

		list = id.findAll();
		for(InventoryPO po:list) {
			System.out.println("Time:"+((MockInventoryPO) po).getTime());
		}
		
	}

}
