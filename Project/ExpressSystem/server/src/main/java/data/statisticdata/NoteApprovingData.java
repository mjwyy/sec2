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
 * @author River
 * @date 2015/11/14
 *
 *
 * 单据审批的数据层实现类,依赖SQL系统
 */
public class NoteApprovingData extends UnicastRemoteObject implements NoteApprovingDataService {


	private static final long serialVersionUID = 110929119545388322L;

	private Connection connection = null;

    /**
     * 默认构造器
     * @throws RemoteException
     */
    public NoteApprovingData() throws RemoteException {
        super();
    }

    /**
     * getNotes()实现 依赖NoteApproveChartData提供数据表访问参数
     * @return 所有待审批单据ApproveNote对象(默认为未通过状态),封装于ArrayList
     * @throws RemoteException 包含需要处理的各种错误信息,需要逻辑/界面处理
     */
	@Override
	public ArrayList<ApproveNote> getNotes() throws RemoteException {
		
		connection = DatabaseManager.getConnection();
		String sql = null;

        //待返回的ArrayList
		ArrayList<ApproveNote> result = new ArrayList<>();

        //所有需要遍历检查有无待检查单据的数据表
		Iterator<String> charts = NoteApproveChartData.getCharts();

		while (charts.hasNext()) {//遍历所有数据表
			
			String chartName = charts.next();


			try {

                //SQL语句:查询未审批的单据,获取所有列
                sql = "select * from "+chartName+" where isPassed = "+
                        DocState.UNCHECKED.getIntState();

                //执行语句,获取Set
				PreparedStatement stmt = connection.prepareStatement(sql);

				ResultSet set = stmt.executeQuery();

                //本数据表应使用的列名(只包含有业务价值的列)
				Iterator<String> columns = null;
				
				while (set.next()) {//遍历所有未审批的单据条目

                    String id = set.getString("id");//ID

                    //每次获取新迭代器,因为generateInfoString会用掉迭代器
                    columns = NoteApproveChartData.getColumns(chartName);
					String info = generateInfoString(chartName, columns, set);//单据信息生成

					NoteType type = NoteApproveChartData.getNoteType(chartName);//单据种类

					result.add(new ApproveNote(id, type, info));//加入ArrayList
				}

                //释放数据库资源
				DatabaseManager.releaseConnection(null,stmt,set);
			} catch (SQLException e) {
                //TODO 暂时没有处理SQLException的具体子类,以后可以加一下,返回更具体的错误信息
				LogInsHelper.insertLog("系统数据库连接出现异常:"+e.getMessage());
				e.printStackTrace();
				throw new RemoteException("系统数据出现异常，操作失败，请联系管理员。");
			}
			
		}

        //释放Connection资源
		DatabaseManager.releaseConnection(connection, null, null);
		
		return result;

	}


    /**
     * pushResults()实现,依赖SQL系统
     *
     * @param results 应为之前getNotes获得的单据信息，各个单据应为“通过”或“不通过并填写了审批意见”
     * @return 操作是否成功,失败信息
     * @throws RemoteException
     */
	@Override
	public ResultMsg pushResults(ArrayList<ApproveNote> results) throws RemoteException {

		connection = DatabaseManager.getConnection();
		
		for(ApproveNote note:results) {//遍历List中所有单据
			//由单据种类获取数据表名称
			String chartName = NoteApproveChartData.getChartName(note.getType());

            //获取单据唯一辨识符:ID
			String id = note.getId();
			PreparedStatement stmt = null;
			String sql = null;
			
			try {
                //按照审批结果准备不同的SQL语句
				if (note.isPass()) {
                    //把isPassed设为PASSED
					sql = "update "+chartName+" set isPassed="+DocState.PASSED.getIntState()
                            +" where id='"+id+"'";
				} else {
                    //把isPassed设为FAILED,并添加rejection message
					String advice = note.getRejectionMessage();
					sql = "update "+chartName+" set isPassed="+DocState.FAILED.getIntState()+","
							+ "advice='"+advice+"' where id='"+id+"'";
				}

                //执行语句
				stmt = connection.prepareStatement(sql);
				stmt.execute();
			} catch (Exception e) {
                //TODO 暂时没有处理SQLException具体子类,以后可以处理一下,返回更具体的错误信息
				LogInsHelper.insertLog("数据库异常："+e.getMessage());
				e.printStackTrace();
				return new ResultMsg(false,"系统数据出现异常，请联系管理员。");
			}

			//每次施放Statement资源
			DatabaseManager.releaseConnection(null, stmt, null);
		}

        //释放Connection资源
		DatabaseManager.releaseConnection(connection, null, null);

        //如果安然无恙地执行完了,就是成功了
		return new ResultMsg(true);
	}

	/**
	 * 对set的当前指向的条目按照columns进行提取，生成详细信息
     * 承诺不调用ResultSet的next()方法
     * @param chartName 单据所在数据表名
	 * @param columns 需要提取的列名
	 * @param set set当前指向的条目即为待生成单据
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

            //要调用NoteApproveChartData获取列名的中文翻译
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
