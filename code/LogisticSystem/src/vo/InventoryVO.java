package vo;

import java.util.ArrayList;

public class InventoryVO {
	
    /**
     * 出库数量
     */
	public String outNum;
	
	/**
	 * 入库数量
	 */
	public String inNum;
	
	/**
	 * 时间段内货物金额
	 */
	public String money;
	
	/**
	 * 货物位置信息
	 */
	public ArrayList<String> place;
	
	/**
	 * 构造方法
	 * @param outNum
	 * @param inNum
	 * @param money
	 * @param place
	 */
	public InventoryVO(String outNum, String inNum,String money,ArrayList<String> place){
		this.outNum = outNum;
		this.inNum = inNum;
		this.money = money;
		this.place =place;
		
	}
	
	
	

}
