package businesslogic.finance;

<<<<<<< HEAD
=======
import po.CreditNotePO;
import connection.RemoteObjectGetter;
import dataservice.financedataservice.CreditNoteInputDataService;
>>>>>>> master
import businesslogicservice.financeblservice.CreditNoteInputBLService;
import util.ResultMsg;
import vo.CreditNoteVO;

/**
 * Created by kylin on 15/11/17.
<<<<<<< HEAD
 */
public class CreditNoteInput implements CreditNoteInputBLService {
    @Override
    public ResultMsg addReceipeDoc(CreditNoteVO vo) {
        return null;
=======
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
        if(!msg.isPass()) return msg;
        else return submitReceipeDoc(vo);
        
>>>>>>> master
    }

    @Override
    public ResultMsg submitReceipeDoc(CreditNoteVO vo) {
<<<<<<< HEAD
        return null;
=======
    	
    	CreditNotePO po = (CreditNotePO) vo.toPO();
    	
    	try {
    		boolean result = dataService.addCreditNote(po);
    		if(!result) {
    			return new ResultMsg(false,"收款单上传失败，请重试");
    		}
    	} catch (Exception e) {
    		return new ResultMsg(false,e.getMessage());
    	}
    	
    	
        return new ResultMsg(true);
>>>>>>> master
    }
}
