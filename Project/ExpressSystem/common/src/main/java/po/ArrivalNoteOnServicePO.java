
/**
 * 营业厅到达单PO
 * @author wqy
 * @date 2015/10/17
 */
package po;

import java.io.Serializable;
import java.util.ArrayList;

import util.BarcodeAndState;
import vo.ArrivalNoteOnServiceVO;
import vo.NoteVO;

public class ArrivalNoteOnServicePO extends NotePO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7187002330817151504L;

<<<<<<< HEAD
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

	public ArrivalNoteOnServicePO(String date, String transferNumber,
			String from, ArrayList<BarcodeAndState> barcodeAndStates) {
		super();
		this.date = date;
		TransferNumber = transferNumber;
		this.from = from;
		BarcodeAndStates = barcodeAndStates;
	}
=======
    /**
     * 到达日期
     */
    private String date;

    /**
     * 区分中转单编号(true)
     */
    private boolean isTransit;

    /**
     * 中转单编号（装车单编号）(唯一标示符)
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

    public ArrivalNoteOnServicePO(String date, boolean isTransit, String transferNumber,
                                  String from, ArrayList<BarcodeAndState> barcodeAndStates) {
        this.date = date;
        this.isTransit = isTransit;
        this.TransferNumber = transferNumber;
        this.from = from;
        this.BarcodeAndStates = barcodeAndStates;
    }
>>>>>>> master

	public ArrayList<BarcodeAndState> getBarcodeAndStates() {
		return BarcodeAndStates;
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

<<<<<<< HEAD

=======
    public boolean isTransit() {
        return isTransit;
    }

    @Override
    public NoteVO toVO() {
        return new ArrivalNoteOnServiceVO(date,isTransit,TransferNumber,from,BarcodeAndStates);
    }
>>>>>>> master
}