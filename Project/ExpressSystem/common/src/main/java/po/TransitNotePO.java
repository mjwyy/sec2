/**
 * 输入中转单
 * @author wqy
 * @date 2015/10/17
 */
package po;

import util.BarcodesAndLocation;
import util.enums.TransitType;
import vo.NoteVO;
import vo.TransitNoteOnTransitVO;

import java.io.Serializable;
import java.util.ArrayList;

public class TransitNotePO extends NotePO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4056108594719181855L;

	/**
	 * 装车日期
	 */
	private String date;

	/**
     * 中转单编号
     */
	private String transitDocNumber;

	/**
     * 航班号,或者火车车次号,或者汽运编号
     */
    private String transportationNumber;

    /**
     * 在两个中转中心之间的三种运输类型
     * 汽车,铁路,飞机
     */
    private TransitType transitType;

	/**
	 * 出发地
	 */
	private String departurePlace;

	/**
	 * 到达地
	 */
	private String desitination;

	/**
	 * 监装员
	 */
	private String supercargoMan;

	/**
     * 装箱所有托运单号,货柜号
     */
    private ArrayList<String> barcodes;

    /**
	 * 运费
	 */
	private double price;

    public TransitNotePO(String date, String transitDocNumber, String flightNumber, TransitType transitType, String departurePlace,
                         String desitination, String supercargoMan, ArrayList<String> barcodes) {
        this.date = date;
        this.transitDocNumber = transitDocNumber;
        this.transportationNumber = flightNumber;
        this.departurePlace = departurePlace;
        this.transitType = transitType;
        this.desitination = desitination;
        this.supercargoMan = supercargoMan;
        this.barcodes = barcodes;
    }

    public TransitType getTransitType() {
        return transitType;
    }

    public void setTransitType(TransitType transitType) {
        this.transitType = transitType;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getDate() {
        return date;
    }

    public String getTransitDocNumber() {
        return transitDocNumber;
    }

    public String getTransportationNumber() {
        return transportationNumber;
    }

    public String getDeparturePlace() {
        return departurePlace;
    }

    public String getDesitination() {
        return desitination;
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

    public void setDate(String date) {
        this.date = date;
    }

    public void setTransitDocNumber(String transitDocNumber) {
        this.transitDocNumber = transitDocNumber;
    }

    public void setTransportationNumber(String transportationNumber) {
        this.transportationNumber = transportationNumber;
    }

    public void setDeparturePlace(String departurePlace) {
        this.departurePlace = departurePlace;
    }

    public void setDesitination(String desitination) {
        this.desitination = desitination;
    }

    public void setSupercargoMan(String supercargoMan) {
        this.supercargoMan = supercargoMan;
    }

    public void setBarcodes(ArrayList<String> barcodes) {
        this.barcodes = barcodes;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public NoteVO toVO() {
        return new TransitNoteOnTransitVO(this.date, this.transitDocNumber, this.transportationNumber, this.transitType,
                this.departurePlace, this.desitination, this.supercargoMan, this.barcodes);
    }

    @Override
    public String getID() {
        return this.transitDocNumber;
    }
}