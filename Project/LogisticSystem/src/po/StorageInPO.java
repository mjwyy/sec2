/**
 * ��ⵥ��ϢPO��
 * @author WQY
 * @data 2015/10/17
 */
package po;

import java.util.ArrayList;

public class StorageInPO {
	 /**
     * ����
     */
	private String date;
	
	/**
	 * ������Ϣ�����������뼰��λ����Ϣ
	 */
	private ArrayList<String> GoodsInStorageInfo;
	
	/**
	 * ���췽��
	 * @param date
	 * @param GoodsInStorageInfo
	 */
	public StorageInPO(String date,ArrayList<String> GoodsInStorageInfo){
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
