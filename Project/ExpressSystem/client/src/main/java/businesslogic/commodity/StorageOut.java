package businesslogic.commodity;

<<<<<<< HEAD
=======
import po.StorageOutPO;
>>>>>>> master
import connection.RemoteObjectGetter;
import dataservice.commoditydataservice.StorageOutDataService;
import businesslogicservice.commodityblservice.StorageOutBLService;
import util.ResultMsg;
import vo.StorageOutVO;

/**
 * Created by kylin on 15/11/17.
<<<<<<< HEAD
=======
 * 
 * Finished.
>>>>>>> master
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
<<<<<<< HEAD
        return null;
=======
        try {
        	boolean result = dataService.insert((StorageOutPO) storageOutVo.toPO());
        	if(!result) {
        		return new ResultMsg(false,"提交出库单失败，请重试");
        	}
        } catch (Exception e) {
        	return new ResultMsg(false,e.getMessage());
        }
        
        return new ResultMsg(true);
>>>>>>> master
    }
}
