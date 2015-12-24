package businesslogic.statistic;

import org.apache.poi.hssf.usermodel.*;
import util.ResultMsg;

import java.io.FileOutputStream;

/**
 * Created by kylin on 15/12/24.
 */
public class ChartOutputImpl {

    /**
     * 为一个xls表格创建单元格格式
     *
     * @param workbook 对应于一个xls表格的Workbook
     * @return 居中的单元格格式
     */
    protected HSSFCellStyle creatCenterCellStyle(HSSFWorkbook workbook){
        HSSFCellStyle style = workbook.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        return style;
    }

    /**
     * 根据表头名称与单元格式为一个xls表格sheet创建表头
     *
     * @param sheet 表的一个sheet
     * @param columnNames 表头名称
     * @param style 单元格式
     *
     * @see org.apache.poi.hssf.usermodel
     */
    protected void creatSheetHeader(HSSFSheet sheet, String[] columnNames, HSSFCellStyle style){
        HSSFRow row = sheet.createRow(0);
        HSSFCell cell;
        // 创建表头所有列名
        for (int i = 0; i < columnNames.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(columnNames[i]);
            cell.setCellStyle(style);
        }
    }

    /**
     * 将表格存到指定位置
     *
     * @param workbook 欲导出表格
     * @param path 导出位置
     * @return 导出结果信息
     *
     * @see java.io.FileOutputStream
     */
    protected ResultMsg exportWorkBook(HSSFWorkbook workbook, String path){
        try {
            FileOutputStream fout = new FileOutputStream(path);
            workbook.write(fout);
            fout.close();
            return new ResultMsg(true,"已导出EXCEL表格!");
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(false,"无法导出EXCEL表格!");
        }
    }

}
