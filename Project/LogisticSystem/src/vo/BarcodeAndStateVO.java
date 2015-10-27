package vo;

import businesslogic.util.GoodsState;

public class BarcodeAndStateVO {

	private String barcode;
	
	private GoodsState state;

	public BarcodeAndStateVO(String barcode, GoodsState state) {
		super();
		this.barcode = barcode;
		this.state = state;
	}

	public String getBarcode() {
		return barcode;
	}

	public GoodsState getState() {
		return state;
	}
	
}
