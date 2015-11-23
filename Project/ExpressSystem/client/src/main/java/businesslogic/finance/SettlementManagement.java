package businesslogic.finance;

import businesslogicservice.financeblservice.SettlementManagementBLService;
import util.ResultMsg;
import vo.IncomeNoteVO;

import java.util.ArrayList;

<<<<<<< HEAD
/**
 * Created by kylin on 15/11/17.
 */
public class SettlementManagement implements SettlementManagementBLService {
    @Override
    public ResultMsg addReceiveRecord(IncomeNoteVO vo) {
        return null;
=======
import po.IncomeNotePO;
import connection.RemoteObjectGetter;
import dataservice.commoditydataservice.InventoryDataService;
import dataservice.financedataservice.SettlementManagementDataService;

/**
 * Created by kylin on 15/11/17.
 * 
 * Finished.
 */
public class SettlementManagement implements SettlementManagementBLService {
	
	SettlementManagementDataService dataService = null;
	
	public SettlementManagement() {
		RemoteObjectGetter getter = new RemoteObjectGetter();
		dataService = (SettlementManagementDataService) getter.getObjectByName("SettlementManagementDataService");
	}
	
    @Override
    public ResultMsg addReceiveRecord(IncomeNoteVO vo) {
    	ResultMsg msg = vo.checkFormat();
    	if(!msg.isPass()) return msg;
    	
    	try {
    		boolean result = dataService.addIncomeNote((IncomeNotePO) vo.toPO());
    		if(!result) {
    			return new ResultMsg(false, "提交失败，请重试");
    		}
    	} catch (Exception e) {
    		return new ResultMsg(false, e.getMessage());
    	}
    	
    	return new ResultMsg(true);
>>>>>>> master
    }

    @Override
    public ArrayList<IncomeNoteVO> find(IncomeNoteVO vo) {
<<<<<<< HEAD
        return null;
=======
    	
    	ArrayList<IncomeNoteVO> result = new ArrayList<>();
    	ArrayList<IncomeNotePO> get = null;
    	try {
    		get = dataService.findAll();
    	} catch (Exception e) {
    		System.err.println("获取收款单失败：");
    		System.err.println(e.getMessage());
    		return result;
    	}
    	
    	for(IncomeNotePO po:get) {
    		result.add((IncomeNoteVO)po.toVO());
    	}
    	
    	
        return result;
>>>>>>> master
    }
}
