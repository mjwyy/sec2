package vo;

import util.BarcodesAndLocation;
import util.FormatCheck;
import po.NotePO;
import po.TransitNotePO;
import util.ResultMsg;
import util.enums.TransitType;

import java.util.ArrayList;

/**
 * 中转中心中转单VO
 * 
 * @author kylin
 *
 */
public class TransitNoteOnTransitVO extends NoteVO {
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
     * 装箱所有托运单号
     */
    private ArrayList<String> barcodes;

    /**
     * 运费
     */
    private double price;

    public TransitNoteOnTransitVO(String date, String transitDocNumber, String flightNumber, TransitType transitType, String departurePlace,
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
    public NotePO toPO() {
        return new TransitNotePO(this.date, this.transitDocNumber,
                this.transportationNumber, this.transitType,
                this.departurePlace, this.desitination,
                this.supercargoMan, this.barcodes);
    }

    @Override
    public ResultMsg checkFormat() {
        ResultMsg result = new ResultMsg(true);
        ResultMsg results[] = new ResultMsg[8];
        results[0] = FormatCheck.isDate(this.date);
        results[1] = FormatCheck.isTransitNoteNumber(this.transitDocNumber);
        if(this.transitType == TransitType.Aircraft){
            results[2] = FormatCheck.isFlightNumber(this.transportationNumber);
        }else if(this.transitType == TransitType.Car){
            results[2] = FormatCheck.isCenterLoadNumber(this.transportationNumber);
        }else {
            results[2] = FormatCheck.isTrainNumber(this.transportationNumber);
        }
        results[3] = new ResultMsg(true);
        results[4] = FormatCheck.isCity(this.desitination);
        results[5] = FormatCheck.isCity(this.departurePlace);
        results[6] = FormatCheck.isChineseName(this.supercargoMan);
        ResultMsg barcodes;
        results[7] = new ResultMsg(true);
        for(String barcode:this.barcodes){
            barcodes = FormatCheck.isBarcode(barcode);
            if(!barcodes.isPass()){
                results[7] = barcodes;
                break;
            }
        }
        for (ResultMsg result1 : results) {
            if (!result1.isPass()) {
                return result1;
            }
        }
        return result;
    }
}
