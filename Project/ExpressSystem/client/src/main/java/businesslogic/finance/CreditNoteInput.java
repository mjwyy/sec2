package businesslogic.finance;

import po.CreditNotePO;
import connection.RemoteObjectGetter;
import dataservice.exception.ElementNotFoundException;
import dataservice.financedataservice.CreditNoteInputDataService;
import util.RuntimeUserInfo;
import businesslogicservice.financeblservice.CreditNoteInputBLService;
import util.ResultMsg;
import vo.CreditNoteVO;

/**
 * Created by kylin on 15/11/17.
 * 
 * Finished.
 */
public class CreditNoteInput implements CreditNoteInputBLService {
	
	CreditNoteInputDataService dataService = null;
	
	public CreditNoteInput() {
		RemoteObjectGetter getter = new RemoteObjectGetter();
		dataService = (CreditNoteInputDataService) getter.getObjectByName("CreditNoteInputDataService");
	}
	
    @Override
    public ResultMsg addReceipeDoc(CreditNoteVO vo) {
        ResultMsg msg = vo.checkFormat();
        return msg;
    }

    @Override
    public ResultMsg submitReceipeDoc(CreditNoteVO vo) {
    	
    	CreditNotePO po = (CreditNotePO) vo.toPO();
    	
    	try {
    		boolean result = dataService.addCreditNote(po, RuntimeUserInfo.getNum());
    		if(!result) {
    			return new ResultMsg(false,"收款单上传失败，请重试");
    		}
    	} catch (Exception e) {
    		return new ResultMsg(false,e.getMessage());
    	}
    	
    	
        return new ResultMsg(true);
    }

	@Override
	public double getOrderMoney(String barcode) throws ElementNotFoundException {
		double result = 0.0;
		
		try {
			result = dataService.getOrderMoney(barcode);
		} catch (Exception e){
			throw new ElementNotFoundException(e.getMessage());
		}
		
		return result;
	}
}
