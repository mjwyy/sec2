/**
 * Ӫҵ��װ����
 * @author wqy
 * @date 2015/10/17
 */
package po;

import java.util.ArrayList;

public class LoadNoteOnServicePO {
	private String date;

	/**
	 * ��Ӫҵ�����
	 */
	private String hallNumber;

	/**
	 * ���˱��
	 */
	private String transpotationNumber;

	/**
	 * Ŀ�ĵ�
	 */
	private String Destination;

	/**
	 * ��������
	 */
	private String carNumber;

	/**
	 * ��װԱ��Ϣ
	 */
	private String guardMan;

	/**
	 * Ѻ��Ա��Ϣ
	 */
	private String supercargoMan;

	/**
	 * ����������
	 */
	private ArrayList<String> barcodes;

	public LoadNoteOnServicePO(String date, String hallNumber, String transpotationNumber, String destination,
			String carNumber, String guardMan, String supercargoMan, ArrayList<String> barcodes) {
		super();
		this.date = date;
		this.hallNumber = hallNumber;
		this.transpotationNumber = transpotationNumber;
		Destination = destination;
		this.carNumber = carNumber;
		this.guardMan = guardMan;
		this.supercargoMan = supercargoMan;
		this.barcodes = barcodes;
	}

	public String getDate() {
		return date;
	}

	public String getHallNumber() {
		return hallNumber;
	}

	public String getTranspotationNumber() {
		return transpotationNumber;
	}

	public String getDestination() {
		return Destination;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public String getGuardMan() {
		return guardMan;
	}

	public String getSupercargoMan() {
		return supercargoMan;
	}

	public ArrayList<String> getBarcodes() {
		return barcodes;
	}
	
}
