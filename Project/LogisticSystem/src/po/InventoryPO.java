/**
 * 库存PO
 * @author wqy
 * @date 2015/10/17
 */
package po;

import java.util.ArrayList;

public class InventoryPO {
	/**
	 * 总的库存数量
	 */
	private String num;


	/**
	 * 出库数量
	 */
	private String outNum;

	/**
	 * 入库数量
	 */
	private String inNum;

	/**
	 * 时间段内货物金额
	 */
	private String money;

	/**
	 * 货物位置信息
	 */
	private ArrayList<String> place;

	/**
	 * 构造方法
	 * @param outNum
	 * @param inNum
	 * @param money
	 * @param place
	 */
	public InventoryPO(String outNum, String inNum,String money,ArrayList<String> place){
		this.outNum = outNum;
		this.inNum = inNum;
		this.money = money;
		this.place =place;

	}

	public String getOutNum() {
		return outNum;
	}

	public String getInNum() {
		return inNum;
	}

	public String getMoney() {
		return money;
	}

	public ArrayList<String> getPlace() {
		return place;
	}
	public String getNum() {
		return num;
	}

}