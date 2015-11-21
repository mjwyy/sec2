package vo;

import businesslogic.util.FormatCheck;
import po.NotePO;
import po.TransitNotePO;
import util.ResultMsg;

import java.util.ArrayList;

/**
 * 中转中心中转单VO
 * 
 * @author kylin
 *
 */
public class TransitNoteOnTransitVO extends NoteVO {

	/**
	 * 装车日期
	 */
	private String date;

	/**
	 * 中转单编号	(唯一标识)
	 */
	private String transitDocNumber;

	/**
	 * 航班号	
	 */
	private String flightNumber;

	/**
	 * 出发地
	 */
	private String departurePlace;

	/**
	 * 到达地
	 */
	private String desitination;

	/**
	 * 货柜号
	 */
	private String containerNumber;

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

    @Override
    public String getUserName() {
        return super.getUserName();
    }

    public TransitNoteOnTransitVO(String date, String transitDocNumber, String flightNumber, String departurePlace,
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

    @Override
    public ResultMsg checkFormat() {
        ResultMsg result = new ResultMsg(true);
        ResultMsg results[] = new ResultMsg[8];
        results[0] = FormatCheck.isDate(this.date);
        results[1] = FormatCheck.isTransitNoteNumber(this.transitDocNumber);
        results[2] = FormatCheck.isFlightNumber(this.flightNumber);
        results[3] = FormatCheck.isCity(this.departurePlace);
        results[4] = FormatCheck.isCity(this.desitination);
        results[5] = FormatCheck.isProperNumber(this.containerNumber);
        results[6] = FormatCheck.isChineseName(this.supercargoMan);
        results[7] = new ResultMsg(true);
        ResultMsg msg;
        for(String barcode:barcodes){
            msg = FormatCheck.isBarcode(barcode);
            if(!msg.isPass()){
                results[7] = msg;
                break;
            }
        }
        for(int i = 0; i<results.length; i++){
            if(!results[i].isPass()){
                return results[i];
            }
        }
        return result;
    }

    @Override
    public TransitNotePO toPO() {
        return new TransitNotePO(this.date, this.transitDocNumber, this.flightNumber,
        this.departurePlace, this.desitination, this.containerNumber, this.supercargoMan, this.barcodes);
    }
}
