package data.commoditydata;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import po.InventoryPO;
import data.database.DatabaseManager;
import data.database.SqlHelper;
import data.infodata.UserInfoHelper;
import data.statisticdata.LogInsHelper;
import data.statisticdata.inte.LogInsertDataService;
import dataservice.commoditydataservice.InventoryDataService;
import dataservice.exception.ElementNotFoundException;

/**
 * 
 * @author River
 *	Database dependencies:
 *
 * 最近查询时间表:RecentInquiryTime
 * Columns:WarehouseID(varchar(20),PRIMARY KEY),Date(varchar(32))
 * 
 */
public class InventoryData implements InventoryDataService {

	private Connection connection;
	
	public InventoryData() {
		super();
	}
	
    @Override
    public InventoryPO findByTime(String sTime, String eTime,String staffID) throws RemoteException {
    	String orgNum = null;
    	try {
			orgNum = UserInfoHelper.getOrg(staffID);
			if(orgNum==null) throw new Exception();
		} catch (Exception e) {
			System.out.println("StaffID: "+staffID+" 提供错误或数据库连接异常:");
			e.printStackTrace();
		}
    	

    	HashMap<String,InventoryPO> poMap = new HashMap<>();
    	
    	
    	ArrayList<InventoryPO> result = new ArrayList<>();

    	
        return null;
    }
    
    @Override
    public InventoryPO findAll(String staffID) throws RemoteException {
    	String recentTime = null;
    	String org = null;
        try {
			org = UserInfoHelper.getOrg(staffID);
			if(org==null) {
				throw new Exception();
			}
		} catch (Exception e) {
			e.printStackTrace();
			LogInsHelper.insertLog("获取职员"+staffID+"机构信息失败");
			throw new RemoteException("获取职员机构信息失败");
		}
        connection = DatabaseManager.getConnection();
    	String sql = "select Date from RecentInquiryTime where WarehouseID='"+org+"'";
    	
    	try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet set = stmt.executeQuery();
			if(!set.next()) {
				throw new RemoteException("缺少上一次盘点记录，请先输入首次盘点时间");
			} else {
				recentTime = set.getString("Date");
			}
		} catch (SQLException e) {
			LogInsHelper.insertLog("数据库异常，无法获取prepared statement");
			e.printStackTrace();
			throw new RemoteException("系统异常，请联系系统管理员");
		}

    	DatabaseManager.releaseConnection(connection, null, null);
    	
    	String nowTime = null;
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    	nowTime = format.format(new Date());
    	
        return findByTime(recentTime, nowTime, staffID);
    }

	@Override
	public boolean setRecentTime(String date, String staffID) throws RemoteException {

		String org = null;
        try {
			org = UserInfoHelper.getOrg(staffID);
			if(org==null) {
				throw new Exception();
			}
		} catch (Exception e) {
			e.printStackTrace();
			LogInsHelper.insertLog("获取职员"+staffID+"机构信息失败");
			throw new RemoteException("获取职员机构信息失败");
		}
        
        //首先检查仓库信息是否存在
		String sql = "select * from RecentInquiryTime where WarehouseID='"+org+"'";
		boolean hasPrev = false;
        try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet set = stmt.executeQuery();
			hasPrev = set.next();
		} catch (SQLException e) {
			LogInsHelper.insertLog("数据库异常，无法获取prepared statement");
			e.printStackTrace();
			throw new RemoteException("系统异常，请联系系统管理员");
		}
        
        if(hasPrev) {
        	sql = "update RecentInquiryTime set Date='"+date+"' where WarehouseID='"+org+"'";
        } else {
        	sql = "insert into RecentInquiryTime (WarehouseID,Date) values ('"+org+"','"+date+"')";
        }
        
        try {
			SqlHelper.excUpdate(sql);
		} catch (SQLException e) {
			LogInsHelper.insertLog("数据库异常，无法执行statement");
			e.printStackTrace();
			throw new RemoteException("系统异常，请联系系统管理员");
		}
        LogInsHelper.insertLog("员工"+staffID+"成功执行查询时间更新");
		return true;
	}
    
    
}
