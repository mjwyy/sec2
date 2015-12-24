package data.commoditydata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import po.CommodityGoodsPO;
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
 * 出入信息表：InOutInfo(无主键，如果愿意可以加一个自增ID，但没什么用)
 *	Columns:OrderID(VARCHAR(16)),WarehouseID(varchar(20)),isIn(int as boolean,DEFAULT 1),Date(varchar(32)),Destination(varchar(64))
 *	aeraCode(VARCHAR(16)),rowNumber(VARCHAR(16)),frameNumber(VARCHAR(16)),placeNumber(VARCHAR(16))
 */
public class InventoryData extends UnicastRemoteObject implements InventoryDataService {

	private static final long serialVersionUID = -1842346698338232148L;

	public InventoryData() throws RemoteException {
		super();
	}
	
    @Override
    public InventoryPO findByTime(String sTime, String eTime,String staffID) throws RemoteException {
    	String org = null;
    	try {
			org = UserInfoHelper.getOrg(staffID);
			if(org==null) throw new Exception();
		} catch (Exception e) {
			System.out.println("StaffID: "+staffID+" 提供错误或数据库连接异常");
			e.printStackTrace();
		}
    	/*
    	 * 需要填充的内容：
    	 * 总的库存数量
    	 * 出库数量
    	 * 入库数量
    	 * 时间段内货物金额
		 * 所有本仓库内货物信息
    	 */
    	int totalNum = 0;
    	double totalPrice = 0.0;
    	ArrayList<String> barcodes = new ArrayList<>();
    	int totalIn = 0;
    	int totalOut = 0;
    	ArrayList<CommodityGoodsPO> goodsInStore = new ArrayList<>();
    	
    	Connection connection = DatabaseManager.getConnection();
    	String sql = null;
    	Statement stmt = null;
    	try {
			stmt = connection.createStatement();
		} catch (SQLException e) {
			LogInsHelper.insertLog("数据库异常，获取Statement失败");
			e.printStackTrace();
			throw new RemoteException("系统异常，无法获取连接数据，请联系系统管理员");
		}
    	/*
    	 * 1、先获取一下本仓库内货物条形码与金额，计算其总数
    	 */
    	
    	sql = "select barcode,money from goodsorder where (isInStorage=1 AND warehouseID='"+org+"')";
    	ResultSet set1 = null;
    	
    	try {
			set1 = stmt.executeQuery(sql);
			while(set1.next()) {
				totalNum ++;
				totalPrice += set1.getDouble("money");
				barcodes.add(set1.getString("barcode"));
			}
		} catch (SQLException e) {
			LogInsHelper.insertLog("数据库异常，执行查询语句失败");
			e.printStackTrace();
			DatabaseManager.releaseConnection(null, stmt, set1);
			throw new RemoteException("系统异常，暂时无法使用，请联系系统管理员");
		}
    	
    	DatabaseManager.releaseConnection(null, stmt, set1);
    	/*
    	 * 2、查询时间段内入库数量、出库数量，其中查询入库数量时也要填充货物信息
    	 */
    	/*
    	 * 出入信息表：InOutInfo(无主键，如果愿意可以加一个自增ID，但没什么用)
    	 *	Columns:OrderID(VARCHAR(16)),WarehouseID(varchar(20)),isIn(int as boolean,DEFAULT 1),Date(varchar(32)),Destination(varchar(64))
    	 *	aeraCode(VARCHAR(16)),rowNumber(VARCHAR(16)),frameNumber(VARCHAR(16)),placeNumber(VARCHAR(16))
    	 */
    	
    	//先查出库记录，重点在于计数，所以条目是随便选的
    	sql = "select areaCode from InOutInfo where (isIn=0 AND WarehouseID='"+org+"' AND "
    			+ "Date<='"+eTime+"' AND Date>='"+sTime+"')";
    	PreparedStatement stmt1 = null;
		try {
			stmt1 = connection.prepareStatement(sql);
			ResultSet setOut = stmt1.executeQuery();
			while(setOut.next()) {
				totalOut++;
			}
			DatabaseManager.releaseConnection(null, stmt1, setOut);
		} catch (SQLException e) {
			LogInsHelper.insertLog("在查询出库记录时数据库出错");
			e.printStackTrace();
			throw new RemoteException("查询出库记录时出现错误，请联系系统管理员");
		}
    	
		//再查入库记录，重点还是计数
		
		sql = "select areaCode from InOutInfo where (isIn=1 AND WarehouseID='"+org+"' AND "
    			+ "Date<='"+eTime+"' AND Date>='"+sTime+"')";
		try {
			stmt1 = connection.prepareStatement(sql);
			ResultSet setIn = stmt1.executeQuery();
			while(setIn.next()) {
				totalIn++;
			}
			DatabaseManager.releaseConnection(null, stmt1, setIn);
		} catch (SQLException e) {
			LogInsHelper.insertLog("在查询出库记录时数据库出错");
			e.printStackTrace();
			throw new RemoteException("查询出库记录时出现错误，请联系系统管理员");
		}
		
    	//由于库存内的货物不一定是在限定日期里入库的，所以最后要单独查询并填充库存货物信息
    	
		sql = "select * from InOutInfo where (isIn=1 AND WarehouseID='"+org+"' AND "
				+ "OrderID=?)";
		
		try {
			stmt1 = connection.prepareStatement(sql);
			Iterator<String> it = barcodes.iterator();
			while(it.hasNext()) {
				String bar = it.next();
				stmt1.setString(1, bar);
				ResultSet setStore = stmt1.executeQuery();
				if(!setStore.next()) {
					LogInsHelper.insertLog("执行SQL语句时无预期返回条目");
					throw new RemoteException("数据出现故障，请联系系统管理员");
				}
				
				/*
				 * Columns:OrderID(VARCHAR(16)),WarehouseID(varchar(20)),isIn(int as boolean,DEFAULT 1),Date(varchar(32)),Destination(varchar(64))
				 *	aeraCode(VARCHAR(16)),rowNumber(VARCHAR(16)),frameNumber(VARCHAR(16)),placeNumber(VARCHAR(16))
				 */
				String barcode = setStore.getString("OrderID");
				String aeracode = setStore.getString("areaCode");
				String destination = setStore.getString("Destination");
				String rownumber = setStore.getString("rowNumber");
				String framenumber = setStore.getString("frameNumber");
				String placenumber = setStore.getString("placeNumber");
				CommodityGoodsPO po = new CommodityGoodsPO(barcode, aeracode, destination, rownumber, framenumber, placenumber);
				goodsInStore.add(po);
				
				DatabaseManager.releaseConnection(null, null, setStore);
			}
		} catch (SQLException e) {
			LogInsHelper.insertLog("在查询出库记录时数据库出错");
			e.printStackTrace();
			throw new RemoteException("查询出库记录时出现错误，请联系系统管理员");
		}
		
    	DatabaseManager.releaseConnection(connection, null, null);
    	
    	InventoryPO result = new InventoryPO(totalNum, ""+totalOut, 
    			""+totalIn, ""+totalPrice, goodsInStore);
    	LogInsHelper.insertLog("对员工"+staffID+"的库存查询成功生成了InventoryPO对象");
        return result;
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
        Connection connection = DatabaseManager.getConnection();
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
		Connection connection = DatabaseManager.getConnection();
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
