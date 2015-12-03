package data.financedata;

import data.database.DatabaseManager;
import data.statisticdata.LogInsHelper;
import data.statisticdata.inte.LogInsertDataService;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.FailToPassApprovingException;
import dataservice.financedataservice.CreditNoteInputDataService;
import po.CreditNotePO;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by kylin on 15/11/16.
 */
public class CreditNoteInputData implements CreditNoteInputDataService{
	
	private static final long serialVersionUID = 203150499169106219L;
	
	private Connection connection;
	
	public CreditNoteInputData() {
		super();
	}
	
    @Override
    public boolean addCreditNote(CreditNotePO note, String staffID) throws RemoteException, FailToPassApprovingException {
    	//TODO
    	
        return false;
    }

	@Override
	public double getOrderMoney(String barcode) throws RemoteException {
		
		connection = DatabaseManager.getConnection();
		
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
