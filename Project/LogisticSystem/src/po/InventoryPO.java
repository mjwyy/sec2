/**
 * ���PO
 * @author wqy
 * @date 2015/10/17
 */
package po;

import java.util.ArrayList;

public class InventoryPO {
	   /**
     * ��������
     */
	public String outNum;
	
	/**
	 * �������
	 */
	public String inNum;
	
	/**
	 * ʱ����ڻ�����
	 */
	public String money;
	
	/**
	 * ����λ����Ϣ
	 */
	public ArrayList<String> place;
	
	/**
	 * ���췽��
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
	
	
}
