package po;

import java.io.Serializable;

public class OrderVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -164650701484223427L;
	
	String barcode = null;
	String stateOfTransport = null;
	String[] historicalRecords = null;
	
	public OrderVO(String barcode, String stateOfTransport,
			String[] historicalRecords) {
		super();
		this.barcode = barcode;
		this.stateOfTransport = stateOfTransport;
		this.historicalRecords = historicalRecords;
	}

	public String getBarcode() {
		return barcode;
	}

	public String getStateOfTransport() {
		return stateOfTransport;
	}

	public String[] getHistoricalRecords() {
		return historicalRecords;
	}
	
	
}
