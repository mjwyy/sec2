package data.statisticdata;
/**
 * @author wwz
 * @date 2015/11/14
 *
 * * * * * * * * * * * * * * * * * * *
    财务人员收款单 IncomeNotes

    date(varchar(32)),收款日期
    id,收款流水
    money(varchar(16)),金额
    account(varchar(16)),收款账户

    payer(varchar(16)),付款人(谁给财务人员钱)

    receiveOrg(varchar(16)),收款机构
    receiveStaff(varchar(8)),收款人员(财务人员)

    isPassed(int),advice(varchar)

 * * * * * * * * * * * * * * * * * * *
    财务人员付款单  PaymentNotes

    date(varchar(32)),付款日期
    id,付款流水
    money(double),金额
    account(varchar(16)),付款账户

    payer(varchar(8)),付款人(财务人员)

    comment(varchar(255)),备注
    type(varchar(16)),支出类型

    submitter(varchar(16)),
    isPassed(int),advice(varchar)
 *
 */
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.database.DatabaseManager;
import po.chart.BusinessStateChartPO;
import po.chart.CostAndProfitChartPO;
import dataservice.statisticdataservice.ChartOutputDataService;
import util.chart.BusinessStateContent;
import util.chart.IncomeContent;
import util.chart.PaymentContent;
import util.chart.CostAndProfitContent;

public class ChartOutputData extends UnicastRemoteObject implements ChartOutputDataService{

    public ChartOutputData() throws RemoteException {
    }

    @Override
	public BusinessStateChartPO getBusinessStateChart(BusinessStateChartPO po)
            throws RemoteException {
        Connection connection = DatabaseManager.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        ArrayList<String> everyDay = po.getEveryDay();
        ArrayList<BusinessStateContent> businessStateContents = new ArrayList<>();

        //从数据库中读取收款单IncomeNotes信息
        for(String date : everyDay){
            String sqlIncomeNote = "select id,money,account,payer,receiveOrg,receiveStaff" +
                    " from IncomeNotes where date = '"+date+"'";
            try {
                statement = connection.prepareStatement(sqlIncomeNote);
                resultSet = statement.executeQuery();
                while (resultSet.next()){
                    String id = resultSet.getString("id");
                    Double money = resultSet.getDouble("money");
                    String account = resultSet.getString("account");
                    String payer = resultSet.getString("payer");
                    String receiveOrg = resultSet.getString("receiveOrg");
                    String receiveStaff = resultSet.getString("receiveStaff");
                    IncomeContent incomeContent = new IncomeContent(date,id,money,account,
                            payer,receiveOrg,receiveStaff);
                    businessStateContents.add(incomeContent);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        //从数据库中读取付款单 PaymentNotes信息
        for(String date : everyDay){
            String sqlIncomeNote = "select id,money,account,payer,comment,type" +
                    " from PaymentNotes where date = '"+date+"'";
            try {
                statement = connection.prepareStatement(sqlIncomeNote);
                resultSet = statement.executeQuery();
                while (resultSet.next()){
                    String id = resultSet.getString("id");
                    Double money = resultSet.getDouble("money");
                    String account = resultSet.getString("account");
                    String payer = resultSet.getString("payer");
                    String comment = resultSet.getString("comment");
                    String type = resultSet.getString("type");
                    PaymentContent paymentContent = new PaymentContent(date, id, money, account,
                            payer, comment, type);
                    businessStateContents.add(paymentContent);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        po.setContents(businessStateContents);
        DatabaseManager.releaseConnection(connection,statement,resultSet);
        return po;
	}

	@Override
	public CostAndProfitChartPO getCostAndProfitChart(CostAndProfitChartPO po)
			throws RemoteException {
        Connection connection = DatabaseManager.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        ArrayList<String> everyDay = po.getEveryDay();
        ArrayList<CostAndProfitContent> costAndProfitContents = new ArrayList<>();

        for(String date : everyDay){
            double income = 0;
            double cost = 0;
            //从数据库中读取收款单与付款单的金额信息
            String sqlIncomeNote = "select money from IncomeNotes where date = '"+date+"'";
            String sqlPaymentNote = "select money from PaymentNotes where date = '"+date+"'";
            try {
                statement = connection.prepareStatement(sqlIncomeNote);
                resultSet = statement.executeQuery();
                while (resultSet.next()){
                    income += resultSet.getDouble("money");
                }
                statement = connection.prepareStatement(sqlPaymentNote);
                resultSet = statement.executeQuery();
                while (resultSet.next()){
                    cost += resultSet.getDouble("money");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            costAndProfitContents.add(new CostAndProfitContent(date,income,cost));
        }

        po.setContents(costAndProfitContents);
        DatabaseManager.releaseConnection(connection,statement,resultSet);
		return po;
	}

	
}
