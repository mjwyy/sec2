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
import util.chart.CostAndProfitContent;
import util.chart.IncomeContent;
import util.chart.PaymentContent;
import util.enums.ChartType;
import vo.BusinessStateChartVO;
import vo.ChartVO;
import vo.CostAndProfitChartVO;

import java.io.FileOutputStream;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 */
public class ChartOutput extends ChartOutputImpl implements ChartOutputBLService {

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
            Date today = new Date();
            Date startDay = dateFormat.parse(time1);
            Date endDay = dateFormat.parse(time2);
            if(!startDay.before(endDay))
                return new ResultMsg(false,"起点日期不能在终点日期之后!");
            if(!endDay.before(today))
                return new ResultMsg(false,"终点日期不能在未来,请输入过去某一时间");
        } catch (ParseException e) {
            e.printStackTrace();
            return new ResultMsg(false,"日期格式错误!");
        }
        return result;
    }

    @Override
    public ChartVO getChartVO(ChartType chartType, String time1, String time2) {
        try {
            if (chartType == ChartType.BUSINESS_STAT_CHART){
                this.businessStatePO = dataService.getBusinessStateChart(
                        new BusinessStateChartPO(time1,time2));
                this.businessStateVO = businessStatePO.toVO();
                return businessStateVO;
            }
            else{
                this.costAndProfitPO = dataService.getCostAndProfitChart(
                        new CostAndProfitChartPO(time1,time2));
                this.costAndProfitVO = costAndProfitPO.toVO();
                return costAndProfitVO;
            }
        } catch (RemoteException e) {
            e.printStackTrace();
            return new ChartVO(chartType,time1,time2);
        }
    }

    @Override
    /**
     * 根据ChartVO向用户指定位置导出xls表格
     */
    public ResultMsg exportChart(ChartVO chartVO, String path) {
        // 创建一个webbook,对应一个Excel文件
        HSSFWorkbook workbook = new HSSFWorkbook();

        // 设置经营情况表内容
        if(chartVO.getType() == ChartType.BUSINESS_STAT_CHART){
            BusinessStateChartVO businessStateChartVO = (BusinessStateChartVO)chartVO;
            ArrayList<BusinessStateContent> contents = businessStateChartVO.getContents();
            ArrayList<IncomeContent> incomeContents = new ArrayList<>();
            ArrayList<PaymentContent> paymentContents = new ArrayList<>();
            // 分别获取收款单与付款单内容
            for(BusinessStateContent stateContent : contents){
                if(stateContent.getType() == 1)
                    paymentContents.add((PaymentContent) stateContent);
                else
                    incomeContents.add((IncomeContent) stateContent);
            }
            // 创建收款单与付款单sheet
            this.creatIncomeSheet(workbook, incomeContents);
            this.creatPaymentSheet(workbook, paymentContents);

        // 设置成本收益表内容
        }else{
            CostAndProfitChartVO costAndProfitChartVO = (CostAndProfitChartVO) chartVO;
            ArrayList<CostAndProfitContent> costAndProfitContents = costAndProfitChartVO.getCostAndProfitContents();
            // 创建成本收益sheet
            this.creatCostAndProfitSheet(workbook, costAndProfitContents);
        }

        String formType = chartVO.getType().toString();
        String formTime = chartVO.getStartTime() + "至" + chartVO.getEndTime();
        String fileName = formType + ":" + formTime + ".xls";
        String exportPath = path + fileName;
        // 将表格导出至本地目录
        return this.exportWorkBook(workbook,exportPath);
    }


    /**
     * 在表格中添加收款单信息sheet
     *
     * @param workbook xls表格Workbook
     * @param incomeContents 收款单信息
     *
     * @see org.apache.poi.hssf.usermodel
     */
    private void creatIncomeSheet(HSSFWorkbook workbook, ArrayList<IncomeContent> incomeContents){
        // 在Excel文件中添加sheet,显示所有收款单信息
        HSSFSheet sheet = workbook.createSheet("收款单");
        HSSFCellStyle style = this.creatCenterCellStyle(workbook);
        // 在sheet中添加表头(第0行)
        String[] columnNames = {"日期", "收款流水号", "金额", "收款账户", "付款人", "收款机构", "收款人员"};
        this.creatSheetHeader(sheet,columnNames,style);
        // 创建所有收款单每一列的信息
        HSSFRow row;
        for(int i = 0; i < incomeContents.size(); i++){
            IncomeContent incomeContent = incomeContents.get(i);
            row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(incomeContent.getDate());
            row.createCell(1).setCellValue(incomeContent.getId());
            row.createCell(2).setCellValue(incomeContent.getMoney());
            row.createCell(3).setCellValue(incomeContent.getAccount());
            row.createCell(4).setCellValue(incomeContent.getPayer());
            row.createCell(5).setCellValue(incomeContent.getReceiveOrg());
            row.createCell(6).setCellValue(incomeContent.getReceiveStaff());
        }
    }

    /**
     * 在表格中添加付款单信息sheet
     *
     * @param workbook xls表格Workbook
     * @param paymentContents 收款单信息
     *
     * @see org.apache.poi.hssf.usermodel
     */
    private void creatPaymentSheet(HSSFWorkbook workbook, ArrayList<PaymentContent> paymentContents){
        // 在Excel文件中添加sheet,显示所有付款单信息
        HSSFSheet sheet = workbook.createSheet("付款单");
        HSSFCellStyle style = this.creatCenterCellStyle(workbook);
        // 在sheet中添加表头(第0行)
        String[] columnNames = {"日期", "付款流水号", "金额", "付款账户", "付款人", "备注", "支出类型"};
        this.creatSheetHeader(sheet,columnNames,style);
        // 创建所有收款单每一列的信息
        HSSFRow row;
        for(int i = 0; i < paymentContents.size(); i++){
            PaymentContent paymentContent = paymentContents.get(i);
            row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(paymentContent.getDate());
            row.createCell(1).setCellValue(paymentContent.getId());
            row.createCell(2).setCellValue(paymentContent.getMoney());
            row.createCell(3).setCellValue(paymentContent.getAccount());
            row.createCell(4).setCellValue(paymentContent.getPayer());
            row.createCell(5).setCellValue(paymentContent.getComment());
            row.createCell(6).setCellValue(paymentContent.getPayType());
        }
    }

    /**
     * 成本收益表中添加信息sheet
     *
     * @param workbook xls表格Workbook
     * @param costAndProfitContents 收款单信息
     *
     * @see org.apache.poi.hssf.usermodel
     */
    private void creatCostAndProfitSheet(HSSFWorkbook workbook,
                                         ArrayList<CostAndProfitContent> costAndProfitContents) {
        // 在Excel文件中添加sheet,显示所有成本收益表信息
        HSSFSheet sheet = workbook.createSheet("成本收益表");
        HSSFCellStyle style = this.creatCenterCellStyle(workbook);
        // 在sheet中添加表头(第0行)
        String[] columnNames = {"日期", "收入", "支出", "利润"};
        this.creatSheetHeader(sheet,columnNames,style);
        // 汇总日期内所有的信息
        double allIncome = 0;
        double allCost = 0;
        double allProfit;
        // 创建所有收款单每一列的信息
        HSSFRow row;
        for(int i = 0; i < costAndProfitContents.size(); i++){
            CostAndProfitContent content = costAndProfitContents.get(i);
            row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(content.getDate());
            row.createCell(1).setCellValue(content.getIncome());
            row.createCell(2).setCellValue(content.getCost());
            row.createCell(3).setCellValue(content.getProfit());
            allIncome += content.getIncome();
            allCost += content.getCost();
        }
        allProfit = allIncome - allCost;
        // 输出日期内汇总信息
        row = sheet.createRow(costAndProfitContents.size()+1);
        row.createCell(0).setCellValue("总计");
        row.createCell(1).setCellValue(allIncome);
        row.createCell(2).setCellValue(allCost);
        row.createCell(3).setCellValue(allProfit);
    }


}
