package businesslogicservice.commodityblservice;

import util.ResultMsg;
import vo.InventoryVO;

public interface StorageMapExportService {
	public ResultMsg exportTo(InventoryVO data,String path);
}
