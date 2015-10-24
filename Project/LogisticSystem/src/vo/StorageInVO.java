/**
 * 入库单信息VO类
 * @author wwz
 * @data 2015/10/17
 */
package vo;

import java.util.ArrayList;

public class StorageInVO {
	
    /**
     * 日期
     */
	private String date;
	

	
	/**
	 * 货物信息，包括条形码及其位置信息
	 */
	private ArrayList<GoodsVO> GoodsInStorageInfo;
	
	/**
	 * 构造方法
	 * @param date
	 * @param GoodsInStorageInfo
	 */
	public StorageInVO(String date,ArrayList<GoodsVO> GoodsInStorageInfo){
		this.date = date;
		this.GoodsInStorageInfo = GoodsInStorageInfo;
	}

	public String getDate() {
		return date;
	}

	public ArrayList<GoodsVO> getGoodsInStorageInfo() {
		return GoodsInStorageInfo;
	}
}
