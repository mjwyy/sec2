package businesslogic.statistic;

import businesslogicservice.statisticblservice.ChartOutputBLService;
import connection.RemoteObjectGetter;
import dataservice.statisticdataservice.ChartOutputDataService;
import org.apache.poi.hssf.usermodel.*;
import po.chart.BusinessStateChartPO;
import po.chart.CostAndProfitChartPO;
import util.FormatCheck;
import util.ResultMsg;
import util.chart.BusinessStateContent;
import util.chart.IncomeContent;
import util.chart.PaymentContent;
import util.enums.ChartType;
import vo.BusinessStateChartVO;
import vo.ChartVO;
import vo.CostAndProfitChartVO;

import java.io.FileOutputStream;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by kylin on 15/11/17.
 */
public class ChartOutput implements ChartOutputBLService {

    private ChartOutputDataService dataService;

    private BusinessStateChartVO businessStateVO;
    private BusinessStateChartPO businessStatePO;

    private CostAndProfitChartVO costAndProfitVO;
    private CostAndProfitChartPO costAndProfitPO;

    public ChartOutput() {
        RemoteObjectGetter getter = new RemoteObjectGetter();
        this.dataService =
                (ChartOutputDataService)getter.getObjectByName("ChartOutputDataService");
    }

    @Override
    public ResultMsg enquiryChart(ChartType chartType, String time1, String time2) {
        ResultMsg result = new ResultMsg(true);
        ResultMsg results[] = new ResultMsg[2];
        results[0] = FormatCheck.isDate(time1);
        results[1] = FormatCheck.isDate(time2);
        for(int i = 0; i<results.length; i++){
            if(!results[i].isPass())
                return results[i];
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date startDay = dateFormat.parse(time1);
            Date endDay = dateFormat.parse(time2);
            if(startDay.before(endDay))
                return new ResultMsg(false,"起点日期不能在终点日期之后!");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(result.isPass()){
            this.getChartVO(chartType,time1,time2);
        }
        return result;
    }

    @Override
    public ChartVO getChartVO(ChartType chartType, String time1, String time2) {
        try {
            if (chartType == ChartType.BUSINESS_STAT_CHART){
                businessStatePO = dataService.getBusinessStateChart(
                        new BusinessStateChartPO(time1,time2));
                businessStateVO = businessStatePO.toVO();
                return businessStateVO;
            }
            else{
                costAndProfitPO = dataService.getCostAndProfitChart(
                        new CostAndProfitChartPO(time1,time2));
                costAndProfitVO = costAndProfitVO.toVO();
                return costAndProfitVO;
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultMsg exportChart(ChartVO chartVO, String path) {
        // 创建一个webbook，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();

        // 在webbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheetOne = wb.createSheet(chartVO.getType().toString());

        // 在sheet中添加表头第0行
        HSSFRow row = sheetOne.createRow(0);

        // 创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        ArrayList<String> everyDay = chartVO.getEveryday();

        // 经营情况表
        if(chartVO.getType() == ChartType.BUSINESS_STAT_CHART){
            BusinessStateChartVO vo = (BusinessStateChartVO)chartVO;
            ArrayList<BusinessStateContent> contents = vo.getContents();
            ArrayList<IncomeContent> incomeContents = new ArrayList<>();
            ArrayList<PaymentContent> paymentContents = new ArrayList<>();

            // 区分收款单与付款单
            for(BusinessStateContent stateContent : contents){
                if(stateContent.getType() == 1)
                    paymentContents.add((PaymentContent) stateContent);
                else
                    incomeContents.add((IncomeContent) stateContent);
            }

            // sheet1显示所有收款单信息
            // 创建单元格，并设置值
            HSSFCell cell = row.createCell(0);
            cell.setCellValue("日期");
            cell.setCellStyle(style);

            cell = row.createCell(1);
            cell.setCellValue("收款流水号");
            cell.setCellStyle(style);

            cell = row.createCell(2);
            cell.setCellValue("金额");
            cell.setCellStyle(style);

            cell = row.createCell(3);
            cell.setCellValue("收款账户");
            cell.setCellStyle(style);

            cell = row.createCell(4);
            cell.setCellValue("付款人");
            cell.setCellStyle(style);

            cell = row.createCell(5);
            cell.setCellValue("收款机构");
            cell.setCellStyle(style);

            cell = row.createCell(6);
            cell.setCellValue("收款人员");
            cell.setCellStyle(style);

            for(int i = 0;i < incomeContents.size();i++){
                IncomeContent incomeContent = incomeContents.get(i);
                row = sheetOne.createRow(i + 1);
                row.createCell(0).setCellValue(incomeContent.getDate());
                row.createCell(1).setCellValue(incomeContent.getId());
                row.createCell(2).setCellValue(incomeContent.getMoney());
                row.createCell(3).setCellValue(incomeContent.getAccount());
                row.createCell(4).setCellValue(incomeContent.getPayer());
                row.createCell(5).setCellValue(incomeContent.getReceiveOrg());
                row.createCell(6).setCellValue(incomeContent.getReceiveStaff());
            }

            // sheet2显示所有付款单信息
            // 在webbook中添加一个sheet,对应Excel文件中的sheet
            HSSFSheet sheetTwo = wb.createSheet("付款单");

            // 在sheet中添加表头第0行
            HSSFRow row2 = sheetTwo.createRow(0);

            cell = row2.createCell(0);
            cell.setCellValue("日期");
            cell.setCellStyle(style);

            cell = row2.createCell(1);
            cell.setCellValue("付款流水号");
            cell.setCellStyle(style);

            cell = row2.createCell(2);
            cell.setCellValue("金额");
            cell.setCellStyle(style);

            cell = row2.createCell(3);
            cell.setCellValue("付款账户");
            cell.setCellStyle(style);

            cell = row2.createCell(4);
            cell.setCellValue("付款人");
            cell.setCellStyle(style);

            cell = row2.createCell(5);
            cell.setCellValue("备注");
            cell.setCellStyle(style);

            cell = row2.createCell(6);
            cell.setCellValue("支出类型");
            cell.setCellStyle(style);

            for(int i = 0;i < paymentContents.size();i++){
                PaymentContent paymentContent = paymentContents.get(i);
                row2 = sheetTwo.createRow(i + 1);
                row2.createCell(0).setCellValue(paymentContent.getDate());
                row2.createCell(1).setCellValue(paymentContent.getId());
                row2.createCell(2).setCellValue(paymentContent.getMoney());
                row2.createCell(3).setCellValue(paymentContent.getAccount());
                row2.createCell(4).setCellValue(paymentContent.getPayer());
                row2.createCell(5).setCellValue(paymentContent.getComment());
                row2.createCell(6).setCellValue(paymentContent.getPayType());
            }

            // 成本收益表
        }else{

        }
        // 第六步，将文件存到指定位置
        try {
            FileOutputStream fout = new FileOutputStream(path + chartVO.getType().toString() + " "
                    + chartVO.getStartTime()+"至"+ chartVO.getEndTime() + ".xls");
            wb.write(fout);
            fout.close();
            return new ResultMsg(true,"已导出EXCEL表格!");
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(false,"无法导出EXCEL表格!");
        }

    }

}
