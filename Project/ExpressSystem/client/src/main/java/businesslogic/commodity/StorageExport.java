package businesslogic.commodity;

import businesslogic.statistic.ChartOutputImpl;
import businesslogicservice.commodityblservice.StorageMapExportService;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import util.ResultMsg;
import util.TimeHelper;
import vo.CommodityGoodsVO;
import vo.InventoryVO;

import java.util.ArrayList;

/**
 * Created by kylin on 15/12/24.
 */
public class StorageExport extends ChartOutputImpl implements StorageMapExportService{

    @Override
    public ResultMsg exportTo(InventoryVO data, String path) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        this.creatGeneralInfoSheet(workbook,data);
        this.creatExplicitInfoSheet(workbook,data);
        String today = TimeHelper.getDate();
        String formType = today + "库存盘点信息";
        String fileName = formType + ".xls";
        String exportPath = path + fileName;
        // 将表格导出至本地目录
        return this.exportWorkBook(workbook,exportPath);
    }

    /**
     * 创建汇总信息sheet
     * 只有两行,分别对应"出库数量", "入库数量","总金额"
     *
     * @param workbook HSSFWorkbook
     * @param data InventoryVO
     */
    private void creatGeneralInfoSheet (HSSFWorkbook workbook, InventoryVO data){
        HSSFSheet sheet = workbook.createSheet("汇总信息");
        HSSFCellStyle style = this.creatCenterCellStyle(workbook);
        //创建表头第0行
        String[] columnNames = {"出库数量", "入库数量","总金额"};
        this.creatSheetHeader(sheet,columnNames,style);
        //创建第一行的信息
        HSSFRow row = sheet.createRow(1);
        row.createCell(0).setCellValue(data.getOutNum());
        row.createCell(1).setCellValue(data.getInNum());
        row.createCell(2).setCellValue(data.getMoney());
    }


    private void creatExplicitInfoSheet (HSSFWorkbook workbook, InventoryVO data){
        HSSFSheet sheet = workbook.createSheet("详细信息");
        HSSFCellStyle style = this.creatCenterCellStyle(workbook);
        //创建表头第0行
        String[] columnNames = {"条形码","目的地","区号","排号","架号","位号"};
        this.creatSheetHeader(sheet,columnNames,style);
        //创建每一行的具体信息
        HSSFRow row;
        int numOfRows = data.getGoodsInfo().size();
        for(int i = 0; i < numOfRows; i++){
            CommodityGoodsVO goodsVO = data.getGoodsInfo().get(i);
            row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(goodsVO.getBarcode());
            row.createCell(1).setCellValue(goodsVO.getDestination());
            row.createCell(2).setCellValue(goodsVO.getAreacode());
            row.createCell(3).setCellValue(goodsVO.getRownumber());
            row.createCell(4).setCellValue(goodsVO.getFramenumber());
            row.createCell(5).setCellValue(goodsVO.getPlacenumber());
        }
    }

}
