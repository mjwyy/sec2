/**
 * ��ⵥ��ϢPO��
 * @author wQY
 * @data 2015/10/17
 */

package po;

import java.util.ArrayList;

public class StorageOutPO {

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
