package data.commoditydata;

import static junit.framework.TestCase.assertEquals;

import java.rmi.RemoteException;

import data.commoditydata.mock_object.MockStorageInPO;
import data.commoditydata.mock_object.MockStorageOutPO;

public class StorageOutData_Test {

	public static void main(String[] args) throws RemoteException {
		StorageOutData sod = new StorageOutData();
		
		MockStorageOutPO[] m = new MockStorageOutPO[8];
		for(int i=0;i<7;i++) {
			m[i] = new MockStorageOutPO(null, null, null, null, null, false);
			sod.insert(m[i]);
		}
		m[7] = new MockStorageOutPO(null, null, null, null, null, false);

		assertEquals(true,sod.delete(m[0]));
		assertEquals(false,sod.delete(m[7]));
		
		assertEquals(m[3], sod.find(m[3]).get(0));
		assertEquals(null,sod.find(m[7]).get(0));

	}
}
