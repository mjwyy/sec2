package data.statisticdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import data.database.DatabaseManager;
import data.statisticdata.param.NoteApproveChartData;
import util.ApproveNote;
import util.ResultMsg;
import util.enums.DocState;
import util.enums.NoteType;
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
					String id = set.getString("id");
					String info = generateInfoString(chartName, columns, set);
					NoteType type = NoteApproveChartData.getNoteType(chartName);
					result.add(new ApproveNote(id, type, info));
				}
				DatabaseManager.releaseConnection(null,stmt,set);
			} catch (SQLException e) {
				LogInsHelper.insertLog("系统数据库连接出现异常:"+e.getMessage());
				e.printStackTrace();
				throw new RemoteException("系统数据出现异常，操作失败，请联系管理员。");
			}
			
		}
		
		DatabaseManager.releaseConnection(connection, null, null);
		
		return result;

	}

	@Override
	public ResultMsg pushResults(ArrayList<ApproveNote> results) throws RemoteException {

		connection = DatabaseManager.getConnection();
		
		for(ApproveNote note:results) {
			
			String chartName = NoteApproveChartData.getChartName(note.getType());
			String id = note.getId();
			PreparedStatement stmt = null;
			String sql = null;
			
			try {
				if (note.isPass()) {
					sql = "update "+chartName+" set isPassed="+DocState.PASSED.getIntState()+" where id='"+id+"'";
					
				} else {
					String advice = note.getRejectionMessage();
					sql = "update "+chartName+" set isPassed="+DocState.FAILED.getIntState()+","
							+ "advice='"+advice+"' where id='"+id+"'";
				}
				
				stmt = connection.prepareStatement(sql);
				stmt.execute();
			} catch (Exception e) {
				LogInsHelper.insertLog("数据库异常："+e.getMessage());
				e.printStackTrace();
				return new ResultMsg(false,"系统数据出现异常，请联系管理员。");
			}
			
			DatabaseManager.releaseConnection(null, stmt, null);
		}
		
		DatabaseManager.releaseConnection(connection, null, null);
		
		return new ResultMsg(true);
	}

	/**
	 * 对set的当前指向的条目按照columns进行提取，生成详细信息
	 * @param columns 需要提取的列名
	 * @param set
	 * @return 详细信息（列名为中文的）
	 * @throws SQLException 
	 */
	private String generateInfoString (String chartName, Iterator<String> columns,ResultSet set) throws SQLException {

		StringBuilder result = new StringBuilder();
		String current = null;
		String chineseName = null;
		String content = null;
		
		while (columns.hasNext()) {
			current = columns.next();
			chineseName = NoteApproveChartData.getChineseColumnName(chartName, current);
			content = ""+set.getObject(current);
			result.append(chineseName+'：'+content);
			if(columns.hasNext()) {
				result.append('；');
			}
		}
		
		return result.toString();
	}


}
