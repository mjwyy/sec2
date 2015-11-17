package businesslogic.commodity;

import businesslogicservice.commodityblservice.StorageInBLService;
import util.ResultMsg;
import util.enums.InventoryStatus;
import vo.StorageInVO;

/**
 * Created by kylin on 15/11/17.
 */
public class StorageIn implements StorageInBLService {
    @Override
    public ResultMsg addPutInStorgaeDoc(StorageInVO putInStorageVo) {
        return null;
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
