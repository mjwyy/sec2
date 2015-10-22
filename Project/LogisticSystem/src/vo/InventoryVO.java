package vo;

import java.util.ArrayList;

public class InventoryVO {
	
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
	private ArrayList<GoodsVO> goodsInfo;
	
	/**
	 * 构造方法
	 * @param outNum
	 * @param inNum
	 * @param money
	 * @param place
	 */
	public InventoryVO(String outNum, String inNum,String money,ArrayList<GoodsVO> goodsInfo){
		this.outNum = outNum;
		this.inNum = inNum;
		this.money = money;
		this.goodsInfo = goodsInfo;
		
	}
	
	
	

}
