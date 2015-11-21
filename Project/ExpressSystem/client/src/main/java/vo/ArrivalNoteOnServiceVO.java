package vo;

import java.util.ArrayList;

import businesslogic.util.FormatCheck;
import po.ArrivalNoteOnServicePO;
import util.BarcodeAndState;
import util.ResultMsg;

/**
 * 营业厅到达单VO
 * 
 * @author kylin
 *
 */
public class ArrivalNoteOnServiceVO extends NoteVO{
	
	/**
	 * 到达日期
	 */
	private String date;

	/**
	 * 中转单编号（装车单编号）
	 */
	private String TransferNumber;
	
	/**
	 * 出发地
	 */
	private String from;
	
	/**
	 * 条形码与货物状态
	 */
	private ArrayList<BarcodeAndState> BarcodeAndStates;

	public ArrivalNoteOnServiceVO(String date, String transferNumber, String from,
			ArrayList<BarcodeAndState> barcodeAndStates) {
		super();
		this.date = date;
		TransferNumber = transferNumber;
		this.from = from;
		BarcodeAndStates = barcodeAndStates;
	}

	public String getDate() {
		return date;
	}

	public String getTransferNumber() {
		return TransferNumber;
	}

	public String getFrom() {
		return from;
	}

	public ArrayList<BarcodeAndState> getBarcodeAndStates() {
		return BarcodeAndStates;
	}

    @Override
    public ResultMsg checkFormat() {
        ResultMsg result = new ResultMsg(true);
        ResultMsg results[] = new ResultMsg[13];
        results[0] = FormatCheck.isDate(this.date);
        results[1] = FormatCheck.isServiceHallLoadNumber(this.TransferNumber);
        results[2] = FormatCheck.isCity(this.from);
        results[3] = new ResultMsg(true);
        ResultMsg barcodes = new ResultMsg(true);
        for(BarcodeAndState barcodeAndState:this.BarcodeAndStates){
            barcodes = FormatCheck.isBarcode(barcodeAndState.getBarcode());
            if(!barcodes.isPass()){
                results[3] = barcodes;
                break;
            }
        }
        for(int i = 0; i<results.length; i++){
            if(!results[i].isPass()){
                result.setPass(false);
                result.appendMessage(results[i].getMessage()+'\n');
            }
        }
        return result;
    }

    @Override
    public ArrivalNoteOnServicePO toPO() {
        return new ArrivalNoteOnServicePO(this.getDate(),this.getTransferNumber(),
                this.getFrom(),this.getBarcodeAndStates());
    }
}
