package po;

import java.io.File;
import java.io.Serializable;

public class VehiclePO implements Serializable {



	private static final long serialVersionUID = -843114324702086467L;

	String carNumber = null;
	String hallNumber = null;
	File picture = null;
	
	/*
	 * �ÿ�ʼʹ��ʱ�������ʹ��ʱ��
	 */
	String firstUseTime = null;
	
	public VehiclePO(String carNumber, String hallNumber,
			String firstUseTime) {
		this.carNumber = carNumber;
		this.hallNumber = hallNumber;
		//this.picture = picture;
		this.firstUseTime = firstUseTime;
	}
	

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public String getHallNumber() {
		return hallNumber;
	}

	public void setHallNumber(String hallNumber) {
		this.hallNumber = hallNumber;
	}

	public File getPicture() {
		return picture;
	}

	public void setPicture(File picture) {
		this.picture = picture;
	}

	public String getFirstUseTime() {
		return firstUseTime;
	}

	public void setFirstUseTime(String firstUseTime) {
		this.firstUseTime = firstUseTime;
	}
	
}
