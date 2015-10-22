/**
 * 入库单信息PO类
 * @author wQY
 * @data 2015/10/17
 */

package po;

import java.util.ArrayList;

public class StorageOutPO {

    /**
     * 日期
     */
	private String date;
	
	/**
	 * 货物信息，包括条形码及其位置信息
	 */
	private ArrayList<String> GoodsInStorageInfo;
	
	/**
	 * 构造方法
	 * @param date
	 * @param GoodsInStorageInfo
	 */
	public StorageOutPO(String date,ArrayList<String> GoodsInStorageInfo){
		this.date = date;
		this.GoodsInStorageInfo = GoodsInStorageInfo;
	}

	public String getDate() {
		return date;
	}

	public ArrayList<String> getGoodsInStorageInfo() {
		return GoodsInStorageInfo;
	}

}
