package data.financedata;

import data.database.DatabaseFactoryMysqlImpl;
import data.database.DatabaseManager;
import data.infodata.inte.BankAccountBalanceAccess;
import data.statisticdata.LogInsHelper;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.FailToPassApprovingException;
import dataservice.financedataservice.PaymentInputDataService;
import po.PaymentPO;
import util.enums.DocState;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by kylin on 15/11/16.
 * 
 * Database dependencies:
 * 
 * 财务人员付款单  PaymentNotes
 * Columns:id(varchar(32)),date(varchar(32)),payer(varchar(8)),account(varchar(16)),money(double),
 *	type(varchar(16)),comment(varchar(255)),submitter(varchar(16)),
 *	isPassed(int),advice(varchar)
 * 
 * 
 */
public class PaymentInputData extends UnicastRemoteObject implements PaymentInputDataService {
	
	private static final long serialVersionUID = 5769958555512055666L;
	
	private BankAccountBalanceAccess bankAccess = null;
	public PaymentInputData() throws RemoteException {
		super();
	}
	
    @Override
    public boolean addPayment(PaymentPO payment, String staffID) throws RemoteException, FailToPassApprovingException {
    	
    	bankAccess = DatabaseFactoryMysqlImpl.getInstance().getBankAccountBalanceAccess();
    	//注意首先检查余额，余额不够直接回去

    	BigDecimal balance = null;
    	BigDecimal needed = payment.getAmountOfMoney();
    	try {
    		double balanceD = bankAccess.getAccountBalance(payment.getAccountNumber());
    		balance = new BigDecimal(balanceD);
       		if(needed.compareTo(balance)>0) { //余额不足
    			throw new RemoteException("银行账户余额仅为"+needed+"元，不足以支付，操作已取消。");
    		}
    	} catch (SQLException e) {
    		LogInsHelper.insertLog("查询银行账户"+payment.getAccountNumber()+"余额时出错");
    		e.printStackTrace();
    		throw new RemoteException("系统数据出现异常，操作失败，请联系管理员。");
    	} catch (ElementNotFoundException e) {
			e.printStackTrace();
			throw new RemoteException("未找到银行账户记录。");
		}
    	
    	/*
    	 * 开始录入付款单
    	 */
    	
    	Connection connection = DatabaseManager.getConnection();
       	/* 
    	 * Dependency:
    	 * 
    	 * 财务人员付款单  PaymentNotes
    	 * Columns:id(varchar(32)),date(varchar(32)),payer(varchar(8)),account(varchar(16)),money(double),
    	 *	type(varchar(16)),comment(varchar(255)),submitter(varchar(16)),
    	 *	isPassed(int),advice(varchar)
    	 */
    	String tempID = ""+System.currentTimeMillis();
    	String sql = "insert into PaymentNotes (id,date,payer,account,money,type,comment,submitter,isPassed) "
    			+ "values (?,?,?,?,?,?,?,?,"+DocState.UNCHECKED+")";
    	PreparedStatement stmt = null; 
    	
    	try {
    		stmt = connection.prepareStatement(sql);
    		
    		stmt.setString(1, tempID);
    		stmt.setString(2, payment.getDate());
    		stmt.setString(3, payment.getNameOfPayer());
    		stmt.setString(4, payment.getAccountNumber());
    		stmt.setString(5, payment.getAmountOfMoney().toString());
    		stmt.setString(6, payment.getType());
    		stmt.setString(7, payment.getComment());
    		stmt.setString(8, staffID);
    		
    		stmt.executeUpdate();
    		DatabaseManager.releaseConnection(null, stmt, null);
    	} catch (SQLException e) {
    		LogInsHelper.insertLog("录入收款单时与数据库交互出错");
    		e.printStackTrace();
    		DatabaseManager.releaseConnection(connection, stmt, null);
    		throw new RemoteException("系统数据出现异常，操作失败，请联系管理员。");
    	}
    	
    	//等待审批
    	
    	DocState state = DocState.UNCHECKED;
    	
    	sql = "select isPassed,advice from PaymentNotes where id='"+tempID+"'";
    	Statement stmt2 = null;
    	ResultSet set = null;
    	String advice = null;
    	
    	try {
    		stmt2 = connection.createStatement();
    	} catch (SQLException e) {
    		LogInsHelper.insertLog("查询银行账户"+payment.getAccountNumber()+"余额时出错");
    		e.printStackTrace();
    		throw new RemoteException("系统数据出现异常，操作失败，请联系管理员。");
    	}
    	
    	while(state==DocState.UNCHECKED) {
    		try {
				set = stmt.executeQuery(sql);
				set.next();
				state = DocState.getDocState(set.getInt("isPassed"));
				advice = set.getString("advice");	
				DatabaseManager.releaseConnection(null, null, set);
			} catch (SQLException e) {
				e.printStackTrace();
				DatabaseManager.releaseConnection(connection, stmt, set);
				return false;
			}
    		try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	}
    	
    	if(state==DocState.FAILED) {
    		throw new FailToPassApprovingException("单据审批不通过，意见为："+advice);
    	}
    	
    	//审批成功通过、修改银行账户余额
    	
    	
    	BigDecimal zero = new BigDecimal(0);
    	BigDecimal variance = zero.subtract(needed);// variance is minus
    	
    	try {
			bankAccess.setAccountBalance(payment.getAccountNumber(), variance.toPlainString());
			LogInsHelper.insertLog("成功添加了收款单："+tempID+",并修改了银行账户："+payment.getAccountNumber());
		} catch (ElementNotFoundException e) {
			e.printStackTrace();
			throw new RemoteException("未找到银行账户记录。");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RemoteException("系统数据出现异常，操作失败，请联系管理员。");
		} finally {
			DatabaseManager.releaseConnection(connection, stmt2, set);
		}
    	
        return true;
    }
}
