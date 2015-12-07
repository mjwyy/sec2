package data.statisticdata.param;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class NoteApproveChartData {

	/*
	 * 此Map的key为存储各单据的数据表名称；
	 * 作为value的内层Map为存储所有对应数据表内需要填写在单据信息里的列，
	 * 其中内层Map的key为列的名称，value为应该翻译成的中文列名。
	 */
	private static Map<String,Map<String,String>> chartData = null;
	
	static {
		chartData = new HashMap<String, Map<String,String>>();
		
		Map<String,String> temp = new TreeMap<>();
		
		//实例：入库单
		temp.put("date", "入库日期");
		temp.put("warehouseID", "仓库号");
		
		chartData.put("StorageInNote", temp);
		
		//新的一种单据
		//记得要先新建Map
		temp = new TreeMap<>();
		//TODO 更多单据信息
	}
	
	/**
	 * 获取单据的数据表名称
	 * @return 能访问所有的数据表名称的迭代器
	 */
	public Iterator<String> getCharts() {
		return chartData.keySet().iterator();
	}
	
	/**
	 * 获取一个数据表（存储的单据）所有需要输出的列
	 * @param chartName 数据表名称
	 * @return 能访问所有（需要输出的）列名称的迭代器
	 */
	public Iterator<String> getColumns(String chartName) {
		return chartData.get(chartName).keySet().iterator();
	}
	
	/**
	 * 获取一个数据列的中文翻译
	 * @param chartName 数据表名称
	 * @param columnName 表内列名称
	 * @return 此列的中文翻译
	 */
	public String getChineseColumnName(String chartName,String columnName) {
		return chartData.get(chartName).get(columnName);
	}
}
