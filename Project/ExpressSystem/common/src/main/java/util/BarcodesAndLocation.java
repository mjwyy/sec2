package util;

import java.io.Serializable;

/**
 * Created by kylin on 15/11/25.
 */
public class BarcodesAndLocation implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 2257394993443049595L;

	/**
     * 条形码号
     */
    private String barcode;

    /**
     * 仓库区号
     */
    private String section;

    /**
     * 仓库排号
     */
    private String line;

    /**
     * 仓库架号
     */
    private String row;

    /**
     * 仓库位号
     */
    private String number;

    public BarcodesAndLocation(String barcode, String section, String line, String row, String number) {
        this.barcode = barcode;
        this.section = section;
        this.line = line;
        this.row = row;
        this.number = number;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getSection() {
        return section;
    }

    public String getLine() {
        return line;
    }

    public String getRow() {
        return row;
    }

    public String getNumber() {
        return number;
    }
}
