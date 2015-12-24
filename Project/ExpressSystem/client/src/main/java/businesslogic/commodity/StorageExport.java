package businesslogic.commodity;

import businesslogicservice.commodityblservice.StorageMapExportService;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import util.ResultMsg;
import vo.InventoryVO;

/**
 * Created by kylin on 15/12/24.
 */
public class StorageExport implements StorageMapExportService{

    @Override
    public ResultMsg exportTo(InventoryVO data, String path) {

        return null;
    }

    public void creatGeneralInfoSheet (HSSFWorkbook workbook, InventoryVO data){
        HSSFSheet sheet = workbook.createSheet("汇总信息");
        
    }

    public void creatExplicitInfoSheet (HSSFWorkbook workbook, InventoryVO data){

    }
}
