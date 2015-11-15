package data.commoditydata;
import static junit.framework.TestCase.assertEquals;

import java.rmi.RemoteException;

import org.junit.Test;

import data.commoditydata.mock_object.MockStorageInPO;
public class StorageInData_Test {
	@Test
	public static void main(String[] args) throws RemoteException {
		StorageInData sid = new StorageInData();
		
		MockStorageInPO[] m = new MockStorageInPO[8];
		for(int i=0;i<7;i++) {
			m[i] = new MockStorageInPO(null, null);
			sid.insert(m[i]);
		}
		m[7] = new MockStorageInPO(null, null);

		assertEquals(true,sid.delete(m[0]));
		assertEquals(false,sid.delete(m[7]));
		
		assertEquals(m[3], sid.find(m[3]).get(0));
		assertEquals(null,sid.find(m[7]).get(0));
		
	}

}
