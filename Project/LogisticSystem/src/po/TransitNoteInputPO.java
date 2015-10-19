/**
 * ������ת��
 * @author wqy
 * @date 2015/10/17
 */
package po;

import java.util.ArrayList;

public class TransitNoteInputPO {
	/**
	 * װ������
	 */
	private String date;

	/**
	 * ��ת�����	
	 */
	private String transitDocNumber;

	/**
	 * �����	
	 */
	private String flightNumber;

	/**
	 * ������
	 */
	private String departurePlace;

	/**
	 * �����
	 */
	private String desitination;

	/**
	 * �����
	 */
	private String containerNumber;

	/**
	 * ��װԱ
	 */
	private String supercargoMan;

	/**
	 * װ���������˵���
	 */
	private ArrayList<String> barcodes;
	
	/**
	 * �˷�
	 */
	private double price;

	public TransitNoteInputPO(String date, String transitDocNumber, String flightNumber, String departurePlace,
			String desitination, String containerNumber, String supercargoMan, ArrayList<String> barcodes) {
		super();
		this.date = date;
		this.transitDocNumber = transitDocNumber;
		this.flightNumber = flightNumber;
		this.departurePlace = departurePlace;
		this.desitination = desitination;
		this.containerNumber = containerNumber;
		this.supercargoMan = supercargoMan;
		this.barcodes = barcodes;
	}

	public String getDate() {
		return date;
	}

	public String getTransitDocNumber() {
		return transitDocNumber;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public String getDeparturePlace() {
		return departurePlace;
	}

	public String getDesitination() {
		return desitination;
	}

	public String getContainerNumber() {
		return containerNumber;
	}

	public String getSupercargoMan() {
		return supercargoMan;
	}

	public ArrayList<String> getBarcodes() {
		return barcodes;
	}

	public double getPrice() {
		return price;
	}
	
	
}
