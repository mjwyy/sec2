package data.statisticdata.param;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import util.enums.NoteType;

/**
 * @author River
 * 单据审批业务逻辑所使用的SQL表格参数
 */
public class NoteApproveChartData {

	/*
	 * 此Map的key为存储各单据的数据表名称；
	 * 作为value的内层Map为存储所有对应数据表内需要填写在单据信息里的列，
	 * 其中内层Map的key为列的名称，value为应该翻译成的中文列名。
	 */
	private static Map<String,Map<String,String>> chartData = null;

    /*
     * 此Map的key为存储各单据的数据表名称
     * value是单据的类型
     */
    private static Map<String,NoteType> type = null;

	static {
		chartData = new HashMap<String, Map<String,String>>();
		type = new HashMap<>();
		
		Map<String,String> temp = new TreeMap<>();
		
		//入库单
		temp.put("date", "入库日期");
		temp.put("warehouseID", "仓库号");
		chartData.put("StorageInNote", temp);
		type.put("StorageInNote", NoteType.STORAGE_IN);
		
		//实例：出库单
		
		temp = new TreeMap<>();
		
		temp.put("date", "日期");
		temp.put("warehouseID", "仓库号");
		temp.put("destination", "目的地");
		
		chartData.put("StorageOutNote", temp);
		type.put("StorageOutNote", NoteType.STORAGE_OUT);
		
		//实例：营业厅收款单
		
		temp = new TreeMap<>();
		
		
		
		chartData.put("CreditNotes", temp);
		type.put("CreditNotes", NoteType.CREDIT_NOTE);
		
		//新的一种单据
		//记得要先新建Map
		temp = new TreeMap<>();
		//TODO 更多单据信息
	}
	
	/**
	 * 获取单据的数据表名称
	 * @return 能访问所有的数据表名称的迭代器
	 */
	public static Iterator<String> getCharts() {
		return chartData.keySet().iterator();
	}
	
	/**
	 * 获取一个数据表（存储的单据）所有需要输出的列
	 * @param chartName 数据表名称
	 * @return 能访问所有（需要输出的）列名称的迭代器
	 */
	public static Iterator<String> getColumns(String chartName) {
		return chartData.get(chartName).keySet().iterator();
	}
	
	/**
	 * 获取一个数据列的中文翻译
	 * @param chartName 数据表名称
	 * @param columnName 表内列名称
	 * @return 此列的中文翻译
	 */
	public static String getChineseColumnName(String chartName,String columnName) {
		return chartData.get(chartName).get(columnName);
	}
	
	
	public static NoteType getNoteType (String chartName) {
		return type.get(chartData);
	}
	
	public static String getChartName (NoteType noteType) {
		String result = null;
		Iterator<String> it = type.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next();
			if(type.get(key).equals(noteType)) {
				result = key;
				break;
			}
		}
		return result;
	}
}