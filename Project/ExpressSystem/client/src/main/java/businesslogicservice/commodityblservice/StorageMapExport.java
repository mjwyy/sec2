package businesslogicservice.commodityblservice;

import util.ResultMsg;
import vo.InventoryVO;

interface StorageMapExport {
	public ResultMsg exportTo(InventoryVO data,String path);
}
