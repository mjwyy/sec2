package businesslogic.commodity;

import connection.RemoteObjectGetter;
import dataservice.commoditydataservice.StorageOutDataService;
import businesslogicservice.commodityblservice.StorageOutBLService;
import util.ResultMsg;
import vo.StorageOutVO;

/**
 * Created by kylin on 15/11/17.
 */
public class StorageOut implements StorageOutBLService {
	
	StorageOutDataService dataService = null;
	
	public StorageOut() {
		RemoteObjectGetter getter = new RemoteObjectGetter();
		dataService = (StorageOutDataService) getter.getObjectByName("StorageOutDataService");
	}
	
    @Override
    public ResultMsg addStorageOutDoc(StorageOutVO storageOutVo) {
    	ResultMsg msg = storageOutVo.checkFormat();
        if(msg.isPass()) {
        	return submitStorageOutDoc(storageOutVo);
        } else {
        	return msg;
        }
    }

    @Override
    public ResultMsg submitStorageOutDoc(StorageOutVO storageOutVo) {
        return null;
    }
}
