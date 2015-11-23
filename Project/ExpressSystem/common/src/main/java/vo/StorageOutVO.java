package vo;

import java.util.ArrayList;

<<<<<<< HEAD:Project/ExpressSystem/common/src/main/java/vo/StorageOutVO.java
=======
import po.StorageOutPO;
>>>>>>> master:Project/ExpressSystem/common/src/main/java/vo/StorageOutVO.java
import util.ResultMsg;

public class StorageOutVO {
	/**
	 * 条形码
	 */
	private ArrayList<String> barcode;
	
	/**
	 * 日期
	 */
	private String date;
	
	/**
	 *目的地 
	 */
	private String destination;
	
	/**
<<<<<<< HEAD:Project/ExpressSystem/common/src/main/java/vo/StorageOutVO.java
	 * 汽运编号
=======
	 * 汽运编号或中转单编号
>>>>>>> master:Project/ExpressSystem/common/src/main/java/vo/StorageOutVO.java
	 */
	private String truckNum;
	
	/**
<<<<<<< HEAD:Project/ExpressSystem/common/src/main/java/vo/StorageOutVO.java
	 * 中转单编号
	 */
	private String transferNum;
	
	/**
=======
>>>>>>> master:Project/ExpressSystem/common/src/main/java/vo/StorageOutVO.java
	 * 装运方式
	 */
	private String shippingForm;
	
	/**
	 * 中转单编号或汽运编号,true为中转单编号，false为汽运编号
	 */
	boolean TransferOrCar;
	
	/**
	 * 构造方法
	 * @param date
	 * @param destination
	 * @param truckNum
	 * @param transferNum
	 * @param shippingForm
	 * @param barcode
	 */
	public StorageOutVO(String date,String destination,String transferNum,String shippingForm,
			ArrayList<String>barcode,boolean TorC){
		this.date = date;
		this.destination = destination;
		this.shippingForm = shippingForm;
		this.barcode = barcode;
<<<<<<< HEAD:Project/ExpressSystem/common/src/main/java/vo/StorageOutVO.java
		if(TorC==true)
			this.transferNum = transferNum;
		else
			this.truckNum = transferNum;
=======
		TransferOrCar = TorC;
		this.truckNum = transferNum;
>>>>>>> master:Project/ExpressSystem/common/src/main/java/vo/StorageOutVO.java
	}

	public String getDate() {
		return date;
	}

	public String getDestination() {
		return destination;
	}

	public String getTruckNum() {
		return truckNum;
	}

<<<<<<< HEAD:Project/ExpressSystem/common/src/main/java/vo/StorageOutVO.java
	public String getTransferNum() {
		return transferNum;
	}

=======
>>>>>>> master:Project/ExpressSystem/common/src/main/java/vo/StorageOutVO.java
	public String getShippingForm() {
		return shippingForm;
	}

	public ArrayList<String> getBarcode() {
		return barcode;
	}

	public boolean isTransferOrCar() {
		return TransferOrCar;
	}

	public ResultMsg checkFormat() {
<<<<<<< HEAD:Project/ExpressSystem/common/src/main/java/vo/StorageOutVO.java
		//TO DO
		
		return null;
		
		
=======
		//TODO 那个双重属性是什么意思？
		
		return null;
	}

	public Object toPO() {
		StorageOutPO po = new StorageOutPO(barcode, date, destination, shippingForm, truckNum, TransferOrCar);
		return po;
>>>>>>> master:Project/ExpressSystem/common/src/main/java/vo/StorageOutVO.java
	}
}
