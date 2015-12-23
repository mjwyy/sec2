package data.financedata;

import data.database.DatabaseManager;
import data.statisticdata.LogInsHelper;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.FailToPassApprovingException;
import dataservice.financedataservice.CreditNoteInputDataService;
import po.CreditNotePO;
import util.enums.DocState;

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
 * 营业厅收款单 CreditNotes
 * Columns: id(varchar(32)),Date(varchar(32)),Money(varchar(16)),
 *	Name(varchar(8)),Submitter(varchar(16)),
 *	isPassed(int),advice(varchar)
 * 
 */
public class CreditNoteInputData extends UnicastRemoteObject implements CreditNoteInputDataService{
	
	private static final long serialVersionUID = 203150499169106219L;
	
	public CreditNoteInputData() throws RemoteException {
		super();
	}
	
    @Override
    public boolean addCreditNote(CreditNotePO note, String staffID) throws RemoteException, FailToPassApprovingException {
    	
    	Connection connection = DatabaseManager.getConnection();
    	
    	/*
    	 * * Database dependencies:
    	 * 
    	 * 营业厅收款单 CreditNotes
    	 * Columns: id(varchar(32)),Date(varchar(32)),Money(varchar(16)),
    	 *	Name(varchar(8)),Submitter(varchar(16)),
    	 *	isPassed(int),advice(varchar)
    	 */
    	String tempID = ""+System.currentTimeMillis();
    	String sql = "insert into CreditNotes (id,Date,Money,Name,Submitter,isPassed) "
    			+ "values (?,?,?,?,?,?)";
    	PreparedStatement stmt = null;
    	
    	try {
    		stmt = connection.prepareStatement(sql);
    		
    		stmt.setString(1, tempID);
    		stmt.setString(2, note.getDate());
    		stmt.setString(3, note.getMoney());
    		stmt.setString(4, note.getNameOfDeliveryMan());
    		stmt.setString(5, staffID);
    		stmt.setInt(6, DocState.UNCHECKED.getIntState());
    		
    		stmt.executeUpdate();
    	} catch (SQLException e) {
    		LogInsHelper.insertLog("录入营业厅收款单时与数据库交互出错");
    		e.printStackTrace();
    		DatabaseManager.releaseConnection(connection, stmt, null);
    		throw new RemoteException("系统数据出现异常，操作失败，请联系管理员。");
    	} finally {
    		DatabaseManager.releaseConnection(null, stmt, null);
    	}
    	
    	//等待审批
    	DocState state = DocState.UNCHECKED;
    	String advice = null;
    	Statement stmt2 = null;
    	ResultSet set = null;
    	sql = "select isPassed,advice from CreditNotes where id='"+tempID+"'";
    	
    	try {
    		stmt2 = connection.createStatement();
    	} catch(SQLException e) {
    		e.printStackTrace();
    		throw new RemoteException("系统数据出现异常，操作失败，请联系管理员。");
    	}
    	
    	while (state==DocState.UNCHECKED) {
    		try {
    			set = stmt2.executeQuery(sql);
    			set.next();
    			state = DocState.getDocState(set.getInt("isPassed"));
    			advice = set.getString("advice");
    		} catch (SQLException e) {
    			e.printStackTrace();
        		throw new RemoteException("系统数据出现异常，操作失败，请联系管理员。");
    		} finally {
    			DatabaseManager.releaseConnection(null, null, set);
    		}
    		
    		try {// Wait one second to allow other threads to run
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	}
    	
    	if(state==DocState.FAILED) {
    		LogInsHelper.insertLog("员工"+staffID+"输入的营业厅收款单未能通过审批："+advice);
    		throw new FailToPassApprovingException("收款单未能通过审批："+advice);
    	}
    	
    	//审批成功！
    	LogInsHelper.insertLog("员工"+staffID+"输入的营业厅收款单"+tempID+"通过审批");
    	
        return true;
    }

	@Override
	public double getOrderMoney(String barcode) throws RemoteException {
		
		Connection connection = DatabaseManager.getConnection();
		
		String sql = "select money from order where barcode='"+barcode+"'";
		double result = 0.0;
		Statement stmt = null;
		ResultSet set = null;
		try {
			stmt = connection.createStatement();
			set = stmt.executeQuery(sql);
			if(!set.next()) throw new ElementNotFoundException();
			result = set.getDouble("money");
		} catch (SQLException e) {
			LogInsHelper.insertLog("获取快件："+barcode+"价格失败");
			e.printStackTrace();
			throw new RemoteException("系统数据出现异常，请联系系统管理员");
		} catch (ElementNotFoundException e) {
			LogInsHelper.insertLog("未能找到快件："+barcode);
			throw new RemoteException("未找到快件"+barcode+"，请检查输入");
		} finally {
			DatabaseManager.releaseConnection(connection, stmt, set);
		}
		
		return result;
	}   
}
