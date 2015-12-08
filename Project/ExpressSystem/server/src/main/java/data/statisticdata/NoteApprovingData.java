package data.statisticdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import data.database.DatabaseManager;
import data.database.SqlHelper;
import data.statisticdata.param.NoteApproveChartData;
import dataservice.logisticdataservice.*;
import po.*;
import util.ApproveNote;
import util.ResultMsg;
import util.enums.DocState;
import util.enums.NoteType;
import dataservice.exception.ElementNotFoundException;
import dataservice.statisticdataservice.NoteApprovingDataService;

/**
 * @author wwz
 * @date 2015/11/14
 *
 */
public class NoteApprovingData extends UnicastRemoteObject implements NoteApprovingDataService {


	private static final long serialVersionUID = 110929119545388322L;

	private Connection connection = null;
	
    public NoteApprovingData() throws RemoteException {
        super();
    }

	@Override
	public ArrayList<ApproveNote> getNotes() throws RemoteException {
		
		connection = DatabaseManager.getConnection();
		String sql = null;
		
		ArrayList<ApproveNote> result = new ArrayList<>();
		Iterator<String> charts = NoteApproveChartData.getCharts();
		
		while (charts.hasNext()) {
			
			String chartName = charts.next();
			sql = "select * from ? where isPassed="+DocState.UNCHECKED;
			
			try {
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setString(1,chartName);
				ResultSet set = stmt.executeQuery();
				
				Iterator<String> columns = NoteApproveChartData.getColumns(chartName);
				
				while (set.next()) {
					//set??
					String id = set.getString("id");
					String info = generateInfoString(columns, set);
					NoteType type = NoteApproveChartData.getNoteType(chartName);
					result.add(new ApproveNote(id, type, info));
				}
				
			} catch (SQLException e) {
				LogInsHelper.insertLog("系统数据库连接出现异常:"+e.getMessage());
				e.printStackTrace();
				throw new RemoteException("系统数据出现异常，操作失败，请联系管理员。");
			}
			
		}
		
		
		return null;

	}

	@Override
	public ResultMsg pushResults(ArrayList<ApproveNote> results) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 对set的当前指向的条目按照columns进行提取，生成详细信息
	 * @param columns 需要提取的列名
	 * @param set
	 * @return 详细信息（列名为中文的）
	 */
	private String generateInfoString (Iterator<String> columns,ResultSet set) {

		StringBuilder result = new StringBuilder();
		String current = null;
		String chineseName = null;
		while (columns.hasNext()) {
			
			
			
		}
		
		
		return result.toString();
	}


}
