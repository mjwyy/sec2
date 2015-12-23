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
        temp.put("date", "日期");
        temp.put("Name", "快递员姓名");
        temp.put("Money", "收款金额");
		chartData.put("CreditNotes", temp);
		type.put("CreditNotes", NoteType.CREDIT_NOTE);
		
		//营业厅到达单
		temp = new TreeMap<>();
        temp.put("date", "日期");
        temp.put("TransferNumber", "到达单号");
        temp.put("arrivalKind", "到达类型");
        temp.put("from", "出发地");
        temp.put("barcodes", "条形码");
        chartData.put("note_arrival_on_service", temp);
        type.put("note_arrival_on_service", NoteType.ARRIVAL_NOTE_ON_SERVICE);

        //营业厅派件单
        temp = new TreeMap<>();
        temp.put("date", "日期");
        temp.put("id", "派件单号");
        temp.put("deliveryMan", "派件员");
        temp.put("barcodes", "条形码");
        chartData.put("note_delivery_on_service", temp);
        type.put("note_delivery_on_service", NoteType.DELIVER_NOTE_ON_SERVICE);

        //中转中心到达单
        temp = new TreeMap<>();
        temp.put("departurePlace", "出发地");
        temp.put("date", "货物到达日期");
        temp.put("transferNumber", "中转单编号");
        temp.put("centerNumber", "中转中心编号");
        chartData.put("note_arrival_on_transit", temp);
        type.put("note_arrival_on_transit", NoteType.ARRIVAL_NOTE_ON_TRANSIT);

        //寄件单
        temp = new TreeMap<>();
        temp.put("name", "货物名称");
        temp.put("barCode", "条形码");
        temp.put("category", "快递种类");
        temp.put("senderAddress", "出发地");
        temp.put("receiverAddress", "目的地");
        chartData.put("note_delivery", temp);
        type.put("note_delivery", NoteType.DELIVERY_NOTE);

        //营业厅装车单
        temp = new TreeMap<>();
        temp.put("date", "日期");
        temp.put("transpotationNumber", "汽运编号");
        temp.put("destination", "目的地");
        temp.put("carNumber", "车辆代号");
        temp.put("barcodes", "货物条形码");
        chartData.put("note_load_on_service", temp);
        type.put("note_load_on_service", NoteType.LOAD_NOTE_ON_SERVICE);

        //中转中心装车单
        temp = new TreeMap<>();
        temp.put("date", "日期");
        temp.put("transpotationNumber", "中转中心汽运编号");
        temp.put("destination", "目的地");
        temp.put("carNumber", "车辆代号");
        temp.put("barcodes", "货物条形码");
        chartData.put("note_load_on_transit", temp);
        type.put("note_load_on_transit", NoteType.LOAD_NOTE_ON_TRANSIT);

        //收件单
        temp = new TreeMap<>();
        temp.put("time", "收件时间");
        temp.put("receiveCustomer", "收件人");
        temp.put("barcode", "条形码");
        chartData.put("note_receive_note", temp);
        type.put("note_receive_note", NoteType.RECEIVING_NOTE);

        //中转单
        temp = new TreeMap<>();
        temp.put("transitDocNumber", "中转单编号");
        temp.put("transitType", "运输类型");
        temp.put("transportNumber", "运输工具班次号");
        temp.put("departurePlace", "出发地");
        temp.put("desitination", "到达地");
        temp.put("barcodes", "条形码");
        chartData.put("note_transit", temp);
        type.put("note_transit", NoteType.TRANSIT_NOTE);

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
		return type.get(chartName);
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
