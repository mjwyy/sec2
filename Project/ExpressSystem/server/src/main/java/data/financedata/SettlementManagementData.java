package data.financedata;

import data.database.DatabaseFactoryMysqlImpl;
import data.database.DatabaseManager;
import data.infodata.inte.BankAccountBalanceAccess;
import data.statisticdata.LogInsHelper;
import dataservice.exception.ElementNotFoundException;
import dataservice.financedataservice.SettlementManagementDataService;
import po.BankAccountPO;
import po.IncomeNotePO;
import util.enums.DocState;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by kylin on 15/11/16.
 * 
 * Database dependencies:
 * 
 * 财务人员收款单 IncomeNotes
 * Columns:id(varchar(32)),date(varchar(32)),receiveOrg(varchar(16)),receiveStaff(varchar(8)),
 *	payer(varchar(16)),money(varchar(16)),account(varchar(16)),submitter(varchar(16)),
 *	isPassed(int),advice(varchar)
 * 
 */
public class SettlementManagementData extends UnicastRemoteObject implements SettlementManagementDataService {
	
	private static final long serialVersionUID = -5692094959798049197L;
	
	private static RemoteException sqlEx = new RemoteException("系统数据异常，操作取消，请联系管理员。");
	
	public SettlementManagementData() throws RemoteException {
		super();
	}
	
    @Override
    public boolean addIncomeNote(IncomeNotePO note, String staffID) throws RemoteException {
    	
    	BankAccountBalanceAccess bankAccess =
                DatabaseFactoryMysqlImpl.getInstance().getBankAccountBalanceAccess();
    	//检查钱数是否正常（是否为数字）
    	try {
    		double moneyAmount = Double.parseDouble(note.getMoney());
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw new RemoteException("交款数目输入格式错误，请检查。");
    	}
    	
    	/**
    	 * 日期      收款单位     收款人即财务人员       交款营业厅      金额       银行账户
    	 */
    	/**
    	 * 财务人员收款单 IncomeNotes
    	 * Columns:id(varchar(32)),date(varchar(32)),receiveOrg(varchar(16)),receiveStaff(varchar(8)),
    	 *	payer(varchar(16)),money(varchar(16)),account(varchar(16)),submitter(varchar(16)),
    	 *	isPassed(int),advice(varchar)
    	 */
    	//向IncomeNotes添加一条记录
    	Connection connection = DatabaseManager.getConnection();
    	String tempID = ""+System.currentTimeMillis();
    	String sql = "insert into IncomeNotes (id,date,receiveOrg,receiveStaff,payer,money,"
    			+ "account,submitter,isPassed) values "
    			+ "(?,?,?,?,?,?,?,?,?)";
    	PreparedStatement stmt = null;
    	try {
    		stmt = connection.prepareStatement(sql);
    		setStatementInfo(tempID, note, staffID, stmt);
    		stmt.executeUpdate();
    	} catch (SQLException e) {
    		LogInsHelper.insertLog("系统获取Statement时出错");
    		e.printStackTrace();
    		throw sqlEx;
    	} finally {
    		DatabaseManager.releaseConnection(null, stmt, null);
    	}
    	
    	LogInsHelper.insertLog("已添加财务人员收款单"+tempID+"，待审核");
    	
    	//注意审批、修改银行账户余额
    	//先审批
    	
    	DocState state = DocState.UNCHECKED;
    	Statement stmt2 = null;
    	
    	try {
    		stmt2 = connection.createStatement();
    	} catch (SQLException e) {
    		e.printStackTrace();
    		throw sqlEx;
    	}
    	
    	while(state==DocState.UNCHECKED) {
    		
    		try {
    			state = getNoteState(tempID, stmt2);
    		} catch (SQLException e) {
    			e.printStackTrace();
    			throw sqlEx;
    		}
    		
    		try {
    			Thread.sleep(1000);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
    	}
    	//审批不通过就返回
    	if(state==DocState.FAILED) {
    		
    		String advice = null;
    		try {
    			advice = getAdvice(tempID, stmt2);
    		} catch (SQLException e) {
    			e.printStackTrace();
    			throw sqlEx;
    		}
    		
    		LogInsHelper.insertLog("收款单"+tempID+"未通过审批，消息发送至客户端。");
    		throw new RemoteException("您输入的收款单未通过审批，意见为："+advice);
    	}
    	
    	//通过了审批，就修改银行账户余额
    	
    	try {
    		bankAccess.setAccountBalance(note.getAccount().getNumber(), note.getMoney());
    	} catch (ElementNotFoundException e) {
    		e.printStackTrace();
    		throw new RemoteException("银行账户"+note.getAccount().getNumber()+"不存在，请检查。");
    	} catch (SQLException e) {
    		e.printStackTrace();
    		throw sqlEx;
    	} finally {
    		DatabaseManager.releaseConnection(connection, stmt2, null);
    	}
    	
    	LogInsHelper.insertLog("成功添加收款单："+tempID+"并通过审核");
    	
        return true;
    }

	@Override
	public ArrayList<IncomeNotePO> findAll() throws RemoteException {
		
		//返回所有的信息，因为总部只有一个
		
		Connection connection = DatabaseManager.getConnection();
		String sql = "select * from IncomeNotes";
		Statement stmt = null;
		ResultSet set = null;
		
		ArrayList<IncomeNotePO> result = new ArrayList<>();
		
		try {
			stmt = connection.createStatement();
			set = stmt.executeQuery(sql);
			
			while (set.next()) {
				String time = set.getString("date");
				String receivingOrganization = set.getString("receiveOrg");
				String incomeHandler = set.getString("receiveStaff");
				String incomeSource = set.getString("payer");
				String money = set.getString("money");
				BankAccountPO bankAccountPO = new BankAccountPO(null, set.getString("account"), null);
				
				IncomeNotePO po = new IncomeNotePO(time, receivingOrganization, incomeHandler,
						incomeSource, money, bankAccountPO);
				
				result.add(po);
			}
			
		} catch (SQLException e) {
			LogInsHelper.insertLog("由connection获取Statement失败");
			e.printStackTrace();
			throw new RemoteException("系统数据异常，操作取消，请联系系统管理员。");
		}
		
		LogInsHelper.insertLog("成功提取所有财务收款单信息");
		
		return result;
	}
	
	private void setStatementInfo (String tempID,IncomeNotePO note, String staffID,
			PreparedStatement stmt) throws SQLException {
		/*
		String sql = "insert into IncomeNotes (id,date,receiveOrg,receiveStaff,payer,money,"
		    			+ "account,submitter,isPassed) values "
		    			+ "(?,?,?,?,?,?,?,?,?)";
		 */
		stmt.setString(1, tempID);
		stmt.setString(2, note.getTime());
		stmt.setString(3, note.getReceivingOrganization());
		stmt.setString(4, note.getIncomeHandler());
		stmt.setString(5, note.getIncomeSource());
		stmt.setString(6, note.getMoney());
		stmt.setString(7, note.getAccount().getNumber());
		stmt.setString(8, staffID);
		
		stmt.setInt(9, DocState.UNCHECKED.getIntState());
	}
	
	private DocState getNoteState(String tempID,Statement stmt) throws SQLException {
		
		String sql = "select isPassed from IncomeNotes where id='"+tempID+"'";
		ResultSet set = null;
		set = stmt.executeQuery(sql);
		
		set.next();
		DocState result = DocState.getDocState(set.getInt("isPassed"));
		
		DatabaseManager.releaseConnection(null, null, set);
		
		return result;
	}
	
	private String getAdvice(String tempID,Statement stmt) throws SQLException {
		
		String sql = "select advice from IncomeNotes where id='"+tempID+"'";
		ResultSet set = null;
		set = stmt.executeQuery(sql);
		
		set.next();
		String result = set.getString("advice");

		DatabaseManager.releaseConnection(null, null, set);
		
		return result;
	}
}
