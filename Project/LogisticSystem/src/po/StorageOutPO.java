/**
 * 出库单信息PO类
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
     * 快递编号
     */
	private String expressCode;
	/**
     * 目的地
     */
	private String destination;
	/**
     * 装运形式
     */
	private String type;
	/**
     * 中转单编号
     */
	private String transferCode;
	/**
	 * 货物信息，包括条形码及其位置信息
	 */


	/**
	 * 构造方法
	 * @param date
	 * @param GoodsInStorageInfo
	 */
	public StorageOutPO(String date,String expressCode,String destination,String type,String transferCode){
		this.date = date;
		this.expressCode = expressCode;
		this.destination = destination;
		this.type = type;
		this.transferCode = transferCode;
	}

	public String getDate() {
		return date;
	}

	public String getExpressCode() {
		return expressCode;
	}

	public String getDestination() {
		return destination;
	}

	public String getType() {
		return type;
	}

	public String getTransferCode() {
		return transferCode;
	}

	

}