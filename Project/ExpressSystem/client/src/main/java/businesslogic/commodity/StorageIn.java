package businesslogic.commodity;

import connection.RemoteObjectGetter;
import dataservice.commoditydataservice.StorageInDataService;
import businesslogicservice.commodityblservice.StorageInBLService;
import util.ResultMsg;
import util.enums.InventoryStatus;
import vo.StorageInVO;

/**
 * Created by kylin on 15/11/17.
 */
public class StorageIn implements StorageInBLService {
	
	StorageInDataService dataService = null;
	
	ResultMsg alarmingMsg = null;
	boolean isAlarming = false;
	
	public StorageIn() {
		RemoteObjectGetter getter = new RemoteObjectGetter();
		dataService = (StorageInDataService) getter.getObjectByName("StorageInDataService");
	}
	
    @Override
    public ResultMsg addPutInStorgaeDoc(StorageInVO putInStorageVo) {
        ResultMsg msg = putInStorageVo.checkFormat(); // TO DO
        if(msg.isPass()) {
        	return submitPutInStorageDoc(putInStorageVo);
        } else {
        	return msg;
        }
    }

    @Override
    public ResultMsg submitPutInStorageDoc(StorageInVO putInStorageVo) {
        return null;
    }

    @Override
    public InventoryStatus alarm() {
        return null;
    }
}
